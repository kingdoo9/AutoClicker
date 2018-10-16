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
		//루틴 패널
		RoutinePanel Routine = new RoutinePanel(10,60,250,350,Color.white);
		
		//F5, F6를 누르시오 패널
		GuidePanel Guide = new GuidePanel(10,10,200,40,Color.white);	
		//설정 패널
		SettingPanel Setting = new SettingPanel(270,60,220,350,Color.white,rightsetting);
		
		//저장, 불러오기 버튼
		ButtonSetting save = new ButtonSetting("Save", 10, 420, 80, 30,Routine);
		ButtonSetting load = new ButtonSetting("Load", 100, 420, 80, 30,Routine);
			
		while(true) {	
			Thread.sleep(120);
			content.removeAll();
			//왼쪽 패널
			PanelSetting left = new PanelSetting(0,0,500,465,new Color(213,242,211));
			//오른쪽 패널
			PanelSetting right = new PanelSetting(500,0,495,465,new Color(213,242,211));	

			//마우스 패널
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
