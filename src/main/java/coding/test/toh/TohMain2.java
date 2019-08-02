package coding.test.toh;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TohMain2 extends JPanel {

    enum DIR {
        LEFT, RIGHT, UP, DOWN
    }

    private int numDisks;
    private BufferedImage image;

    public TohMain2(int disks) {
        this.numDisks = disks;
        image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB_PRE);
    }

    public void drawTowers() {

        Graphics g = image.getGraphics();

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

    }

    private Disk[] createDisks() {

        Disk[] disks = new Disk[numDisks];

        for (int i = 0; i < numDisks; i++) {
            disks[i] = new Disk(i + 1);

            int recty = 300 + (i) * 5;
            int rectx = 168 - (i) * 5;

            disks[i].setX(rectx);
            disks[i].setY(recty);
        }

        return disks;

    }

    public void drawDisks() {

        Graphics g = image.getGraphics();

        g.setColor(Color.blue);
        int basex = 168;
        int basey = 300 - numDisks * 5;
        for (int i = 0; i < numDisks; i++) {
            g.drawRect(basex - i * 5, basey + i * 5, 20 + i * 10, 5);
        }
    }

    public void render(Graphics g) {

        // create black background
        g.setColor(Color.black);
        g.clearRect(0, 0, 800, 600);
        g.fillRect(0, 0, 800, 600);

        // fill the disks
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(image, 0, 0, this);

        // re-draw towers
        drawTowers();
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void move(int n, Disk[] disks, DIR dir, Tower to) {
        Graphics g = image.getGraphics();

        int basey = disks[n - 1].getY();
        int rectx = disks[n - 1].getX();

        if (dir == DIR.UP) {
            while (basey >= 140) {
                g.setColor(Color.black);
                g.drawRect(rectx, basey, 20 + (n - 1) * 10, 5);
                basey -= 5;
                g.setColor(Color.blue);
                g.drawRect(rectx, basey, 20 + (n - 1) * 10, 5);

                disks[n - 1].setY(basey);
                sleep();
                repaint();
            }
        } else if (dir == DIR.DOWN) {
            while (basey <= 290 - (to.getLevel() * 5)) {
                g.setColor(Color.black);
                g.drawRect(rectx, basey, 20 + (n - 1) * 10, 5);
                basey += 5;
                g.setColor(Color.blue);
                g.drawRect(rectx, basey, 20 + (n - 1) * 10, 5);

                disks[n - 1].setY(basey);

                sleep();
                repaint();
            }
        } else if (dir == DIR.RIGHT) {

            int width = 20 + (n - 1) * 10;
            int maxX = 175 + 200 * to.getNumber() - width / 2;

            while (rectx <= maxX) {
                g.setColor(Color.black);
                g.drawRect(rectx, basey, width, 5);
                rectx += 5;
                g.setColor(Color.blue);
                g.drawRect(rectx, basey, width, 5);

                disks[n - 1].setX(rectx);

                sleep();
                repaint();
            }
        } else {

            int width = 20 + (n - 1) * 10;
            int minX = 180 + 200 * to.getNumber() - width / 2;

            while (rectx > minX) {
                g.setColor(Color.black);
                g.drawRect(rectx, basey, width, 5);
                rectx -= 5;
                g.setColor(Color.blue);
                g.drawRect(rectx, basey, width, 5);

                disks[n - 1].setX(rectx);
                sleep();
                repaint();
            }
        }
    }

    private void moveDisk(int n, Disk[] disks, Tower from, Tower to) {

        // move disk up
        move(n, disks, DIR.UP, to);

        if (from.getNumber() < to.getNumber()) {
            // based on source and target disk move left or right
            move(n, disks, DIR.RIGHT, to);
        } else {
            move(n, disks, DIR.LEFT, to);
        }

        //put down disk using move down
        move(n, disks, DIR.DOWN, to);

        // set the level ie. no. of disks filled in tower
        from.setLevel(from.getLevel() - 1);
        to.setLevel(to.getLevel() + 1);

    }

    private void solve(int n, Disk[] disks, Tower from, Tower to, Tower temp) {
        if (n == 1) {
            moveDisk(1, disks, from, to);
            return;
        }
        solve(n - 1, disks, from, temp, to);
        moveDisk(n, disks, from, to);
        solve(n - 1, disks, temp, to, from);
    }

    public void solvePuzzle() {
        Disk[] disks = createDisks();

        Tower from = new Tower(0);
        from.setLevel(numDisks);
        Tower to = new Tower(2);
        to.setLevel(0);
        Tower temp = new Tower(1);
        temp.setLevel(0);
        solve(numDisks, disks, from, to, temp);
    }

    private void sleep() {
        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void paint(Graphics g) {
        render(g);
    }

}
