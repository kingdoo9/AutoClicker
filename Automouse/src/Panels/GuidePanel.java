package Panels;

import java.awt.Color;

import Constants.Language;
import Labels.NomalLabel;
import Setting.PanelSetting;

public class GuidePanel extends PanelSetting{
	private static final long serialVersionUID = 1L;

	//F5�� ���� F6�� ������ ǥ�����ִ� �г�
	public GuidePanel(int x, int y, int width, int height, Color color) { 
		
		super(x, y, width, height, color); //��κ� ������ ����class�� PanelSetting�� ����.
	}
	
	public void View() {
		this.removeAll();
		this.add(new NomalLabel("F5: "+Language.Language[Language.Lan.Start.ordinal() + Language.LSelect], 10, 10, 80, 20));
		this.add(new NomalLabel("F6: "+Language.Language[Language.Lan.Stop.ordinal()+Language.LSelect], 100, 10, 80, 20));
		this.repaint();
	}
}
