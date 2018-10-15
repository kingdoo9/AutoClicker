package Setting;

import java.awt.Color;
import java.awt.Container;
import java.awt.MouseInfo;
import javax.swing.JFrame;
import Views.RightSettingView;
import Views.SettingView;

public class FrameSetting extends JFrame{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	public FrameSetting() throws InterruptedException {
		super("AutoSetting");

		this.setBounds(500,500,1000,500);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content = this.getContentPane();
		
		while(true) {	
			Thread.sleep(120);
			content.removeAll();
	
			//왼쪽 패널
			PanelSetting left = new PanelSetting(0,0,500,465,new Color(213,242,211));
			//오른쪽 패널
			PanelSetting right = new PanelSetting(500,0,495,465,new Color(213,242,211));
				
			//F5, F6를 누르시오 패널
			PanelSetting StartGuide = new PanelSetting(10,10,200,40,Color.white);				
			StartGuide.add(new LabelSetting("F5: start", 10, 10, 80, 20));
			StartGuide.add(new LabelSetting("F6: stop", 100, 10, 80, 20));
			
			//마우스 패널
			PanelSetting Mouse = new PanelSetting(220,10,270,40,Color.white);
			Mouse.add(new LabelSetting("Mouse       X: "+Mouse.mouse.MouseGetX()+"     Y: "+Mouse.mouse.MouseGetY(), 10, 10, 250, 20));
	
			//루틴 패널
			PanelSetting Routine = new PanelSetting(10,60,250,350,Color.white);
			
			//설정 패널
			SettingView Setting = new SettingView(270,60,220,350,Color.white);
			RightSettingView rightsetting = new RightSettingView(10, 10, 475, 445, Color.white);
			
			//저장, 불러오기 버튼
			ButtonSetting save = new ButtonSetting("Save", 10, 420, 80, 30);
			ButtonSetting load = new ButtonSetting("Load", 100, 420, 80, 30);
			
			
			
	//		for(int i=0; i<Routine.countComponents(); i++) {
	//			System.out.println("yes");
	//		}
			
			left.add(StartGuide);
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
