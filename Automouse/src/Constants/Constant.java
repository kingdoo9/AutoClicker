package Constants;

import java.awt.Color;
import java.util.Vector;

import Data.Setting;
import Events.MouseEvent;
import Panels.RightSettingPanel;
import Setting.DataSetting;

public class Constant {
	
	//프레임 bounds 세팅
	public static int FrameWidth = 1000;
	public static int Frameheight = 500;
	public static int LeftWidth, LeftHeight; //왼쪽 패널의 크기
	public static int RightWidth, RightHeight; //오른쪽 패널의 크기
	public static int FontSize, Page=1; //폰트 사이즈, routine 패널의 페이지
	public static Setting setting = new Setting(); //설정 패널
	public static RightSettingPanel RightP = new RightSettingPanel(10, 10, 475, 445, Color.white); // 오른쪽 설정패널

	
	public static MouseEvent mouse = new MouseEvent(); // 마우스 이벤트 
	public static Vector<DataSetting> data = new Vector<DataSetting>(); //루틴값들을 저장해주고 문서화해주는 Vector
	public static int[] Font = {13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
	
	//크기변경시 최적화된 크기를 찾아주는 함수
	public static int PreferSize(int original, int size, int changed) {return (int) ((double)changed/((double)original/(double)size)); }
	
	
}
