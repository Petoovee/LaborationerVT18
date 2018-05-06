package p1;

import javax.swing.Icon;

public class FileProducer implements IconProducer {

	public FileProducer(String filename) {
	}

	public int delay() {
		return 0;
	}

	@Override
	public int times() {
		return 0;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Icon nextIcon() {
		return null;
	}

}
