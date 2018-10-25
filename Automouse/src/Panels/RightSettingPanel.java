package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import Constants.Constant;
import Data.ColorS;
import Events.PlayEvent;
import Labels.InputLabel;
import Labels.NomalLabel;
import Setting.ButtonSetting;
import Setting.DataSetting;
import Setting.PanelSetting;

public class RightSettingPanel extends PanelSetting{
	private static final long serialVersionUID = 1L;
	private ButtonSetting save, delete, set1, set2, set3, up, down;
	private Color ColorSet = new Color(255,255,255);
	private DataSetting Data;
	private Boolean see_Focus = false;
	
	public RightSettingPanel(int x, int y, int width, int height, Color color) {
		// TODO Auto-generated constructor stub
		super(x, y, width, height, color);
		this.setVisible(see_Focus);
		this.addKeyListener(new myActionListener());
	}
	public Boolean getSee_Focus() {return see_Focus;}
	public void onSee_Focus() {this.see_Focus = true;}
	public void Colorinit() { this.ColorSet = new Color(255,255,255);}
	
	public void view(DataSetting data) {
		// TODO Auto-generated method stub
		if(!ColorSet.equals(new Color(255,255,255))) Data.setRGB(ColorSet);
		this.Data = data;

			this.removeAll();		
			int j = 20;
			
			//오른쪽 페이지를 표시해준다. 
			for(char i : data.getKind()) {
			if(i == 'M') {
				this.add(new NomalLabel("시작 좌표 : ", 20, j, 150, 30));
				this.add(new NomalLabel("X: "+Integer.toString(Data.getSmouseX())+" Y: "+Integer.toString(Data.getSmouseY()),180,j,130,30));
				this.add(new NomalLabel("('1' 키를 꾹 눌러주세요.)",180,j+20,180,30));
			}else if(i == 'E') {
				this.add(new NomalLabel("종료 좌표 : ", 20, j, 150, 30));
				this.add(new NomalLabel("X: "+Integer.toString(Data.getEmouseX())+" Y: "+Integer.toString(Data.getEmouseY()),180,j,130,30));
				this.add(new NomalLabel("('2' 키를 꾹 눌러주세요.)",180,j+20,180,30));
			}else if(i == 'N') {
				set1 = new ButtonSetting("Count Set-up", 270, j+5, 150, 20);
				set1.addActionListener(new myActionListener());
				this.add(new NomalLabel(Data.getName() +" Count : ", 20, j, 150, 30));
				this.add(new InputLabel(Integer.toString(Data.getNumber()), 180, j, 80, 30));
				this.add(set1);
			}else if(i == 'R') {
				set2 = new ButtonSetting("repeat Set-up", 270, j+5, 150, 20);
				set2.addActionListener(new myActionListener());
				this.add(new NomalLabel(Data.getName() +" repeat(1s) : ", 20, j, 150, 30));
				this.add(new InputLabel(Integer.toString(Data.getRepeat()), 180, j, 80, 30));
				this.add(set2);
			}else if(i == 'D') {
				set3 = new ButtonSetting("Delay Set-up", 270, j+5, 150, 20);
				set3.addActionListener(new myActionListener());
				this.add(new NomalLabel("Delay time(ms) : ", 20, j, 150, 30));
				this.add(new InputLabel(Integer.toString(Data.getDelay()), 180, j, 80, 30));
				this.add(set3);
			}else if(i == 'C') {
				this.add(new NomalLabel("Color : ", 20, j, 150, 30));
				this.add(new NomalLabel(
						"R: "+Integer.toString(Data.getRGB().getRed())+" "+
						"G: "+Integer.toString(Data.getRGB().getGreen())+" "+
						"B: "+Integer.toString(Data.getRGB().getBlue()),180,j,180,30));
				ButtonSetting ViewColor = new ButtonSetting("", 360, j, 90, 30);
				ViewColor.setBackground(Data.getRGB());
				this.add(ViewColor);
				this.add(new NomalLabel("(Hold-On '3' key)",180,j+20,130,30));
			}else if(i == 'H') {
				this.add(new NomalLabel("Hold-On Setting", 20, j, 150, 30));
				JCheckBox check = new JCheckBox();
				check.setSelected(Data.isHoldon());
				check.setBounds(180, j+5, 20, 20);
				check.addActionListener(new myActionListener());
				check.setActionCommand("check");
				this.add(check);
			}else if(i == 'c') {
				this.add(new NomalLabel("Color Changed", 20, j, 150, 30));
				this.add(new NomalLabel("( If Color Changed, Then Continue )",20,j+20,300,30));
				JCheckBox check = new JCheckBox();
				check.setSelected(Data.isChangedColor());
				check.setBounds(180, j+5, 20, 20);
				check.addActionListener(new myActionListener());
				check.setActionCommand("changed");
				this.add(check);
			}
			j += 60;
		}
		
		save = new ButtonSetting("Save", 20, 405, 80, 30);
		save.addActionListener(new myActionListener());
		delete = new ButtonSetting("Delete",375,405,80,30);
		delete.addActionListener(new myActionListener());
		up = new ButtonSetting("Up",179,405,50,30);
		up.addActionListener(new myActionListener());
		down = new ButtonSetting("Down",233,405,50,30);
		down.addActionListener(new myActionListener());
		
		this.add(save);
		this.add(delete);
		this.add(up);
		this.add(down);
		
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
					if(!Data.isSaved()) {
						Constant.data.add(Data);
						if(Data.getName().equals("Color Start"))
							ColorSet = Data.getRGB();
						Data.setSaved(true);
					}
					view(Data);
					break;
				case "Delete":
					see_Focus = false;
					if(Data.isSaved()) Constant.data.removeElement(Data);
					view(Data);
					break;
				case "check":
					if(Data.isHoldon()) Data.setHoldon(false);
					else Data.setHoldon(true);
					break;

				case "changed":
					if(Data.isChangedColor()) Data.setChangedColor(false);
					else Data.setChangedColor(true);
					break;
					
				case "Up":
					if(Data.isSaved()) {
						if(Constant.data.indexOf(Data)!=0) {
							int temp = Constant.data.indexOf(Data);
							Constant.data.removeElement(Data);
							Constant.data.insertElementAt(Data, temp-1);
						}
					}
					break;
					
				case "Down":
					if(Data.isSaved()) {
						if(Constant.data.indexOf(Data) != Constant.data.size()-1) {
							int temp = Constant.data.indexOf(Data);
							Constant.data.removeElement(Data);
							Constant.data.insertElementAt(Data, temp+1);
						}
					}
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
			if(e.getKeyCode() == KeyEvent.VK_3) {
				if(Data.getName().equals("Color Start"))
					Data.setRGB(Constant.mouse.getColor());
				view(Data);
			}
			if(e.getKeyCode() == KeyEvent.VK_F5) {
				JOptionPane.showMessageDialog(null, "설정창을 닫고 눌러주세요.");
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


