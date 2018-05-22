package p1;

public class IconProducerManager {
	private Buffer<IconProducer> buffer;

	public IconProducerManager(Buffer<IconProducer> buffer) {
		this.buffer = buffer;
	}

	public void addIconProducer(IconProducer ic) {
		buffer.put(ic);
	}
}
