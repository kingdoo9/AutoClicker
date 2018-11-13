package Panels;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Constants.Constant;
import Constants.Language;
import Events.PlayEvent;

public class FramePanel extends JFrame{ //JFrame �Լ�. �������� Ʋ�� ¥�� �� �ð����� ȭ���� �����ϴ� ������ �Ѵ�.
	private static final long serialVersionUID = 1L;
	private GThread runner =new GThread(); //�� �ð����� ȭ���� �������ִ� Thread
	private MousePanel Mouse;
	private Container content;
	private RoutinePanel Routine;
	private GuidePanel Guide;
	private SettingPanel Setting;
	private RightPanel right;
	private LeftPanel left;
	private PlayEvent play;
	private PlayCountPanel PlayCount;
	private int F_W=1000, F_H=500; //������ �������� ����� �ٲ����� ȭ�鰻���� ����.

	public void FrameSize() {
		Constant.FrameWidth = (int) this.getSize().getWidth();
		Constant.Frameheight = (int) this.getSize().getHeight();
	}
	
	public FramePanel() throws InterruptedException, AWTException {
		super("AutoSetting"); // �������� ����ǥ������ ������ ����.
		this.setBounds(0,0,Constant.FrameWidth,Constant.Frameheight); // Jframe�� ũ�⸦ ����
		this.setLayout(null); // ���̾ƿ��� ���� ����� Bounds�������� ��ġ �� ũ�⸦ �����ؾ��Ѵ�.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������â X��ư������ ��������
		
		//�����̳� (����г� �������)
		content = this.getContentPane();
		content.setFocusable(true);
		content.addKeyListener(new myActionListener()); //�����̳� Ű �Է��� �߰����ش�. ���� �ϴܿ� Ű �Է� �� �ൿ�� ���α׷�����.		
	
		//��ƾ �г�
		Routine = new RoutinePanel(10,60,250,350,Color.white);		
		//F5, F6�� �����ÿ� �г�
		Guide = new GuidePanel(10,10,160,40,Color.white);	
		//���� �г�
		Setting = new SettingPanel(270,60,220,350,Color.white);	
		//������ �г�
		right = new RightPanel(500,0,495,465,new Color(213,242,211));			
		//���� �г�
		left = new LeftPanel(0,0,500,465,new Color(213,242,211));		
		//���콺 ��ǥ �г�
		Mouse = new MousePanel(180,10,195,40,Color.white);		
		//play ����
		play = new PlayEvent(0);
		//Play Ƚ���� ��Ÿ���� �г�
		PlayCount = new PlayCountPanel(385, 10, 105, 40, Color.white);
		
		content.add(left); //��üȭ�鿡 ������������ �������������� ����.
		content.add(right);
		
		runner.start(); //ȭ�� ���� �׻� ����.
		this.setVisible(true);
	}
	
	class GThread extends Thread implements Runnable{ //ȭ���� �������ִ� class Runnable�� �׻� �����Ѵ�.
		
		@Override
		public void run(){ 
			while (true){ 
		        try{ 
					FrameSize();
							
					left.View();
					right.View();	
					
					if(Constant.FrameWidth >300 && Constant.Frameheight>300) {
						Routine.View(play); //��ƾ ȭ��(�����߾�)�� ���콺 ȭ��(���� �߾�)��  �׻� �ٲ�� �ؾ��ϹǷ� ������.
						Mouse.View();
						Guide.View();
						Setting.View();		
	
						left.add(Routine); //���� �������� �� ȭ����� ����
						left.add(Mouse);
						left.add(Guide);
						left.add(Setting);
						right.add(Constant.RightP); //������ �������� ��޼����� ����.
					}
					
					PlayCount.View(play);
					left.add(PlayCount);
					
					//������ ������(����ȭ��)�� �����ִٸ� ���� ȭ���� Ű �Է��� �ȵǰ� ���´�.
					if(!Constant.RightP.getSee_Focus()) {
						Constant.RightP.setFocusable(false);
						if(!content.isFocusable()) {
							content.setFocusable(true);
							content.requestFocus();
						}
					}
					else {
						if(Constant.FrameWidth != F_W || Constant.Frameheight != F_H) {
							Constant.RightP.view();
							F_W = Constant.FrameWidth;
							F_H = Constant.Frameheight;

						}
						content.setFocusable(false);
						Constant.RightP.setFocusable(true);
						Constant.RightP.requestFocus();
						
					}
					
					//play�� ���۵Ǹ� ��� ��Ŀ�� �����
					if(play.isAlive()) {content.setFocusable(true); content.requestFocus();}

					right.repaint();
					left.repaint();
					content.repaint(); //ȭ���� �����Ѵ�.
					Thread.sleep(120);  //�۵��� ��� �����. 1000 = 1s ��.
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
					String D = JOptionPane.showInputDialog(null,Language.Language[Language.Lan.MsgStart.ordinal() + Language.LSelect],"input",JOptionPane.QUESTION_MESSAGE);
					play = new PlayEvent(Integer.parseInt(D));
					play.start();
				}
				if(e.getKeyCode() == KeyEvent.VK_F6) {
					play.stop();
				}
			} catch (Exception e1) { // ���ڰ� �ƴ� ���� �ԷµǾ����� �� error �޽���
				JOptionPane.showMessageDialog(null,Language.Language[Language.Lan.MsgError.ordinal() + Language.LSelect]);
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {}
		@Override
		public void keyTyped(KeyEvent e) {}
	}
	
}
