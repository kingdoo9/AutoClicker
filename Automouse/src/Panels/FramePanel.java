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

public class FramePanel extends JFrame{ //JFrame 함수. 프레임의 틀을 짜며 매 시간마다 화면을 갱신하는 역할을 한다.
	private static final long serialVersionUID = 1L;
	private GThread runner =new GThread(); //매 시간마다 화면을 갱신해주는 Thread
	private MousePanel Mouse;
	private Container content;
	private RoutinePanel Routine;
	private GuidePanel Guide;
	private SettingPanel Setting;
	private RightPanel right;
	private LeftPanel left;
	private PlayEvent play;
	private PlayCountPanel PlayCount;
	private int F_W=1000, F_H=500; //오른쪽 페이지가 사이즈를 바꿨을때 화면갱신을 위함.

	public void FrameSize() {
		Constant.FrameWidth = (int) this.getSize().getWidth();
		Constant.Frameheight = (int) this.getSize().getHeight();
	}
	
	public FramePanel() throws InterruptedException, AWTException {
		super("AutoSetting"); // 프레임의 제목표시줄의 제목을 결정.
		this.setBounds(0,0,Constant.FrameWidth,Constant.Frameheight); // Jframe의 크기를 설정
		this.setLayout(null); // 레이아웃을 없이 만들어 Bounds설정으로 위치 및 크기를 조정해야한다.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우창 X버튼누를때 강제종료
		
		//컨테이너 (모든패널 저장공간)
		content = this.getContentPane();
		content.setFocusable(true);
		content.addKeyListener(new myActionListener()); //컨테이너 키 입력을 추가해준다. 가장 하단에 키 입력 시 행동을 프로그래밍함.		
	
		//루틴 패널
		Routine = new RoutinePanel(10,60,250,350,Color.white);		
		//F5, F6를 누르시오 패널
		Guide = new GuidePanel(10,10,160,40,Color.white);	
		//설정 패널
		Setting = new SettingPanel(270,60,220,350,Color.white);	
		//오른쪽 패널
		right = new RightPanel(500,0,495,465,new Color(213,242,211));			
		//왼쪽 패널
		left = new LeftPanel(0,0,500,465,new Color(213,242,211));		
		//마우스 좌표 패널
		Mouse = new MousePanel(180,10,195,40,Color.white);		
		//play 설정
		play = new PlayEvent(0);
		//Play 횟수를 나타내는 패널
		PlayCount = new PlayCountPanel(385, 10, 105, 40, Color.white);
		
		content.add(left); //전체화면에 왼쪽페이지와 오른쪽페이지를 넣음.
		content.add(right);
		
		runner.start(); //화면 갱신 항상 시작.
		this.setVisible(true);
	}
	
	class GThread extends Thread implements Runnable{ //화면을 갱신해주는 class Runnable로 항상 실행한다.
		
		@Override
		public void run(){ 
			while (true){ 
		        try{ 
					FrameSize();
							
					left.View();
					right.View();	
					
					if(Constant.FrameWidth >300 && Constant.Frameheight>300) {
						Routine.View(play); //루틴 화면(왼쪽중앙)과 마우스 화면(위쪽 중앙)은  항상 바뀌도록 해야하므로 설정함.
						Mouse.View();
						Guide.View();
						Setting.View();		
	
						left.add(Routine); //왼쪽 페이지에 각 화면들을 넣음
						left.add(Mouse);
						left.add(Guide);
						left.add(Setting);
						right.add(Constant.RightP); //오른쪽 페이지에 고급설정을 넣음.
					}
					
					PlayCount.View(play);
					left.add(PlayCount);
					
					//오른쪽 페이지(설정화면)이 켜져있다면 메인 화면의 키 입력이 안되게 막는다.
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
					
					//play가 시작되면 계속 포커스 잡아줌
					if(play.isAlive()) {content.setFocusable(true); content.requestFocus();}

					right.repaint();
					left.repaint();
					content.repaint(); //화면을 갱신한다.
					Thread.sleep(120);  //작동을 잠시 멈춘다. 1000 = 1s 임.
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
