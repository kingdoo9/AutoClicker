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
		this.setResizable(false); //������ ũ�⺯�� �Ұ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������â X��ư������ ��������
		
		//�����̳� (����г� �������)
		content = this.getContentPane();
		
		//������ ���� �г�
		rightsetting = new RightSettingPanel(10, 10, 475, 445, Color.white);
		
		//��ƾ �г�
		Routine = new RoutinePanel(10,60,250,350,Color.white);
		
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
	}
	class GThread extends Thread implements Runnable{
		
		@Override
		public void run(){ 
			while (true){ 
		        try{ 
					Thread.sleep(120);

					left.remove(Mouse);
					//���콺 �г�
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
