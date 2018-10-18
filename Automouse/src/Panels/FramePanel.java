package Panels;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import Constants.Constant;
import Setting.ButtonSetting;
import Setting.PanelSetting;

public class FramePanel extends JFrame{
	private static final long serialVersionUID = 1L;
	private GThread runner =new GThread();
	private MousePanel Mouse;
	private Container content;
	private RightSettingPanel rightsetting;
	private RoutinePanel Routine;
	private GuidePanel Guide;
	private SettingPanel Setting;
	private ButtonSetting save;
	private ButtonSetting load;
	private PanelSetting right;
	private PanelSetting left;

	public FramePanel() throws InterruptedException {
		super("AutoSetting");

		this.setBounds(Constant.FrameBoundX,Constant.FrameBoundY,Constant.FrameWidth,Constant.Frameheight);
		this.setLayout(null);
		this.setResizable(false); //프레임 크기변경 불가능
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우창 X버튼누를때 강제종료
		
		//컨테이너 (모든패널 저장공간)
		content = this.getContentPane();
		
		//오른쪽 안쪽 패널
		rightsetting = new RightSettingPanel(10, 10, 475, 445, Color.white);
		
		//루틴 패널
		Routine = new RoutinePanel(10,60,250,350,Color.white);
		
		//F5, F6를 누르시오 패널
		Guide = new GuidePanel(10,10,200,40,Color.white);	
		//설정 패널
		Setting = new SettingPanel(270,60,220,350,Color.white,rightsetting);
		
		//저장, 불러오기 버튼
		save = new ButtonSetting("Save", 10, 420, 80, 30);
		save.addActionListener(new myActionListener());
		load = new ButtonSetting("Load", 100, 420, 80, 30);
		load.addActionListener(new myActionListener());
		
		//오른쪽 패널
		right = new MainPanel(500,0,495,465,new Color(213,242,211));	
		
		//왼쪽 패널
		left = new MainPanel(0,0,500,465,new Color(213,242,211));
		
		//마우스 좌표 패널
		Mouse = new MousePanel(220,10,270,40,Color.white);
		
		runner.start();
		this.setVisible(true);
	}
	class GThread extends Thread implements Runnable{
		
		@Override
		public void run(){ 
			while (true){ 
		        try{ 
					Thread.sleep(120);

					left.remove(Mouse);
					//마우스 패널
		    		Mouse = new MousePanel(220,10,270,40,Color.white);
					
					left.add(Mouse);
					left.add(Guide);
					left.add(Routine);
					left.add(Setting);
					left.add(save);
					left.add(load);
					
					right.add(rightsetting);
					
					content.add(left);
					content.add(right);

						
					content.repaint();
		        }catch (Exception ex){ } 
			} 
		}
	}
	
	class myActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand() == "Save") {
				System.out.println("saved");
			}else {
				System.out.println("loaded");
			}
		}
	}
	
}
