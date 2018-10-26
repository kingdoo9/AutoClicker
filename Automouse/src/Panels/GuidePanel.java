package Panels;

import java.awt.Color;

import Constants.Language;
import Labels.NomalLabel;
import Setting.PanelSetting;

public class GuidePanel extends PanelSetting{
	private static final long serialVersionUID = 1L;

	//F5는 시작 F6은 정지를 표시해주는 패널
	public GuidePanel(int x, int y, int width, int height, Color color) { 
		
		super(x, y, width, height, color); //대부분 설정은 상위class인 PanelSetting에 있음.
	}
	
	public void View() {
		this.removeAll();
		this.add(new NomalLabel("F5: "+Language.Language[Language.Lan.Start.ordinal() + Language.LSelect], 10, 10, 80, 20));
		this.add(new NomalLabel("F6: "+Language.Language[Language.Lan.Stop.ordinal()+Language.LSelect], 100, 10, 80, 20));
		this.repaint();
	}
}
