package Panels;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Constants.Constant;
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
	private Boolean see_Focus = true;
	
	public RightSettingPanel(int x, int y, int width, int height, Color color) {
		// TODO Auto-generated constructor stub
		super(x, y, width, height, color);
		this.setVisible(false);
		this.addKeyListener(new myActionListener());
	}
	
	public void onSee_Focus() {this.see_Focus = true;}

	public void view(DataSetting data) {
		// TODO Auto-generated method stub
		this.Data = data;

			this.removeAll();		
			int j = 20;
			
			//오른쪽 페이지를 표시해준다. 
			for(char i : data.getKind()) {
			if(i == 'M') {
				this.add(new NomalLabel("Position : ", 20, j, 150, 30));
				this.add(new NomalLabel("X: "+Integer.toString(Data.getSmouseX())+" Y: "+Integer.toString(Data.getSmouseY()),180,j,130,30));
			}else if(i == 'S') {
				this.add(new NomalLabel("Start Position : ", 20, j, 150, 30));
				this.add(new NomalLabel("X: "+Integer.toString(Data.getSmouseX())+" Y: "+Integer.toString(Data.getSmouseY()),180,j,130,30));
			}else if(i == 'E') {
				this.add(new NomalLabel("End Position : ", 20, j, 150, 30));
				this.add(new NomalLabel("X: "+Integer.toString(Data.getEmouseX())+" Y: "+Integer.toString(Data.getEmouseY()),180,j,130,30));
			}else if(i == 'N') {
				set1 = new ButtonSetting("Count Set-up", 270, j+5, 150, 20);
				set1.addActionListener(new myActionListener());
				this.add(new NomalLabel("Click Count : ", 20, j, 150, 30));
				this.add(new InputLabel(Integer.toString(Data.getNumber()), 180, j, 80, 30));
				this.add(set1);
			}else if(i == 'R') {
				set2 = new ButtonSetting("repeat Set-up", 270, j+5, 150, 20);
				set2.addActionListener(new myActionListener());
				this.add(new NomalLabel("Click repeat(1s) : ", 20, j, 150, 30));
				this.add(new InputLabel(Integer.toString(Data.getRepeat()), 180, j, 80, 30));
				this.add(set2);
			}else if(i == 'D') {
				set3 = new ButtonSetting("Delay Set-up", 270, j+5, 150, 20);
				set3.addActionListener(new myActionListener());
				this.add(new NomalLabel("Delay time(ms) : ", 20, j, 150, 30));
				this.add(new InputLabel(Integer.toString(Data.getDelay()), 180, j, 80, 30));
				this.add(set3);
			}else if(i == 'C') {
				
			}
			j += 60;
		}
		
		save = new ButtonSetting("Save", 20, 405, 50, 30);
		save.addActionListener(new myActionListener());

		this.add(save);
		this.setFocusable(see_Focus);
		this.repaint();
		this.setVisible(see_Focus);


	}


	class myActionListener implements ActionListener, KeyListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				switch(e.getActionCommand()){
				
				case "Count Set-up":
					String N = JOptionPane.showInputDialog(null,"Input Number","input",JOptionPane.QUESTION_MESSAGE);
					Data.setNumber(Integer.parseInt(N));
		        	view(Data); //오른쪽 페이지 갱신
					break;
				case "repeat Set-up":
					String R = JOptionPane.showInputDialog(null,"Input Number (N<100)","input",JOptionPane.QUESTION_MESSAGE);
					if(Integer.parseInt(R)>100 || Integer.parseInt(R)<=0) break;
					Data.setRepeat(Integer.parseInt(R));
		        	view(Data);
					break;
				case "Delay Set-up":
					String D = JOptionPane.showInputDialog(null,"Input Number (1000 = 1s)","input",JOptionPane.QUESTION_MESSAGE);
					Data.setDelay(Integer.parseInt(D));
		        	view(Data);
					break;
				case "Save":
					see_Focus = false;
					Constant.data.add(Data);
					view(Data);
					break;
				}
			}catch(Exception ex) {
				
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_1) {
				Data.setSmouseX(Constant.mouse.MouseGetX());
				Data.setSmouseY(Constant.mouse.MouseGetY());
				view(Data);
			}
			if(e.getKeyCode() == KeyEvent.VK_2) {
				Data.setEmouseX(Constant.mouse.MouseGetX());
				Data.setEmouseY(Constant.mouse.MouseGetY());
				view(Data);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}


