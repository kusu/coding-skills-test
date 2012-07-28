package coding.test.toh;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class TohMain extends JPanel {

	/**
	 * @author kusu
	 */

	private BufferedImage image;

	enum DIR {
		UP, DOWN, LEFT, RIGHT
	}

	private static final long serialVersionUID = 9174402512355596895L;

	private void move(int n, DIR dir, Tower to) {
		Graphics g = image.getGraphics();

		int basex = 100 + 150 / 2 - 7;
		int basey = 300 + (n - 1) * 5;
		int rectx = basex - (n - 1) * 5;

		if (dir == DIR.UP) {
			while (basey >= 310) {
				g.setColor(Color.black);
				g.drawRect(rectx, basey, 20 + (n - 1) * 10, 5);
				basey -= 10;
				g.setColor(Color.blue);
				g.drawRect(rectx, basey, 20 + (n - 1) * 10, 5);
			}
		} else if (dir == DIR.DOWN) {
			while (basey >= 300 + (to.getLevel() - 1) * 5) {
				g.setColor(Color.black);
				g.drawRect(rectx, basey, 20 + (n - 1) * 10, 5);
				basey += 10;
				g.setColor(Color.blue);
				g.drawRect(rectx, basey, 20 + (n - 1) * 10, 5);
			}
		} else if (dir == DIR.RIGHT) {
			while (rectx <= 100 + 200 * to.getNumber()) {
				g.setColor(Color.black);
				g.drawRect(rectx, basey, 20 + (n - 1) * 10, 5);
				rectx += 10;
				g.setColor(Color.blue);
				g.drawRect(rectx, basey, 20 + (n - 1) * 10, 5);
			}
		} else {
			while (rectx >= 100 + 200 * to.getNumber()) {
				g.setColor(Color.black);
				g.drawRect(rectx, basey, 20 + (n - 1) * 10, 5);
				rectx -= 10;
				g.setColor(Color.blue);
				g.drawRect(rectx, basey, 20 + (n - 1) * 10, 5);
			}
		}
	}

	private void moveDisk(int n, Tower from, Tower to) {

		move(n, DIR.UP, to);

		if (from.getLevel() < to.getNumber()) {
			move(n, DIR.RIGHT, to);
		} else {
			move(n, DIR.LEFT, to);
		}
		move(n, DIR.DOWN, to);

	}

	private void solve(int n, Tower from, Tower to, Tower temp) {
		if (n == 1) {
			moveDisk(1, from, to);
			return;
		}
		solve(n - 1, from, temp, to);
		moveDisk(n, from, to);
		solve(n - 1, temp, to, from);
	}

	public void solvePuzzle(int n) {
		Tower from = new Tower(0);
		from.setLevel(n);
		Tower to = new Tower(2);
		to.setLevel(0);
		Tower temp = new Tower(1);
		temp.setLevel(0);
		solve(n, from, to, temp);
	}

	private void drawTowers(Graphics g) {
		g.setColor(Color.black);
		g.clearRect(0, 0, 800, 600);
		g.fillRect(0, 0, 800, 600);

		g.setColor(Color.blue);
		g.drawRect(100, 300, 150, 5);
		g.drawRect(300, 300, 150, 5);
		g.drawRect(500, 300, 150, 5);

		int towerx = 100 + 150 / 2;
		int towerHeight = 150;
		int towery = 150;

		g.drawRect(towerx, towery, 5, towerHeight);
		g.drawRect(towerx + 200, towery, 5, towerHeight);
		g.drawRect(towerx + 400, towery, 5, towerHeight);

		drawDisks(10, g);
	}

	private void drawDisks(int n, Graphics g) {
		g.setColor(Color.blue);
		int basex = 100 + 150 / 2 - 7;
		int basey = 300 - n * 5;
		for (int i = 0; i < n; i++) {
			g.drawRect(basex - i * 5, basey + i * 5, 20 + i * 10, 5);
		}
	}

	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		if (image == null) {
			image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB_PRE);
		}
		Graphics ofg = image.getGraphics();
		drawTowers(ofg);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, this);
	}
}
