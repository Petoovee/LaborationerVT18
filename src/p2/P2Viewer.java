package p2;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class P2Viewer extends JPanel implements Callback {
	private IconClient client;
	private JLabel lblIcon = new JLabel();

	public P2Viewer(IconClient client, int width, int height) {
		this.client = client;
		client.addCallback(this);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		lblIcon.setOpaque(true);
		add(lblIcon);
		setPreferredSize(new Dimension(width, height));
	}

	public void setIcon(Icon icon) {
		lblIcon.setIcon(icon);
	}

	public void notify(Icon icon) {
		setIcon(icon);
	}

}
