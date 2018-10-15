package Data;

public class Click {
	private int mouseX;
	private int mouseY;
	private int Count;
	private int repeat;

	public void setX(int x) {
		this.mouseX = x;
	}
	public void setY(int y) {
		this.mouseY = y;
	}
	public void setCount(int c) {
		this.Count = c;
	}
	public void setrepeat(int r) {
		this.repeat = r;
	}
	
	public int getCount() {
		return Count;
	}
	public int getMouseX() {
		return mouseX;
	}
	public int getMouseY() {
		return mouseY;
	}
	public int getRepeat() {
		return repeat;
	}
	
}
