package ws2;

import java.util.Date;

import javax.swing.ImageIcon;

public class UserMessage {
	private String title, content;
	private ImageIcon image;
	private Date sent, arrived, delivered;

	public static void main(String[] args) {
		Date sent = new Date();
		sent.setTime(new Date().getTime());
		System.out.println(sent.toString());
	}

	public UserMessage(String title, String content, ImageIcon image) {
		this.title = title;
		this.content = content;
		this.image = image;
		this.sent.setTime(new Date().getTime());
		System.out.println(this.sent.toString());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public Date getSent() {
		return sent;
	}

	public void setSent(Date sent) {
		this.sent = sent;
	}

	public Date getArrived() {
		return arrived;
	}

	public void setArrived(Date arrived) {
		this.arrived = arrived;
	}

	public Date getDelivered() {
		return delivered;
	}

	public void setDelivered(Date delivered) {
		this.delivered = delivered;
	}
}
