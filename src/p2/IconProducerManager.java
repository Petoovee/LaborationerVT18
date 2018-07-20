package p2;

public class IconProducerManager {
	private Buffer<IconProducer> buffer;
	public IconProducerManager(Buffer<IconProducer> param) {
		this.buffer = param;
	}
	public void addIconProducer(IconProducer param) {
		buffer.put(param);
	}
}
