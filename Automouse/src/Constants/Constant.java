package Constants;

import java.util.Vector;

import Events.MouseEvent;
import Setting.DataSetting;

public class Constant {
	
	//������ bounds ����
	public static final int FrameWidth = 1000;
	public static final int Frameheight = 500;
	
	public static MouseEvent mouse = new MouseEvent(); // ���콺 �̺�Ʈ 
	public static Vector<DataSetting> data = new Vector<DataSetting>(); //��ƾ������ �������ְ� ����ȭ���ִ� Vector

	public static enum Language {English, Korean};
	
}
