package Setting;

import java.awt.Color;
import java.io.Serializable;

public abstract class DataSetting implements Serializable{
	private static final long serialVersionUID = 1L;
	private int SmouseX=0, SmouseY=0, EmouseX=0, EmouseY=0; //마우스 위치들
	private int Number=1, Repeat=1, Delay=100; // 횟수, 초당반복횟수, 대기시간
	private Color RGB = new Color(255,255,255); //색
	private char[] Kind; // 각 데이터가 포함하는 종류
	private String Name; // 데이터 이름
	private boolean Saved = false, Holdon = false, ChangedColor = false; //저장되었나, 색설정이 대기인가, 색이 바뀌면 시작되는가.
	
	//get, set function
	public int getSmouseX() {return SmouseX;}
	public void setSmouseX(int smouseX) {SmouseX = smouseX;}
	public int getSmouseY() {return SmouseY;}
	public void setSmouseY(int smouseY) {SmouseY = smouseY;}
	public int getEmouseX() {return EmouseX;}
	public void setEmouseX(int emouseX) {EmouseX = emouseX;}
	public int getEmouseY() {return EmouseY;}
	public void setName(String name) {Name = name;}
	public String getName() {return Name;}
	public void setEmouseY(int emouseY) {EmouseY = emouseY;}
	public int getNumber() {return Number;}
	public void setNumber(int number) {Number = number;}
	public int getRepeat() {return Repeat;}
	public void setRepeat(int repeat) {Repeat = repeat;}
	public Color getRGB() {return RGB;}
	public void setRGB(Color rGB) {RGB = rGB;}
	public int getDelay() {return Delay;}
	public void setDelay(int delay) {Delay = delay;}
	public void setKind(char[] kind) {Kind = kind;}
	public char[] getKind() {return Kind;}
	public boolean isSaved() {return Saved;}
	public void setSaved(boolean saved) {Saved = saved;}
	public boolean isHoldon() {return Holdon;}
	public void setHoldon(boolean holdon) {Holdon = holdon;}
	public boolean isChangedColor() {return ChangedColor;}
	public void setChangedColor(boolean changedColor) {ChangedColor = changedColor;}
	
}
