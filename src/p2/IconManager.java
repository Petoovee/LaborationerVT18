package p2;

import java.util.Observable;

import javax.swing.Icon;

public class IconManager extends Observable {
	private Thread thread;
	Buffer<Icon> iconBuffer;

	public IconManager(Buffer<Icon> iconBuffer) {
		this.iconBuffer = iconBuffer;
		thread = new IM();
	}

	public void start() {
		thread.start();
	}

	private class IM extends Thread {
		public void run() {
			Icon icon = null;
			while (!Thread.interrupted()) {
				if (iconBuffer.size() != 0) {
					try {
						icon = iconBuffer.get();
					} catch (InterruptedException e) {
					}
					setChanged();
					notifyObservers(icon);
				}
			}
		}
	}
}
