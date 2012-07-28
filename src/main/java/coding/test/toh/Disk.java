package coding.test.toh;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Disk extends JPanel {
	private int diskNumber; // diskNumber from 0 to maxDisks.
	private int x, y;

	@Override
	public void paintComponent(Graphics g) {
		g.drawLine(x, y, diskNumber + 2, 5);
	}
}