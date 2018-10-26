package Constants;

import java.util.Vector;

import Events.MouseEvent;
import Setting.DataSetting;

public class Constant {
	
	//프레임 bounds 세팅
	public static final int FrameWidth = 1000;
	public static final int Frameheight = 500;
	
	public static MouseEvent mouse = new MouseEvent(); // 마우스 이벤트 
	public static Vector<DataSetting> data = new Vector<DataSetting>(); //루틴값들을 저장해주고 문서화해주는 Vector

	public static enum Language {English, Korean};
	
}
