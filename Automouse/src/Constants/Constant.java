package Constants;

import java.awt.Color;
import java.util.Vector;

import Data.Setting;
import Events.MouseEvent;
import Panels.RightSettingPanel;
import Setting.DataSetting;

public class Constant {
	
	//������ bounds ����
	public static int FrameWidth = 1000;
	public static int Frameheight = 500;
	public static int LeftWidth, LeftHeight; //���� �г��� ũ��
	public static int RightWidth, RightHeight; //������ �г��� ũ��
	public static int FontSize, Page=1; //��Ʈ ������, routine �г��� ������
	public static Setting setting = new Setting(); //���� �г�
	public static RightSettingPanel RightP = new RightSettingPanel(10, 10, 475, 445, Color.white); // ������ �����г�

	
	public static MouseEvent mouse = new MouseEvent(); // ���콺 �̺�Ʈ 
	public static Vector<DataSetting> data = new Vector<DataSetting>(); //��ƾ������ �������ְ� ����ȭ���ִ� Vector
	public static int[] Font = {13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
	
	//ũ�⺯��� ����ȭ�� ũ�⸦ ã���ִ� �Լ�
	public static int PreferSize(int original, int size, int changed) {return (int) ((double)changed/((double)original/(double)size)); }
	
	
}
