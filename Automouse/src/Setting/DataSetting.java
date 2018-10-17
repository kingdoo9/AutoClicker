package Setting;

import java.awt.Color;

public abstract class DataSetting {
	private int SmouseX;
	private int SmouseY;
	private int EmouseX;
	private int EmouseY;
	private int Number;
	private int repeat;
	private int Delay;
	private Color RGB;
	private char[] kind;
	
	//get, set function
	public int getSmouseX() {
		return SmouseX;
	}
	public void setSmouseX(int smouseX) {
		SmouseX = smouseX;
	}
	public int getSmouseY() {
		return SmouseY;
	}
	public void setSmouseY(int smouseY) {
		SmouseY = smouseY;
	}
	public int getEmouseX() {
		return EmouseX;
	}
	public void setEmouseX(int emouseX) {
		EmouseX = emouseX;
	}
	public int getEmouseY() {
		return EmouseY;
	}
	
	public void setEmouseY(int emouseY) {
		EmouseY = emouseY;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public int getRepeat() {
		return repeat;
	}
	public void setRepeat(int repeat) {
		this.repeat = repeat;
	}
	public Color getRGB() {
		return RGB;
	}
	public void setRGB(Color rGB) {
		RGB = rGB;
	}
	public int getDelay() {
		return Delay;
	}
	public void setDelay(int delay) {
		Delay = delay;
	}
	public char[] getKind() {
		return kind;
	}
	
	
}
