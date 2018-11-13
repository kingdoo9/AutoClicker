package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import Constants.Constant;
import Constants.Language;
import Setting.ButtonSetting;
import Setting.PanelSetting;

public class SettingPanel extends PanelSetting{
	private static final long serialVersionUID = 1L;
	private static ButtonSetting Click, Drag, Delay, ColorS, ColorE;
	private static RightPanel normal, details;
	
	public SettingPanel(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color); //대부분 설정은 상위class인 PanelSetting에 있음.
		// TODO Auto-generated constructor stub
	}
	
	public void View() {
		this.removeAll();
		this.setBounds(Constant.PreferSize(500, 270, Constant.LeftWidth),Constant.PreferSize(465, 60, Constant.LeftHeight),Constant.PreferSize(500, 220, Constant.LeftWidth),Constant.PreferSize(465, 350, Constant.LeftHeight));

		normal = new RightPanel(Constant.PreferSize(220, 5, this.getWidth()),Constant.PreferSize(350, 5, this.getHeight()),Constant.PreferSize(220, 210, this.getWidth()),Constant.PreferSize(350, 140, this.getHeight()),Color.WHITE); // 일반 설정 패널
		details = new RightPanel(Constant.PreferSize(220, 5, this.getWidth()),Constant.PreferSize(350, 180, this.getHeight()),Constant.PreferSize(220, 210, this.getWidth()),Constant.PreferSize(350, 100, this.getHeight()),Color.WHITE); // 고급 설정 패널
		normal.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.blue),Language.Language[Language.Lan.general_settings.ordinal()+Language.LSelect]));
		details.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.blue),Language.Language[Language.Lan.advanced_settings.ordinal()+Language.LSelect]));
		
		Click = new ButtonSetting(Language.Language[Language.Lan.click.ordinal()+Language.LSelect],"Click Setting", Constant.PreferSize(210, 10, normal.getWidth()),Constant.PreferSize(140, 20, normal.getHeight()),Constant.PreferSize(210, 190, normal.getWidth()),Constant.PreferSize(140, 30, normal.getHeight()));
		Click.addActionListener(new myActionListener()); //버튼의 설정은 페이지 하단에 프로그래밍함.
		
		Drag = new ButtonSetting(Language.Language[Language.Lan.Drag.ordinal()+Language.LSelect],"Drag Setting", Constant.PreferSize(210, 10, normal.getWidth()),Constant.PreferSize(140, 60, normal.getHeight()),Constant.PreferSize(210, 190, normal.getWidth()),Constant.PreferSize(140, 30, normal.getHeight()));
		Drag.addActionListener(new myActionListener());
		
		Delay = new ButtonSetting(Language.Language[Language.Lan.Delay.ordinal()+Language.LSelect],"Delay Setting", Constant.PreferSize(210, 10, normal.getWidth()),Constant.PreferSize(140, 100, normal.getHeight()),Constant.PreferSize(210, 190, normal.getWidth()),Constant.PreferSize(140, 30, normal.getHeight()));
		Delay.addActionListener(new myActionListener());

		ColorS = new ButtonSetting(Language.Language[Language.Lan.ColorS.ordinal()+Language.LSelect],"Color Start", Constant.PreferSize(210, 10, details.getWidth()),Constant.PreferSize(100, 20, details.getHeight()),Constant.PreferSize(210, 190, details.getWidth()),Constant.PreferSize(100, 30, details.getHeight()));
		ColorS.addActionListener(new myActionListener());
		
		ColorE = new ButtonSetting(Language.Language[Language.Lan.ColorE.ordinal()+Language.LSelect],"Color End", Constant.PreferSize(210, 10, details.getWidth()),Constant.PreferSize(100, 60, details.getHeight()),Constant.PreferSize(210, 190, details.getWidth()),Constant.PreferSize(100, 30, details.getHeight()));
		ColorE.addActionListener(new myActionListener());
		
		normal.add(Click);
		normal.add(Drag);
		normal.add(Delay);
		details.add(ColorS);
		details.add(ColorE);
		
		this.add(normal);
		this.add(details);
		
		this.repaint();
	}
	
	class myActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch(e.getActionCommand()) {
			case "Click Setting": 
				Constant.RightP.onSee_Focus(); //오른쪽 페이지를 보이게끔 설정
				Constant.RightP.setData(new Data.Click()); //새롭게 데이터를 설정.
				Constant.RightP.view();
				break;
			case "Drag Setting": 
				Constant.RightP.onSee_Focus();
				Constant.RightP.setData(new Data.Drag());
				Constant.RightP.view();
				break;
			case "Delay Setting": 
				Constant.RightP.onSee_Focus();
				Constant.RightP.setData(new Data.Delay());
				Constant.RightP.view();
				break;
			case "Color Start": 
				Constant.RightP.onSee_Focus();
				Constant.RightP.setData(new Data.ColorS());
				Constant.RightP.view();
				break;
			case "Color End":
				Constant.RightP.onSee_Focus();
				Constant.RightP.setData(new Data.ColorE());
				Constant.RightP.view();
				break;
				
			}
		}
	}
}
