package Panels;

import java.awt.Color;

import Constants.Constant;
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
		this.setBounds(Constant.PreferSize(500, 10, Constant.LeftWidth),Constant.PreferSize(465, 10, Constant.LeftHeight),Constant.PreferSize(500, 160, Constant.LeftWidth),Constant.PreferSize(465, 40, Constant.LeftHeight));
		this.add(new NomalLabel("F5: "+Language.Language[Language.Lan.Start.ordinal() + Language.LSelect], Constant.PreferSize(160, 10, this.getWidth()),Constant.PreferSize(40, 10, this.getHeight()),Constant.PreferSize(160, 60, this.getWidth()),Constant.PreferSize(40, 20, this.getHeight())));
		this.add(new NomalLabel("F6: "+Language.Language[Language.Lan.Stop.ordinal()+Language.LSelect], Constant.PreferSize(160, 80, this.getWidth()),Constant.PreferSize(40, 10, this.getHeight()),Constant.PreferSize(160, 60, this.getWidth()),Constant.PreferSize(40, 20, this.getHeight())));
		this.repaint();
	}
}
