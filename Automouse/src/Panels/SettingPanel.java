package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Constants.Language;
import Labels.NomalLabel;
import Setting.ButtonSetting;
import Setting.PanelSetting;

public class SettingPanel extends PanelSetting{
	private static final long serialVersionUID = 1L;
	private static RightSettingPanel Rightsetting;
	private static ButtonSetting Click, Drag, Delay, ColorS, ColorE;
	
	public SettingPanel(int x, int y, int width, int height, Color color, RightSettingPanel rightsetting) {
		super(x, y, width, height, color); //��κ� ������ ����class�� PanelSetting�� ����.
		// TODO Auto-generated constructor stub
		Rightsetting = rightsetting; //��ư���� �������� ���������� ������.

	}
	
	public void View() {
		this.removeAll();
		
		Click = new ButtonSetting(Language.Language[Language.Lan.click.ordinal()+Language.LSelect],"Click Setting", 10, 10, 200, 30);
		Click.addActionListener(new myActionListener()); //��ư�� ������ ������ �ϴܿ� ���α׷�����.
		
		Drag = new ButtonSetting(Language.Language[Language.Lan.Drag.ordinal()+Language.LSelect],"Drag Setting", 10, 50, 200, 30);
		Drag.addActionListener(new myActionListener());
		
		Delay = new ButtonSetting(Language.Language[Language.Lan.Delay.ordinal()+Language.LSelect],"Delay Setting", 10, 90, 200, 30);
		Delay.addActionListener(new myActionListener());

		ColorS = new ButtonSetting(Language.Language[Language.Lan.ColorS.ordinal()+Language.LSelect],"Color Start", 10, 180, 200, 30);
		ColorS.addActionListener(new myActionListener());
		
		ColorE = new ButtonSetting(Language.Language[Language.Lan.ColorE.ordinal()+Language.LSelect],"Color End", 10, 220, 200, 30);
		ColorE.addActionListener(new myActionListener());
		
		this.add(Click);
		this.add(Drag);
		this.add(Delay);
		this.add(new NomalLabel(Language.Language[Language.Lan.If.ordinal()+Language.LSelect], 10, 150, 200, 20));
		this.add(ColorS);
		this.add(ColorE);
		
		this.repaint();
	}
	
	class myActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch(e.getActionCommand()) {
			case "Click Setting": 
				Rightsetting.onSee_Focus(); //������ �������� ���̰Բ� ����
				Rightsetting.setData(new Data.Click()); //���Ӱ� �����͸� ����.
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
