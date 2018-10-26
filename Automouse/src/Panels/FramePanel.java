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

public class FramePanel extends JFrame{ //JFrame 함수. 프레임의 틀을 짜며 매 시간마다 화면을 갱신하는 역할을 한다.
	private static final long serialVersionUID = 1L;
	private GThread runner =new GThread(); //매 시간마다 화면을 갱신해주는 Thread
	private MousePanel Mouse;
	private Container content;
	private RightSettingPanel rightsetting;
	private RoutinePanel Routine;
	private GuidePanel Guide;
	private SettingPanel Setting;
	private ButtonSetting save, load, New;
	private PanelSetting right;
	private PanelSetting left;
	private PlayEvent play;
	private RoutineData RD;

	public FramePanel() throws InterruptedException, AWTException {
		super("AutoSetting"); // 프레임의 제목표시줄의 제목을 결정.
		this.setPreferredSize(new Dimension(Constant.FrameWidth,Constant.Frameheight)); // Jframe의 크기를 설정
		this.setLayout(null); // 레이아웃을 없이 만들어 Bounds설정으로 위치 및 크기를 조정해야한다.
		this.setResizable(false); //프레임 크기변경 불가능
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우창 X버튼누를때 강제종료
		
		//컨테이너 (모든패널 저장공간)
		content = this.getContentPane();
		content.addKeyListener(new myActionListener()); //컨테이너 키 입력을 추가해준다. 가장 하단에 키 입력 시 행동을 프로그래밍함.		
		//오른쪽 안쪽 패널
		rightsetting = new RightSettingPanel(10, 10, 475, 445, Color.white);		
		//루틴 패널
		Routine = new RoutinePanel(10,60,250,350,Color.white,rightsetting);		
		//F5, F6를 누르시오 패널
		Guide = new GuidePanel(10,10,200,40,Color.white);	
		//설정 패널
		Setting = new SettingPanel(270,60,220,350,Color.white,rightsetting);	
		//오른쪽 패널
		right = new MainPanel(500,0,495,465,new Color(213,242,211));			
		//왼쪽 패널
		left = new MainPanel(0,0,500,465,new Color(213,242,211));		
		//마우스 좌표 패널
		Mouse = new MousePanel(220,10,270,40,Color.white);		
		//저장, 불러오기 버튼
		save = new ButtonSetting("저장","Save", 10, 420, 80, 30); // 저장 버튼을 x=10,y=420 떨어진곳에 크기 80 X 30 으로 버튼 생성
		save.addActionListener(new myActionListener()); //버튼 클릭시 설정은 하단에 프로그래밍함.
		load = new ButtonSetting("불러오기","Load", 100, 420, 80, 30); // 불러오기 버튼을 x=100,y=420 떨어진곳에 크기 80 X 30 으로 버튼 생성
		load.addActionListener(new myActionListener()); //버튼 클릭시 설정은 하단에 프로그래밍함.
		New = new ButtonSetting("새로만들기","New", 410, 420, 80, 30); // 불러오기 버튼을 x=100,y=420 떨어진곳에 크기 80 X 30 으로 버튼 생성
		New.addActionListener(new myActionListener());
		
		left.add(Routine); //왼쪽 페이지에 각 화면들을 넣음
		left.add(Mouse);
		left.add(Guide);
		left.add(Setting);
		left.add(save);
		left.add(load);
		left.add(New);
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
					
					//오른쪽 페이지(설정화면)이 켜져있다면 메인 화면의 키 입력이 안되게 막는다.
					if(!rightsetting.getSee_Focus()) {
						rightsetting.setFocusable(false);
						content.setFocusable(true);
						content.requestFocus();
					}
					else {
						content.setFocusable(false);
						rightsetting.setFocusable(true);
						rightsetting.requestFocus();
					}
					
					Routine.View(); //루틴 화면(왼쪽중앙)과 마우스 화면(위쪽 중앙)은  항상 바뀌도록 해야하므로 설정함.
					Mouse.View();
		
					content.repaint(); //화면을 갱신한다.
		        }catch (Exception ex){
		        	System.out.println(ex.getMessage());
		        } 
			} 
		}
	}
	
	//버튼 설정 및 F5, F6키에 대한 설정들
	class myActionListener implements ActionListener, KeyListener{


		@SuppressWarnings("unchecked")
		@Override
		//버튼 설정
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 //오류가 나면 잡아주는 함수.
			try {
				switch(e.getActionCommand()) {
				
				case "Save": //버튼의 입력이 Save이면
					String S = JOptionPane.showInputDialog(null,"저장시 파일명을 입력해주세요. \n \\  /  :  \"  *  ?  .  <  >  |  \n 입력시 파일이 생성되지 않을 수 있습니다.)","input",JOptionPane.QUESTION_MESSAGE);
					RD = new RoutineData(); 
					RD.setObj(Constant.data); // Routine 들을 직렬화 시키고
					new FileData(); //파일을 만들어주는 class를 생성한뒤
					FileData.save(S, RD.getObj()); //위에서 입력한 파일이름 D로 Routine들을 저장함.
					break;
					
				case "Load": // 버튼의 입력이 Load이면
					String L = JOptionPane.showInputDialog(null,"불러올 파일명을 입력해주세요.","input",JOptionPane.QUESTION_MESSAGE);
					new FileData();
					Constant.data = (Vector<DataSetting>) FileData.read(L); //파일을 읽어서 Constant 클래스의 data에 저장.
					break;
					
				case "New": // 버튼의 입력이 New이면
					int Ok = JOptionPane.showOptionDialog(null, "정말로 새로만드시겠습니까?", "new", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					if(Ok == 0) Constant.data.removeAllElements();
					break;
				}
			}catch(Exception E) {}
		}

		//키 설정
		@SuppressWarnings("deprecation")
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			try {

				if(e.getKeyCode() == KeyEvent.VK_F5) {
					//반복횟수 설정 대화창
					String D = JOptionPane.showInputDialog(null,"몇번 반복하시겠습니까?","input",JOptionPane.QUESTION_MESSAGE);
					play = new PlayEvent(Integer.parseInt(D));
					play.start();
				}
				if(e.getKeyCode() == KeyEvent.VK_F6) {
					play.stop();
				}
			} catch (Exception e1) { // 숫자가 아닌 수가 입력되었을때 의 error 메시지
				JOptionPane.showMessageDialog(null, "입력 형식이 올바르지 않습니다.");
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {}
		@Override
		public void keyTyped(KeyEvent e) {}
	}
	
}
