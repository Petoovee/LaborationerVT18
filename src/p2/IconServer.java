package p2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
/**
 * @IconServer is used to start up a server with any given IP and Port and let @IconClient to connect 
 * and receive Icon objects through the @ObjectOutputStream
 * @author Petar Nov
 *
 */
public class IconServer implements Runnable {
	private Thread server = new Thread(this);
	private IconManager iconManager;
	private int port;
	/**
	 * Constructor that takes in @IconManager to receive @Icon objects through @Observable & @Observer
	 * @param iconManager For the @Icon objects.
	 * @param port To have the server listening on.
	 */
	public IconServer(IconManager iconManager, int port) {
		this.iconManager = iconManager;
		this.port = port;
		server.start();
	}
	/**
	 * This @Thread	is used to start a server and listen for connections, once it finds a connection 
	 * it adds a new @Observer to the @IconManager and starts the @ClientHandler Thread.
	 */
	public void run() {
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			while (true) {
				try {
					System.out.println("Waiting for connection");
					Socket connection = serverSocket.accept();
					iconManager.addObserver(new ClientHandler(connection));
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * Private class that handles the clients that connect to the server.
	 * Once a client has connected the @IconManager will start notifying @Icon
	 * Objects to this @Observer and use the @ObjectOutputStream to send the data.
	 * @author Petar Nov
	 *
	 */
	private class ClientHandler extends Thread implements Observer {
		ObjectOutputStream oos;
		/**
		 * Constructor that takes in the @Socket for the @IconClient and initializes
		 * the OutputStream for the given Socket.
		 * @param socket @IconClient socket.
		 */
		public ClientHandler(Socket socket) {
			try {
				oos = new ObjectOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/**
		 * This is the update class from the implementation of @Observer.
		 * Once it receives a notification it sends out the @Object arg
		 * through the @ObjectOutputStream.
		 */
		public void update(Observable o, Object arg) {
			if (arg instanceof Icon) {
				Icon icon = (Icon) arg;
				try {
					oos.writeObject(icon);
					oos.flush();
				} catch (IOException e) {
					iconManager.deleteObserver(this);
					e.printStackTrace();
				}
			}
		}
	}
}
