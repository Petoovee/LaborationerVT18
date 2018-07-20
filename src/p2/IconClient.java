package p2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.Icon;
/**
 * Client side that takes in Icon objects from the @IconServer and displays it on the P2Viewer using Callback.
 * @author UncleBen
 *
 */
public class IconClient implements Runnable {
	private ArrayList<Callback> listener = new ArrayList<Callback>();
	private Icon icon;
	private String ip;
	private int port;
	private Thread client = new Thread(this);
	/**
	 * 
	 * @param ip IP to the server you'd like to connect to.
	 * @param port Port that the server is listed on.
	 */
	public IconClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
		client.start();
	}
	/**
	 * Standard run method for this thread, connects Socket to the server and starts to read objects
	 * once it receive's the icon object it sends it to the P2Viewer using Callback notifying.
	 * @notifyCallback
	 */
	public void run() {
		try (Socket connection = new Socket(ip, port)) {
			ObjectInputStream inStream = new ObjectInputStream(connection.getInputStream());
			while (true) {
				try {
					icon = (Icon) inStream.readObject();
					notifyCallback(icon);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Used for the @P2Viewer class to enable Callback between @IconClient and @P2Viewer
	 * @param listener Used to add Callback implementations.
	 */
	public void addCallback(Callback listener) {
		this.listener.add(listener);
	}
	/**
	 * This notifies classes with Callback implementations with the Icon object.
	 * @param icon
	 */
	public void notifyCallback(Icon icon) {
		for (Callback list : listener) {
			list.notify(icon);
		}
	}
}
