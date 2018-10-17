package Panels;

import java.awt.Color;

import javax.swing.JTextField;

import Events.MouseEvent;
import Setting.ButtonSetting;
import Setting.DataSetting;
import Setting.LabelSetting;
import Setting.PanelSetting;
import Setting.TextFieldSetting;

public class RightSettingPanel extends PanelSetting{
	private static final long serialVersionUID = 1L;
	private ButtonSetting save = new ButtonSetting("save", 20, 405, 50, 30,this);
	MouseEvent me;
	public RightSettingPanel(int x, int y, int width, int height, Color color) {
		// TODO Auto-generated constructor stub
		super(x, y, width, height, color);
		this.setVisible(false);
		me = new MouseEvent(this);
		this.addMouseListener(me);
	}

	public void view(DataSetting data) {
		// TODO Auto-generated method stub
		this.removeAll();
		
		int j = 20;
		for(char i : data.getKind()) {
			if(i == 'M') {
				this.add(new LabelSetting("Position : ", 20, j, 150, 30));
				this.add(new LabelSetting("X: "+Integer.toString(me.MouseGetX())+" Y: "+Integer.toString(me.MouseGetY()),180,j,100,30));
			}else if(i == 'S') {
				this.add(new LabelSetting("Start Position : ", 20, j, 150, 30));
				this.add(new LabelSetting("X: "+Integer.toString(me.MouseGetX())+" Y: "+Integer.toString(me.MouseGetY()),180,j,100,30));
			}else if(i == 'E') {
				this.add(new LabelSetting("End Position : ", 20, j, 150, 30));
				this.add(new LabelSetting("X: "+Integer.toString(me.MouseGetX())+" Y: "+Integer.toString(me.MouseGetY()),180,j,100,30));
			}else if(i == 'N') {
				this.add(new LabelSetting("Click Count : ", 20, j, 150, 30));
				this.add(new TextFieldSetting("", 180, j, 100, 30));
			}else if(i == 'R') {
				this.add(new LabelSetting("Click repeat(1s) : ", 20, j, 150, 30));
				this.add(new TextFieldSetting("", 180, j, 100, 30));
			}else if(i == 'D') {
				this.add(new LabelSetting("Delay time(ms) : ", 20, j, 150, 30));
				this.add(new TextFieldSetting("", 180, j, 100, 30));
			}else if(i == 'C') {
				
			}
			j += 60;
		}

		this.add(save);
		this.repaint();
		this.setVisible(true);
	}
}
