package Panels;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Constants.Constant;
import Data.FileData;
import Data.RoutineData;
import Events.PlayEvent;
import Setting.ButtonSetting;
import Setting.DataSetting;
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
	private PlayEvent play;
	private RoutineData RD;

	public FramePanel() throws InterruptedException, AWTException {
		super("AutoSetting");
		this.setPreferredSize(new Dimension(Constant.FrameWidth,Constant.Frameheight));
		this.setLayout(null);
		this.setResizable(false); //������ ũ�⺯�� �Ұ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������â X��ư������ ��������
		
		//�����̳� (����г� �������)
		content = this.getContentPane();
		content.addKeyListener(new myActionListener());
		
		
		//������ ���� �г�
		rightsetting = new RightSettingPanel(10, 10, 475, 445, Color.white);
		
		//��ƾ �г�
		Routine = new RoutinePanel(10,60,250,350,Color.white,rightsetting);
		
		//F5, F6�� �����ÿ� �г�
		Guide = new GuidePanel(10,10,200,40,Color.white);	
		//���� �г�
		Setting = new SettingPanel(270,60,220,350,Color.white,rightsetting);
		
		//����, �ҷ����� ��ư
		save = new ButtonSetting("����", 10, 420, 80, 30);
		save.setActionCommand("Save");
		save.addActionListener(new myActionListener());
		load = new ButtonSetting("�ҷ�����", 100, 420, 80, 30);
		load.setActionCommand("Load");
		load.addActionListener(new myActionListener());
		
		//������ �г�
		right = new MainPanel(500,0,495,465,new Color(213,242,211));	
		
		//���� �г�
		left = new MainPanel(0,0,500,465,new Color(213,242,211));
		
		//���콺 ��ǥ �г�
		Mouse = new MousePanel(220,10,270,40,Color.white);
		
		runner.start();
		this.setVisible(true);
		this.pack();
	}
	
	class GThread extends Thread implements Runnable{
		
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
	
	//��ư ���� �� F5, F6Ű�� ���� ������
	class myActionListener implements ActionListener, KeyListener{

		//��ư ����
		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				if(e.getActionCommand() == "Save") {
					String D = JOptionPane.showInputDialog(null,"����� ���ϸ��� �Է����ּ���. \n \\  /  :  \"  *  ?  .  <  >  |  \n �Է½� ������ �������� ���� �� �ֽ��ϴ�.)","input",JOptionPane.QUESTION_MESSAGE);
					new FileData();
					RD = new RoutineData();
					RD.setObj(Constant.data);
					FileData.save(D, RD.getObj());
				}else {
					String D = JOptionPane.showInputDialog(null,"�ҷ��� ���ϸ��� �Է����ּ���.","input",JOptionPane.QUESTION_MESSAGE);
					new FileData();
					Constant.data = (Vector<DataSetting>) FileData.read(D);
				}
			}catch(Exception E) {}
		}

		//Ű ����
		@SuppressWarnings("deprecation")
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			try {

				if(e.getKeyCode() == KeyEvent.VK_F5) {
					//�ݺ�Ƚ�� ���� ��ȭâ
					String D = JOptionPane.showInputDialog(null,"��� �ݺ��Ͻðڽ��ϱ�?","input",JOptionPane.QUESTION_MESSAGE);
					play = new PlayEvent(Integer.parseInt(D));
					play.start();
				}
				if(e.getKeyCode() == KeyEvent.VK_F6) {
					play.stop();
				}
			} catch (Exception e1) { // ���ڰ� �ƴ� ���� �ԷµǾ����� �� error �޽���
				JOptionPane.showMessageDialog(null, "�Է� ������ �ùٸ��� �ʽ��ϴ�.");
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
