package p2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 * A class that implements the IconProducer
 * It is used to take in a file and read it and make an IconList with all the icons.
 * Also reads the repeat sequence and delay that is also in the text file.
 * @author UncleBen
 *
 */
public class FileProducer implements IconProducer {
	private int repeatSequence, delay;
	private int size;
	private int index = 0;
	ArrayList<Icon> iconList = new ArrayList<Icon>();
	/**
	 * Constructor that takes in the file path and reads that file to then save it in the 
	 * instance variables.
	 * @param filename File Path.
	 */
	public FileProducer(String filename) {
		try {
			BufferedReader bw = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
			Icon icon;
			this.repeatSequence = Integer.parseInt(bw.readLine());
			this.delay = Integer.parseInt(bw.readLine());
			String line = bw.readLine();
			while (line != null) {
				icon = new ImageIcon(line);
				iconList.add(icon);
				line = bw.readLine();
			}
		} catch (IOException e) {
		}

	}
	/**
	 * @return The delay value from the file.
	 */
	public int delay() {
		return this.delay;
	}

	/**
	 * @return The amount of times it will repeat the Icon cycle.
	 */
	public int times() {
		return this.repeatSequence;
	}

	/**
	 * @return The amount of images saved in the Icon List
	 */
	public int size() {
		return this.iconList.size();
	}

	/**
	 * @return Returns the next Icon in the Icon List using post incrementing index.
	 */
	public Icon nextIcon() {
		if (this.index >= iconList.size())
			this.index = 0;
		return iconList.get(this.index++);
	}

}
