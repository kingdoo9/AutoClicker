package Panels;

import java.awt.Color;

import Constants.Constant;
import Setting.ButtonSetting;
import Setting.DataSetting;
import Setting.PanelSetting;

public class RoutinePanel extends PanelSetting{
	private static final long serialVersionUID = 1L;
	private int BoundX;
	private int BoundY;

	public RoutinePanel(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
		BoundX = 10; BoundY =10;
		
		for(DataSetting data : Constant.data) {
			this.add(new ButtonSetting(data.getName(), BoundX, BoundY, 150, 30));
			BoundY += 40;
		}
		
	}
}
