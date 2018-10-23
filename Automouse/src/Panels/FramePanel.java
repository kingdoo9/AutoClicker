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
		this.setResizable(false); //������ ũ�⺯�� �Ұ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������â X��ư������ ��������

		//�÷���class
		play = new PlayEvent();
		
		//�����̳� (����г� �������)
		content = this.getContentPane();
		content.addKeyListener(new myActionListener());
		
		//������ ���� �г�
		rightsetting = new RightSettingPanel(10, 10, 475, 445, Color.white);
		
		//��ƾ �г�
		Routine = new RoutinePanel(10,60,250,350,Color.white,rightsetting);
		//ScrollR = new ScrollRoutine();
		//ScrollR.add(Routine);
		
		//F5, F6�� �����ÿ� �г�
		Guide = new GuidePanel(10,10,200,40,Color.white);	
		//���� �г�
		Setting = new SettingPanel(270,60,220,350,Color.white,rightsetting);
		
		//����, �ҷ����� ��ư
		save = new ButtonSetting("Save", 10, 420, 80, 30);
		save.addActionListener(new myActionListener());
		load = new ButtonSetting("Load", 100, 420, 80, 30);
		load.addActionListener(new myActionListener());
		
		//������ �г�
		right = new MainPanel(500,0,495,465,new Color(213,242,211));	
		
		//���� �г�
		left = new MainPanel(0,0,500,465,new Color(213,242,211));
		
		//���콺 ��ǥ �г�
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
