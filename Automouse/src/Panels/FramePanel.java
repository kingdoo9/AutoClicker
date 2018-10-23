package Panels;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import Constants.Constant;
import Events.PlayEvent;
import Setting.ButtonSetting;
import Setting.DataSetting;
import Setting.PanelSetting;
import javafx.scene.input.KeyCode;

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
	private PlayEvent play;
	
	ScrollRoutine ScrollR;

	public FramePanel() throws InterruptedException, AWTException {
		super("AutoSetting");
		this.setPreferredSize(new Dimension(Constant.FrameWidth,Constant.Frameheight));
		this.setLayout(null);
		this.setResizable(false); //프레임 크기변경 불가능
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우창 X버튼누를때 강제종료

		//플레이class
		play = new PlayEvent();
		
		//컨테이너 (모든패널 저장공간)
		content = this.getContentPane();
		content.addKeyListener(new myActionListener());
		
		//오른쪽 안쪽 패널
		rightsetting = new RightSettingPanel(10, 10, 475, 445, Color.white);
		
		//루틴 패널
		Routine = new RoutinePanel(10,60,250,350,Color.white,rightsetting);
		//ScrollR = new ScrollRoutine();
		//ScrollR.add(Routine);
		
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
		//this.setFocusable(true);
		this.pack();
	}
	
	class GThread extends Thread implements Runnable{
		
		@SuppressWarnings("unchecked")
		@Override
		public void run(){ 
			while (true){ 
		        try{ 
					Thread.sleep(120);
				
					if(!rightsetting.getSee_Focus()) content.setFocusable(true);
					else content.setFocusable(false);	
					
					left.remove(Mouse);
					Routine.View();

		    		Mouse = new MousePanel(220,10,270,40,Color.white);
					left.add(Routine);

					left.add(Mouse);
					left.add(Guide);
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
	
	class myActionListener implements ActionListener, KeyListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand() == "Save") {
				System.out.println("saved");
			}else {
				System.out.println("loaded");
			}
		}

		@SuppressWarnings("deprecation")
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_F5) {
				play.start();
			}
			if(e.getKeyCode() == KeyEvent.VK_F6) {
				play.stop();
				try {
					play = new PlayEvent();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
