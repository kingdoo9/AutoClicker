package Panels;

import java.awt.Color;

import Constants.Constant;
import Setting.PanelSetting;

public class RightPanel extends PanelSetting{
	private static final long serialVersionUID = 1L;

	public RightPanel(int x, int y, int width, int height, Color color) {
		
		super(x, y, width, height, color); //대부분 설정은 상위class인 PanelSetting에 있음.
	}
	
	public void View() {
		this.removeAll();
		
		Constant.RightWidth = this.getWidth();
		Constant.RightHeight = this.getHeight();
		
		this.setBounds(Constant.PreferSize(1000, 500, Constant.FrameWidth),0,Constant.PreferSize(1000, 495, Constant.FrameWidth),Constant.PreferSize(500, 465, Constant.Frameheight));
		this.repaint();
	}

}
