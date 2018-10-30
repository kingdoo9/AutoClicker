package Panels;

import java.awt.Color;

import Constants.Constant;
import Constants.Language;
import Labels.NomalLabel;
import Setting.PanelSetting;

public class MousePanel extends PanelSetting{
	private static final long serialVersionUID = 1L;

	public MousePanel(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color); //��κ� ������ ����class�� PanelSetting�� ����.
	}
	
	public void View() { //ȭ���� �����Ѵ�.
		this.removeAll();
		
		this.add(new NomalLabel(Language.Language[Language.Lan.mouse.ordinal()+Language.LSelect]+"   X: "+Constant.mouse.MouseGetX()+"   Y: "+Constant.mouse.MouseGetY(), 10, 10, 175, 20));
		
		this.repaint();
	}
}
