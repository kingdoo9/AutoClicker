package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Setting.ButtonSetting;
import Setting.DataSetting;
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
		
		Click = new ButtonSetting("Click Setting", 10, 10, 200, 30);
		Click.addActionListener(new myActionListener());
		
		Drag = new ButtonSetting("Drag Setting", 10, 50, 200, 30);
		Drag.addActionListener(new myActionListener());
		
		Delay = new ButtonSetting("Delay Setting", 10, 90, 200, 30);
		Delay.addActionListener(new myActionListener());

		ColorS = new ButtonSetting("Color Start", 10, 180, 200, 30);
		ColorS.addActionListener(new myActionListener());
		
		ColorE = new ButtonSetting("Color End", 10, 220, 200, 30);
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
				Rightsetting.view(new Data.Click());
				break;
			case "Drag Setting": 
				Rightsetting.view(new Data.Drag());
				break;
			case "Delay Setting": 
				Rightsetting.view(new Data.Delay());
				break;
			case "Color Start": 
				Rightsetting.view(new Data.ColorS());
				break;
			case "Color End": 
				break;
				
			}
		}
	}
}
