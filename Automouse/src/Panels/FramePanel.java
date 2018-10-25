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
		this.setResizable(false); //프레임 크기변경 불가능
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우창 X버튼누를때 강제종료
		
		//컨테이너 (모든패널 저장공간)
		content = this.getContentPane();
		content.addKeyListener(new myActionListener());
		
		
		//오른쪽 안쪽 패널
		rightsetting = new RightSettingPanel(10, 10, 475, 445, Color.white);
		
		//루틴 패널
		Routine = new RoutinePanel(10,60,250,350,Color.white,rightsetting);
		
		//F5, F6를 누르시오 패널
		Guide = new GuidePanel(10,10,200,40,Color.white);	
		//설정 패널
		Setting = new SettingPanel(270,60,220,350,Color.white,rightsetting);
		
		//저장, 불러오기 버튼
		save = new ButtonSetting("저장", 10, 420, 80, 30);
		save.setActionCommand("Save");
		save.addActionListener(new myActionListener());
		load = new ButtonSetting("불러오기", 100, 420, 80, 30);
		load.setActionCommand("Load");
		load.addActionListener(new myActionListener());
		
		//오른쪽 패널
		right = new MainPanel(500,0,495,465,new Color(213,242,211));	
		
		//왼쪽 패널
		left = new MainPanel(0,0,500,465,new Color(213,242,211));
		
		//마우스 좌표 패널
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
	
	//버튼 설정 및 F5, F6키에 대한 설정들
	class myActionListener implements ActionListener, KeyListener{

		//버튼 설정
		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				if(e.getActionCommand() == "Save") {
					String D = JOptionPane.showInputDialog(null,"저장시 파일명을 입력해주세요. \n \\  /  :  \"  *  ?  .  <  >  |  \n 입력시 파일이 생성되지 않을 수 있습니다.)","input",JOptionPane.QUESTION_MESSAGE);
					new FileData();
					RD = new RoutineData();
					RD.setObj(Constant.data);
					FileData.save(D, RD.getObj());
				}else {
					String D = JOptionPane.showInputDialog(null,"불러올 파일명을 입력해주세요.","input",JOptionPane.QUESTION_MESSAGE);
					new FileData();
					Constant.data = (Vector<DataSetting>) FileData.read(D);
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
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
}
