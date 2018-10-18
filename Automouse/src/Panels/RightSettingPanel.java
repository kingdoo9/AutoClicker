package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Constants.Constant;
import Events.MouseEvent;
import Setting.ButtonSetting;
import Setting.DataSetting;
import Setting.PanelSetting;

public class RightSettingPanel extends PanelSetting{
	private static final long serialVersionUID = 1L;
	private ButtonSetting save;
	private ButtonSetting set1;
	private ButtonSetting set2;
	private ButtonSetting set3;
	private DataSetting Data;
	
	
	public RightSettingPanel(int x, int y, int width, int height, Color color) {
		// TODO Auto-generated constructor stub
		super(x, y, width, height, color);
		save = new ButtonSetting("Save", 20, 405, 50, 30);
		this.setVisible(false);
	}

	public void view(DataSetting data) {
		// TODO Auto-generated method stub
		this.Data = data;
		this.removeAll();		
		int j = 20;
		for(char i : data.getKind()) {
			if(i == 'M') {
				this.add(new NomalLabel("Position : ", 20, j, 150, 30));
				this.add(new NomalLabel("X: "+Integer.toString(Constant.mouse.MouseGetX())+" Y: "+Integer.toString(Constant.mouse.MouseGetY()),180,j,100,30));
			}else if(i == 'S') {
				this.add(new NomalLabel("Start Position : ", 20, j, 150, 30));
				this.add(new NomalLabel("X: "+Integer.toString(Constant.mouse.MouseGetX())+" Y: "+Integer.toString(Constant.mouse.MouseGetY()),180,j,100,30));
			}else if(i == 'E') {
				this.add(new NomalLabel("End Position : ", 20, j, 150, 30));
				this.add(new NomalLabel("X: "+Integer.toString(Constant.mouse.MouseGetX())+" Y: "+Integer.toString(Constant.mouse.MouseGetY()),180,j,100,30));
			}else if(i == 'N') {
				set1 = new ButtonSetting("Count Set-up", 270, j+5, 150, 20);
				set1.addActionListener(new myActionListener());
				this.add(new NomalLabel("Click Count : ", 20, j, 150, 30));
				this.add(new InputLabel(Integer.toString(data.getNumber()), 180, j, 80, 30));
				this.add(set1);
			}else if(i == 'R') {
				set2 = new ButtonSetting("repeat Set-up", 270, j+5, 150, 20);
				set2.addActionListener(new myActionListener());
				this.add(new NomalLabel("Click repeat(1s) : ", 20, j, 150, 30));
				this.add(new InputLabel("", 180, j, 80, 30));
				this.add(set2);
			}else if(i == 'D') {
				set3 = new ButtonSetting("Delay Set-up", 270, j+5, 150, 20);
				set3.addActionListener(new myActionListener());
				this.add(new NomalLabel("Delay time(ms) : ", 20, j, 150, 30));
				this.add(new InputLabel("", 180, j, 80, 30));
				this.add(set3);
			}else if(i == 'C') {
				
			}
			j += 60;
		}
		
		this.add(save);
		this.repaint();
		this.setVisible(true);

	}
	class myActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch(e.getActionCommand()){
			
			case "Count Set-up":
				String name = JOptionPane.showInputDialog(null,"Input Number","input",JOptionPane.QUESTION_MESSAGE);
				System.out.println(name);
				break;
			case "repeat Set-up":
				break;
			case "Delay Set-up":
				break;
			case "Save":
				break;
			}
		}
	}
}

