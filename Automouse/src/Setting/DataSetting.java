package Setting;

import java.awt.Color;
import java.io.Serializable;

public abstract class DataSetting implements Serializable{
	private static final long serialVersionUID = 1L;
	private int SmouseX=0, SmouseY=0, EmouseX=0, EmouseY=0; //���콺 ��ġ��
	private int Number=1, Repeat=1, Delay=100; // Ƚ��, �ʴ�ݺ�Ƚ��, ���ð�
	private Color RGB = new Color(255,255,255); //��
	private char[] Kind; // �� �����Ͱ� �����ϴ� ����
	private String Name; // ������ �̸�
	private boolean Saved = false, Holdon = false, ChangedColor = false; //����Ǿ���, �������� ����ΰ�, ���� �ٲ�� ���۵Ǵ°�.
	
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
