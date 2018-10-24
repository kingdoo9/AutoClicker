package Constants;

import java.util.Vector;

import Events.MouseEvent;
import Setting.DataSetting;

public class Constant {
	
	//프레임 bounds 세팅
	public static final int FrameWidth = 1000;
	public static final int Frameheight = 500;
	public static final int FrameBoundX = 500; // x축으로 얼만큼 떨어져서 생성되는가
	public static final int FrameBoundY = 500; // y축으로 얼만큼 떨어져서 생성되는가
	
	public static MouseEvent mouse = new MouseEvent(); // 마우스 이벤트 
	public static Vector<DataSetting> data = new Vector<DataSetting>(); //루틴값들을 저장해주고 문서화해주는 Vector
}
