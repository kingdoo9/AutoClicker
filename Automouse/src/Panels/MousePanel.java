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
		this.setBounds(Constant.PreferSize(500, 180, Constant.LeftWidth),Constant.PreferSize(465, 10, Constant.LeftHeight),Constant.PreferSize(500, 195, Constant.LeftWidth),Constant.PreferSize(465, 40, Constant.LeftHeight));
		this.add(new NomalLabel(Language.Language[Language.Lan.mouse.ordinal()+Language.LSelect]+"   X: "+Constant.mouse.MouseGetX()+"   Y: "+Constant.mouse.MouseGetY(), Constant.PreferSize(195, 10, this.getWidth()),Constant.PreferSize(40, 10, this.getHeight()),Constant.PreferSize(195, 175, this.getWidth()),Constant.PreferSize(40, 20, this.getHeight())));
		
		this.repaint();
	}
}
