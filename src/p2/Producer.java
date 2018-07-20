package p2;

import javax.swing.Icon;

/**
 * This class acts as a @Thread that takes in an arraylist of 
 * Icon objects and IconProducer objects.
 * @author Petar Nov
 *
 */
public class Producer extends Thread {
	private Buffer<IconProducer> prodBuffer;
	private Buffer<Icon> iconBuffer;
	/**
	 * A constructor that takes in 2 parameters and puts it into the instance variables.
	 * @param prodBuffer Can take a list of any class that implements IconProducer
	 * @param iconBuffer A list of Icon Objects.
	 */
	public Producer(Buffer<IconProducer> prodBuffer, Buffer<Icon> iconBuffer) {
		this.prodBuffer = prodBuffer;
		this.iconBuffer = iconBuffer;
	}
	/**
 	* The thread's run function checks that as long as it isnt interrupted
 	* it will put the next icon in the IconProducer @Buffer into the 
 	* Icon @Buffer to be displayed next. Also has a sleep depending on
 	* the parameter in one of the IconProducer classes. 
 	*/
	public void run() {
		while (!Thread.interrupted()) {
			try {
				IconProducer iconProd = prodBuffer.get();
				for (int times = 0; times < iconProd.times(); times++) {
					for (int index = 0; index < iconProd.size(); index++) {
						iconBuffer.put(iconProd.nextIcon());
						Thread.sleep(iconProd.delay());
					}
				}
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
		}
	}
}
