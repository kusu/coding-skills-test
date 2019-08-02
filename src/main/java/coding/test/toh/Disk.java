package coding.test.toh;

public class Disk {
    private int diskNumber; // diskNumber from 0 to maxDisks.
    private int x, y;

    public Disk(int diskNum) {
        this.diskNumber = diskNum;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}