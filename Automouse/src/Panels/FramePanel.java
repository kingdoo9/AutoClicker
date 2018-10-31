package Panels;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Constants.Constant;
import Events.PlayEvent;
import Setting.PanelSetting;

public class FramePanel extends JFrame{ //JFrame �Լ�. �������� Ʋ�� ¥�� �� �ð����� ȭ���� �����ϴ� ������ �Ѵ�.
	private static final long serialVersionUID = 1L;
	private GThread runner =new GThread(); //�� �ð����� ȭ���� �������ִ� Thread
	private MousePanel Mouse;
	private Container content;
	private RightSettingPanel rightsetting;
	private RoutinePanel Routine;
	private GuidePanel Guide;
	private SettingPanel Setting;
	private PanelSetting right;
	private LeftPanel left;
	private PlayEvent play;
	private PlayCountPanel PlayCount;

	public FramePanel() throws InterruptedException, AWTException {
		super("AutoSetting"); // �������� ����ǥ������ ������ ����.
		this.setPreferredSize(new Dimension(Constant.FrameWidth,Constant.Frameheight)); // Jframe�� ũ�⸦ ����
		this.setLayout(null); // ���̾ƿ��� ���� ����� Bounds�������� ��ġ �� ũ�⸦ �����ؾ��Ѵ�.
		this.setResizable(false); //������ ũ�⺯�� �Ұ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������â X��ư������ ��������
		
		//�����̳� (����г� �������)
		content = this.getContentPane();
		content.addKeyListener(new myActionListener()); //�����̳� Ű �Է��� �߰����ش�. ���� �ϴܿ� Ű �Է� �� �ൿ�� ���α׷�����.		
		//������ ���� �г�
		rightsetting = new RightSettingPanel(10, 10, 475, 445, Color.white);		
		//��ƾ �г�
		Routine = new RoutinePanel(10,60,250,350,Color.white,rightsetting);		
		//F5, F6�� �����ÿ� �г�
		Guide = new GuidePanel(10,10,160,40,Color.white);	
		//���� �г�
		Setting = new SettingPanel(270,60,220,350,Color.white,rightsetting);	
		//������ �г�
		right = new NormalPanel(500,0,495,465,new Color(213,242,211));			
		//���� �г�
		left = new LeftPanel(0,0,500,465,new Color(213,242,211));		
		//���콺 ��ǥ �г�
		Mouse = new MousePanel(180,10,195,40,Color.white);		
		//play ����
		play = new PlayEvent(0);
		//Play Ƚ���� ��Ÿ���� �г�
		PlayCount = new PlayCountPanel(385, 10, 105, 40, Color.white);
		

		right.add(rightsetting); //������ �������� ��޼����� ����.

		content.add(left); //��üȭ�鿡 ������������ �������������� ����.
		content.add(right);
		
		runner.start(); //ȭ�� ���� �׻� ����.
		this.setVisible(true);
		this.pack();
	}
	
	class GThread extends Thread implements Runnable{ //ȭ���� �������ִ� class Runnable�� �׻� �����Ѵ�.
		
		@Override
		public void run(){ 
			while (true){ 
		        try{ 
					Thread.sleep(120);  //�۵��� ��� �����. 1000 = 1s ��.
					
					//play�� ���۵Ǹ� ��� ��Ŀ�� �����
					if(play.isAlive()) {content.setFocusable(true); content.requestFocus();}
					
					//������ ������(����ȭ��)�� �����ִٸ� ���� ȭ���� Ű �Է��� �ȵǰ� ���´�.
					if(!rightsetting.getSee_Focus()) {
						rightsetting.setFocusable(false);
						if(!content.isFocusable()) {
							content.setFocusable(true);
							content.requestFocus();
						}
					}
					else {
						content.setFocusable(false);
						rightsetting.setFocusable(true);
						rightsetting.requestFocus();
						
					}
					
					Routine.View(play); //��ƾ ȭ��(�����߾�)�� ���콺 ȭ��(���� �߾�)��  �׻� �ٲ�� �ؾ��ϹǷ� ������.
					Mouse.View();
					left.View();
					Guide.View();
					Setting.View();
					PlayCount.View(play);
					
					left.add(Routine); //���� �������� �� ȭ����� ����
					left.add(Mouse);
					left.add(Guide);
					left.add(Setting);
					left.add(PlayCount);

					left.repaint();
					content.repaint(); //ȭ���� �����Ѵ�.
		        }catch (Exception ex){
		        	System.out.println(ex.getMessage());
		        } 
			} 
		}
	}
	
	//��ư ���� �� F5, F6Ű�� ���� ������
	class myActionListener implements KeyListener{

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
		public void keyReleased(KeyEvent e) {}
		@Override
		public void keyTyped(KeyEvent e) {}
	}
	
}
