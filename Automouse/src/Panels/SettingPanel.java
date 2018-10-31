package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import Constants.Language;
import Setting.ButtonSetting;
import Setting.PanelSetting;

public class SettingPanel extends PanelSetting{
	private static final long serialVersionUID = 1L;
	private static RightSettingPanel Rightsetting;
	private static ButtonSetting Click, Drag, Delay, ColorS, ColorE;
	private static NormalPanel normal, details;
	
	public SettingPanel(int x, int y, int width, int height, Color color, RightSettingPanel rightsetting) {
		super(x, y, width, height, color); //대부분 설정은 상위class인 PanelSetting에 있음.
		// TODO Auto-generated constructor stub
		Rightsetting = rightsetting; //버튼에서 쓰기위해 전역변수로 선언함.
	}
	
	public void View() {
		this.removeAll();
		
		normal = new NormalPanel(5, 5, 210, 140,Color.WHITE); // 일반 설정 패널
		details = new NormalPanel(5, 180, 210, 100,Color.WHITE); // 고급 설정 패널
		normal.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.blue),Language.Language[Language.Lan.general_settings.ordinal()+Language.LSelect]));
		details.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.blue),Language.Language[Language.Lan.advanced_settings.ordinal()+Language.LSelect]));
		
		Click = new ButtonSetting(Language.Language[Language.Lan.click.ordinal()+Language.LSelect],"Click Setting", 10, 20, 190, 30);
		Click.addActionListener(new myActionListener()); //버튼의 설정은 페이지 하단에 프로그래밍함.
		
		Drag = new ButtonSetting(Language.Language[Language.Lan.Drag.ordinal()+Language.LSelect],"Drag Setting", 10, 60, 190, 30);
		Drag.addActionListener(new myActionListener());
		
		Delay = new ButtonSetting(Language.Language[Language.Lan.Delay.ordinal()+Language.LSelect],"Delay Setting", 10, 100, 190, 30);
		Delay.addActionListener(new myActionListener());

		ColorS = new ButtonSetting(Language.Language[Language.Lan.ColorS.ordinal()+Language.LSelect],"Color Start", 10, 20, 190, 30);
		ColorS.addActionListener(new myActionListener());
		
		ColorE = new ButtonSetting(Language.Language[Language.Lan.ColorE.ordinal()+Language.LSelect],"Color End", 10, 60, 190, 30);
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
				Rightsetting.onSee_Focus(); //오른쪽 페이지를 보이게끔 설정
				Rightsetting.setData(new Data.Click()); //새롭게 데이터를 설정.
				Rightsetting.view();
				break;
			case "Drag Setting": 
				Rightsetting.onSee_Focus();
				Rightsetting.setData(new Data.Drag());
				Rightsetting.view();
				break;
			case "Delay Setting": 
				Rightsetting.onSee_Focus();
				Rightsetting.setData(new Data.Delay());
				Rightsetting.view();
				break;
			case "Color Start": 
				Rightsetting.onSee_Focus();
				Rightsetting.setData(new Data.ColorS());
				Rightsetting.view();
				break;
			case "Color End":
				Rightsetting.onSee_Focus();
				Rightsetting.setData(new Data.ColorE());
				Rightsetting.view();
				break;
				
			}
		}
	}
}
