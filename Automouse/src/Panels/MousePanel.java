package Panels;

import java.awt.Color;

import Constants.Constant;
import Labels.NomalLabel;
import Setting.PanelSetting;

public class MousePanel extends PanelSetting{
	private static final long serialVersionUID = 1L;

	public MousePanel(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color); //대부분 설정은 상위class인 PanelSetting에 있음.
	}
	
	public void View() { //화면을 갱신한다.
		this.removeAll();
		
		this.add(new NomalLabel("현 좌표:       X: "+Constant.mouse.MouseGetX()+"     Y: "+Constant.mouse.MouseGetY(), 10, 10, 250, 20));
		
		this.repaint();
	}
}
