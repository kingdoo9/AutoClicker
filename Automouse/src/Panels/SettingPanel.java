package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Labels.NomalLabel;
import Setting.ButtonSetting;
import Setting.PanelSetting;

public class SettingPanel extends PanelSetting{
	private static final long serialVersionUID = 1L;
	private static RightSettingPanel Rightsetting;
	private static ButtonSetting Click, Drag, Delay, ColorS, ColorE;
	
	public SettingPanel(int x, int y, int width, int height, Color color, RightSettingPanel rightsetting) {
		super(x, y, width, height, color); //대부분 설정은 상위class인 PanelSetting에 있음.
		// TODO Auto-generated constructor stub
		Rightsetting = rightsetting; //버튼에서 쓰기위해 전역변수로 선언함.
		
		Click = new ButtonSetting("클릭 설정","Click Setting", 10, 10, 200, 30);
		Click.addActionListener(new myActionListener()); //버튼의 설정은 페이지 하단에 프로그래밍함.
		
		Drag = new ButtonSetting("드래그 설정","Drag Setting", 10, 50, 200, 30);
		Drag.addActionListener(new myActionListener());
		
		Delay = new ButtonSetting("대기 설정","Delay Setting", 10, 90, 200, 30);
		Delay.addActionListener(new myActionListener());

		ColorS = new ButtonSetting("색 조건 설정","Color Start", 10, 180, 200, 30);
		ColorS.addActionListener(new myActionListener());
		
		ColorE = new ButtonSetting("색 조건 종료","Color End", 10, 220, 200, 30);
		ColorE.addActionListener(new myActionListener());
		
		this.add(Click);
		this.add(Drag);
		this.add(Delay);
		this.add(new NomalLabel("if", 10, 150, 200, 20));
		this.add(ColorS);
		this.add(ColorE);


		
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
				Rightsetting.Colorinit();
				Rightsetting.setData(new Data.ColorE());
				Rightsetting.view();
				break;
				
			}
		}
	}
}
