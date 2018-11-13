package Constants;

import java.util.Vector;

import Events.MouseEvent;
import Setting.DataSetting;

public class Constant {
	
	//������ bounds ����
	public static int FrameWidth = 1000;
	public static int Frameheight = 500;
	public static int LeftWidth, LeftHeight;
	public static int RightWidth, RightHeight;
	
	public static MouseEvent mouse = new MouseEvent(); // ���콺 �̺�Ʈ 
	public static Vector<DataSetting> data = new Vector<DataSetting>(); //��ƾ������ �������ְ� ����ȭ���ִ� Vector

	public static enum Language {English, Korean};
	
	public static int PreferSize(int original, int size, int changed) {return (int) ((double)changed/((double)original/(double)size)); }
	
	
}
