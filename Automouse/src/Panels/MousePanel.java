package Panels;

import java.awt.Color;

import Events.MouseEvent;
import Setting.LabelSetting;
import Setting.PanelSetting;

public class MousePanel extends PanelSetting{
	private static final long serialVersionUID = 1L;

	public MousePanel(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
		MouseEvent me = new MouseEvent();
		// TODO Auto-generated constructor stub
   		this.add(new LabelSetting("Mouse       X: "+me.MouseGetX()+"     Y: "+me.MouseGetY(), 10, 10, 250, 20));
	}

}