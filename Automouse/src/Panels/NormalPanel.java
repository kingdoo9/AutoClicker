package Panels;

import java.awt.Color;
import Setting.PanelSetting;

public class NormalPanel extends PanelSetting{
	private static final long serialVersionUID = 1L;

	public NormalPanel(int x, int y, int width, int height, Color color) {
		
		super(x, y, width, height, color); //대부분 설정은 상위class인 PanelSetting에 있음.
	}

}
