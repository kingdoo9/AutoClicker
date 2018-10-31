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
import Constants.Language;
import Events.PlayEvent;
import Setting.PanelSetting;

public class FramePanel extends JFrame{ //JFrame 함수. 프레임의 틀을 짜며 매 시간마다 화면을 갱신하는 역할을 한다.
	private static final long serialVersionUID = 1L;
	private GThread runner =new GThread(); //매 시간마다 화면을 갱신해주는 Thread
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
		super("AutoSetting"); // 프레임의 제목표시줄의 제목을 결정.
		this.setPreferredSize(new Dimension(Constant.FrameWidth,Constant.Frameheight)); // Jframe의 크기를 설정
		this.setLayout(null); // 레이아웃을 없이 만들어 Bounds설정으로 위치 및 크기를 조정해야한다.
		this.setResizable(false); //프레임 크기변경 불가능
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우창 X버튼누를때 강제종료
		
		//컨테이너 (모든패널 저장공간)
		content = this.getContentPane();
		content.setFocusable(true);
		content.addKeyListener(new myActionListener()); //컨테이너 키 입력을 추가해준다. 가장 하단에 키 입력 시 행동을 프로그래밍함.		
		//오른쪽 안쪽 패널
		rightsetting = new RightSettingPanel(10, 10, 475, 445, Color.white);		
		//루틴 패널
		Routine = new RoutinePanel(10,60,250,350,Color.white,rightsetting);		
		//F5, F6를 누르시오 패널
		Guide = new GuidePanel(10,10,160,40,Color.white);	
		//설정 패널
		Setting = new SettingPanel(270,60,220,350,Color.white,rightsetting);	
		//오른쪽 패널
		right = new NormalPanel(500,0,495,465,new Color(213,242,211));			
		//왼쪽 패널
		left = new LeftPanel(0,0,500,465,new Color(213,242,211));		
		//마우스 좌표 패널
		Mouse = new MousePanel(180,10,195,40,Color.white);		
		//play 설정
		play = new PlayEvent(0);
		//Play 횟수를 나타내는 패널
		PlayCount = new PlayCountPanel(385, 10, 105, 40, Color.white);
		

		right.add(rightsetting); //오른쪽 페이지에 고급설정을 넣음.

		content.add(left); //전체화면에 왼쪽페이지와 오른쪽페이지를 넣음.
		content.add(right);
		
		runner.start(); //화면 갱신 항상 시작.
		this.setVisible(true);
		this.pack();
	}
	
	class GThread extends Thread implements Runnable{ //화면을 갱신해주는 class Runnable로 항상 실행한다.
		
		@Override
		public void run(){ 
			while (true){ 
		        try{ 
					Thread.sleep(120);  //작동을 잠시 멈춘다. 1000 = 1s 임.
					
					//play가 시작되면 계속 포커스 잡아줌
					if(play.isAlive()) {content.setFocusable(true); content.requestFocus();}
					
					//오른쪽 페이지(설정화면)이 켜져있다면 메인 화면의 키 입력이 안되게 막는다.
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
					
					Routine.View(play); //루틴 화면(왼쪽중앙)과 마우스 화면(위쪽 중앙)은  항상 바뀌도록 해야하므로 설정함.
					Mouse.View();
					left.View();
					Guide.View();
					Setting.View();
					PlayCount.View(play);
					
					left.add(Routine); //왼쪽 페이지에 각 화면들을 넣음
					left.add(Mouse);
					left.add(Guide);
					left.add(Setting);
					left.add(PlayCount);

					left.repaint();
					content.repaint(); //화면을 갱신한다.
		        }catch (Exception ex){
		        	System.out.println(ex.getMessage());
		        } 
			} 
		}
	}
	
	//버튼 설정 및 F5, F6키에 대한 설정들
	class myActionListener implements KeyListener{

		//키 설정
		@SuppressWarnings("deprecation")
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			try {

				if(e.getKeyCode() == KeyEvent.VK_F5) {
					//반복횟수 설정 대화창
					String D = JOptionPane.showInputDialog(null,Language.Language[Language.Lan.MsgStart.ordinal() + Language.LSelect],"input",JOptionPane.QUESTION_MESSAGE);
					play = new PlayEvent(Integer.parseInt(D));
					play.start();
				}
				if(e.getKeyCode() == KeyEvent.VK_F6) {
					play.stop();
				}
			} catch (Exception e1) { // 숫자가 아닌 수가 입력되었을때 의 error 메시지
				JOptionPane.showMessageDialog(null,Language.Language[Language.Lan.MsgError.ordinal() + Language.LSelect]);
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {}
		@Override
		public void keyTyped(KeyEvent e) {}
	}
	
}
