package Panels;

import java.awt.Color;
import java.awt.Component;

import Setting.ButtonSetting;
import Setting.DataSetting;
import Setting.LabelSetting;
import Setting.PanelSetting;

public class SettingPanel extends PanelSetting{
	private static final long serialVersionUID = 1L;

	public SettingPanel(int x, int y, int width, int height, Color color, RightSettingPanel rightsetting) {
		super(x, y, width, height, color);
		// TODO Auto-generated constructor stub
		
		this.add(new ButtonSetting("Click Setting", 10, 10, 200, 30,rightsetting));
		this.add(new ButtonSetting("Drag Setting", 10, 50, 200, 30,rightsetting));
		this.add(new ButtonSetting("Delay Setting", 10, 90, 200, 30,rightsetting));
		
		this.add(new LabelSetting("if", 10, 150, 200, 20));
		this.add(new ButtonSetting("Color Start", 10, 180, 200, 30,rightsetting));
		this.add(new ButtonSetting("Color End", 10, 220, 200, 30,rightsetting));
	}

	@Override
	public void view(DataSetting data) {
		// TODO Auto-generated method stub
		
	}

}
