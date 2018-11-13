package Constants;

import java.awt.Color;
import java.util.Vector;

import Events.MouseEvent;
import Panels.RightSettingPanel;
import Setting.DataSetting;

public class Constant {
	
	//프레임 bounds 세팅
	public static int FrameWidth = 1000;
	public static int Frameheight = 500;
	public static int LeftWidth, LeftHeight;
	public static int RightWidth, RightHeight;
	public static RightSettingPanel RightP = new RightSettingPanel(10, 10, 475, 445, Color.white);	
	
	public static MouseEvent mouse = new MouseEvent(); // 마우스 이벤트 
	public static Vector<DataSetting> data = new Vector<DataSetting>(); //루틴값들을 저장해주고 문서화해주는 Vector

	public static enum Language {English, Korean};
	
	public static int PreferSize(int original, int size, int changed) {return (int) ((double)changed/((double)original/(double)size)); }
	
	
}
