package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Labels.NomalLabel;
import Setting.ButtonSetting;
import Setting.PanelSetting;

public class SettingPanel extends PanelSetting{
	private static RightSettingPanel Rightsetting;
	private static final long serialVersionUID = 1L;
	private static ButtonSetting Click;
	private static ButtonSetting Drag;
	private static ButtonSetting Delay;
	private static ButtonSetting ColorS;
	private static ButtonSetting ColorE;
	
	public SettingPanel(int x, int y, int width, int height, Color color, RightSettingPanel rightsetting) {
		super(x, y, width, height, color);
		// TODO Auto-generated constructor stub
		Rightsetting = rightsetting;
		
		Click = new ButtonSetting("Ŭ�� ����", 10, 10, 200, 30);
		Click.setActionCommand("Click Setting");
		Click.addActionListener(new myActionListener());
		
		Drag = new ButtonSetting("�巡�� ����", 10, 50, 200, 30);
		Drag.setActionCommand("Drag Setting");
		Drag.addActionListener(new myActionListener());
		
		Delay = new ButtonSetting("��� ����", 10, 90, 200, 30);
		Delay.setActionCommand("Delay Setting");
		Delay.addActionListener(new myActionListener());

		ColorS = new ButtonSetting("�� ���� ����", 10, 180, 200, 30);
		ColorS.setActionCommand("Color Start");
		ColorS.addActionListener(new myActionListener());
		
		ColorE = new ButtonSetting("�� ���� ����", 10, 220, 200, 30);
		ColorE.setActionCommand("Color End");
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
				Rightsetting.onSee_Focus();
				Rightsetting.view(new Data.Click());
				break;
			case "Drag Setting": 
				Rightsetting.onSee_Focus();
				Rightsetting.view(new Data.Drag());
				break;
			case "Delay Setting": 
				Rightsetting.onSee_Focus();
				Rightsetting.view(new Data.Delay());
				break;
			case "Color Start": 
				Rightsetting.onSee_Focus();
				Rightsetting.view(new Data.ColorS());
				break;
			case "Color End":
				Rightsetting.onSee_Focus();
				Rightsetting.Colorinit();
				Rightsetting.view(new Data.ColorE());
				break;
				
			}
		}
	}
}
