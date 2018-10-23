package Panels;

import java.awt.Color;
import Setting.PanelSetting;

public class GuidePanel extends PanelSetting{
	private static final long serialVersionUID = 1L;

	public GuidePanel(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
		// TODO Auto-generated constructor stub
		this.add(new NomalLabel("F5: start", 10, 10, 80, 20));
		this.add(new NomalLabel("F6: stop", 100, 10, 80, 20));
	}
}
