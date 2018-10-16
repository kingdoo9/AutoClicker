package Panels;

import java.awt.Color;

import Events.MouseEvent;
import Setting.ButtonSetting;
import Setting.PanelSetting;

public class RightSettingPanel extends PanelSetting{
	private static final long serialVersionUID = 1L;
	ButtonSetting save = new ButtonSetting("save", 20, 405, 50, 30,this);
	
	
	public RightSettingPanel(int x, int y, int width, int height, Color color) {
		// TODO Auto-generated constructor stub
		super(x, y, width, height, color);
		MouseEvent me = new MouseEvent();
		this.add(save);
		this.setVisible(false);
	}

}
