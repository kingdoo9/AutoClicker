package Setting;

import java.awt.Color;
import java.io.Serializable;

public abstract class DataSetting implements Serializable{
	private static final long serialVersionUID = 1L;
	private int SmouseX=0;
	private int SmouseY=0;
	private int EmouseX=0;
	private int EmouseY=0;
	private int Number=1;
	private int repeat=1;
	private int Delay=100;
	private Color RGB;
	private char[] kind;
	private String name;
	private boolean saved = false;
	
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
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
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
	public void setKind(char[] kind) {
		this.kind = kind;
	}
	public char[] getKind() {
		return kind;
	}
	public boolean isSaved() {
		return saved;
	}
	public void setSaved(boolean saved) {
		this.saved = saved;
	}
	
}
