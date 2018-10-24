package Panels;

import java.awt.Color;

import Constants.Constant;
import Labels.NomalLabel;
import Setting.PanelSetting;

public class MousePanel extends PanelSetting{
	private static final long serialVersionUID = 1L;

	public MousePanel(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
		// TODO Auto-generated constructor stub
   		this.add(new NomalLabel("Mouse       X: "+Constant.mouse.MouseGetX()+"     Y: "+Constant.mouse.MouseGetY(), 10, 10, 250, 20));
	}

}
