package Panels;

import java.awt.Color;
import java.awt.Container;
import java.awt.MouseInfo;
import javax.swing.JFrame;

import Panels.RightSettingPanel;
import Panels.SettingPanel;
import Setting.ButtonSetting;
import Setting.LabelSetting;
import Setting.PanelSetting;

public class FramePanel extends JFrame{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	public FramePanel() throws InterruptedException {
		super("AutoSetting");

		this.setBounds(500,500,1000,500);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content = this.getContentPane();
		
		RightSettingPanel rightsetting = new RightSettingPanel(10, 10, 475, 445, Color.white);
		//��ƾ �г�
		RoutinePanel Routine = new RoutinePanel(10,60,250,350,Color.white);
		
		//F5, F6�� �����ÿ� �г�
		GuidePanel Guide = new GuidePanel(10,10,200,40,Color.white);	
		//���� �г�
		SettingPanel Setting = new SettingPanel(270,60,220,350,Color.white,rightsetting);
		
		//����, �ҷ����� ��ư
		ButtonSetting save = new ButtonSetting("Save", 10, 420, 80, 30,Routine);
		ButtonSetting load = new ButtonSetting("Load", 100, 420, 80, 30,Routine);
			
		while(true) {	
			Thread.sleep(120);
			content.removeAll();
			//���� �г�
			PanelSetting left = new PanelSetting(0,0,500,465,new Color(213,242,211));
			//������ �г�
			PanelSetting right = new PanelSetting(500,0,495,465,new Color(213,242,211));	

			//���콺 �г�
			MousePanel Mouse = new MousePanel(220,10,270,40,Color.white);	
			

	//		for(int i=0; i<Routine.countComponents(); i++) {
	//			System.out.println("yes");
	//		}
			
			left.add(Guide);
			left.add(Mouse);
			left.add(Routine);
			left.add(Setting);
			left.add(save);
			left.add(load);
			
			right.add(rightsetting);
				
			content.add(left);
			content.add(right);
	
			content.repaint();
			this.setVisible(true);
		}
	}
}
