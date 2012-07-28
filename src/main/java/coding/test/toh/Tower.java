package coding.test.toh;

public class Tower {

	private int level;
	private final int number;
	public Tower(int number) {
		this.number=number;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void setLevel(int level) {
		this.level=level;
	}
}
