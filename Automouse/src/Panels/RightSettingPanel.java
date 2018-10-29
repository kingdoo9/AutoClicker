package Panels;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import Constants.Constant;
import Constants.Language;
import Labels.InputLabel;
import Labels.NomalLabel;
import Setting.ButtonSetting;
import Setting.DataSetting;
import Setting.PanelSetting;

public class RightSettingPanel extends PanelSetting{
	private static final long serialVersionUID = 1L;
	private ButtonSetting save, delete, set1, set2, set3, up, down, GoS, GoE; //버튼들 설정
	private Color ColorSet = new Color(255,255,255); //Color조건부가 시작되면 그 하단에 있는 애들도 같은 색으로 저장하는 변수
	private DataSetting Data;
	private boolean see_Focus = false; //화면 보여짐, 화면 키입력을 되도록 하는 boolean변수
	
	public RightSettingPanel(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color); //대부분 설정은 상위class인 PanelSetting에 있음.
		this.setVisible(see_Focus);
		this.setFocusable(see_Focus);
		this.addKeyListener(new myActionListener()); //키 설정은 하단에 프로그래밍함.
	}
	
	public Boolean getSee_Focus() {return see_Focus;} //이 페이지가 활성화 되었는지를 return. (FramePanel에서 사용함.)
	public void onSee_Focus() {this.see_Focus = true;} //이 페이지를 보여주고 키입력이 되도록 만듬.(SettingPanel class에서 사용함.) 
	public void Colorinit() { this.ColorSet = new Color(255,255,255);} //Color End버튼을 눌렀을때  Color세팅을 초기화함(SettingPanel class에서 사용함.)
	public void setData(DataSetting data) {
		Data = data;
	}
	
	
	public void view() {	//오른쪽 페이지를 표시. 
		this.removeAll();
		if(!ColorSet.equals(new Color(255,255,255))&&!Data.isSaved()&&Data.getName()!="Color Start") Data.setRGB(ColorSet); //Color Start가 눌러져있었다면 색 설정.
		int j = 20; //일정부분씩 떨어뜨려 설정들을 표시해주게 만든다.
			
		for(char i : Data.getKind()) { //각 데이터마다 종류를 가지고있는데 그 종류대로 다음을 표시함. 'Data 패키지' 의 각 설정을 참고.
			if(i == 'M') { //마우스 초기 좌표
				this.add(new NomalLabel(Language.Language[Language.Lan.SPosition.ordinal()+Language.LSelect], 20, j, 150, 30));
				this.add(new NomalLabel("X: "+Integer.toString(Data.getSmouseX())+" Y: "+Integer.toString(Data.getSmouseY()),180,j,130,30));
				this.add(new NomalLabel(Language.Language[Language.Lan.press1.ordinal()+Language.LSelect],180,j+20,180,30));
				GoS = new ButtonSetting(Language.Language[Language.Lan.gothere.ordinal()+Language.LSelect],"GoS", 300, j+5, 100, 20);
				GoS.addActionListener(new myActionListener());
				this.add(GoS);
			}else if(i == 'E') { //마우스 종료 좌표
				this.add(new NomalLabel(Language.Language[Language.Lan.EPosition.ordinal()+Language.LSelect], 20, j, 150, 30));
				this.add(new NomalLabel("X: "+Integer.toString(Data.getEmouseX())+" Y: "+Integer.toString(Data.getEmouseY()),180,j,130,30));
				this.add(new NomalLabel(Language.Language[Language.Lan.press2.ordinal()+Language.LSelect],180,j+20,180,30));
				GoE = new ButtonSetting(Language.Language[Language.Lan.gothere.ordinal()+Language.LSelect],"GoE", 300, j+5, 100, 20);
				GoE.addActionListener(new myActionListener());
				this.add(GoE);
			}else if(i == 'N') { //횟수
				set1 = new ButtonSetting(Language.Language[Language.Lan.setup.ordinal()+Language.LSelect],"Count Set-up", 270, j+5, 80, 20);
				set1.addActionListener(new myActionListener());
				this.add(new NomalLabel(Data.getName() +Language.Language[Language.Lan.count.ordinal()+Language.LSelect], 20, j, 150, 30));
				this.add(new InputLabel(Integer.toString(Data.getNumber()), 180, j, 80, 30));
				this.add(set1);
			}else if(i == 'R') { //초당 반복횟수
				set2 = new ButtonSetting(Language.Language[Language.Lan.setup.ordinal()+Language.LSelect],"repeat Set-up", 270, j+5, 80, 20);
				set2.addActionListener(new myActionListener());
				this.add(new NomalLabel(Data.getName() +Language.Language[Language.Lan.repeat.ordinal()+Language.LSelect], 20, j, 150, 30));
				this.add(new NomalLabel(Language.Language[Language.Lan.MsgRepeat.ordinal()+Language.LSelect],20,j+25,300,30));
				this.add(new InputLabel(Integer.toString(Data.getRepeat()), 180, j, 80, 30));
				this.add(set2);
			}else if(i == 'D') { //대기 시간
				set3 = new ButtonSetting(Language.Language[Language.Lan.setup.ordinal()+Language.LSelect],"Delay Set-up", 270, j+5, 80, 20);
				set3.addActionListener(new myActionListener());
				this.add(new NomalLabel(Language.Language[Language.Lan.delay.ordinal()+Language.LSelect], 20, j, 150, 30));
				this.add(new NomalLabel(Language.Language[Language.Lan.MsgDelay.ordinal()+Language.LSelect],20,j+25,300,30));
				this.add(new InputLabel(Integer.toString(Data.getDelay()), 180, j, 80, 30));
				this.add(set3);
			}else if(i == 'C') { //색 조건부 설정
				this.add(new NomalLabel(Language.Language[Language.Lan.Color.ordinal()+Language.LSelect], 20, j, 150, 30));
				this.add(new NomalLabel(
						"R: "+Integer.toString(Data.getRGB().getRed())+" "+
						"G: "+Integer.toString(Data.getRGB().getGreen())+" "+
						"B: "+Integer.toString(Data.getRGB().getBlue()),180,j,180,30));
				ButtonSetting ViewColor = new ButtonSetting("","", 360, j, 90, 30);
				ViewColor.setBackground(Data.getRGB());
				this.add(ViewColor);
				this.add(new NomalLabel(Language.Language[Language.Lan.press3.ordinal()+Language.LSelect],180,j+20,180,30));
			}else if(i == 'H') { //색이 나올때까지 대기할 것인가.
				this.add(new NomalLabel(Language.Language[Language.Lan.HSetting.ordinal()+Language.LSelect], 20, j, 150, 30));
				this.add(new NomalLabel(Language.Language[Language.Lan.MsgHSetting.ordinal()+Language.LSelect],20,j+20,400,30));
				JCheckBox check = new JCheckBox();
				check.setSelected(Data.isHoldon());
				check.setBounds(180, j+5, 20, 20);
				check.addActionListener(new myActionListener());
				check.setActionCommand("check");
				this.add(check);
			}else if(i == 'c') { //색이 바뀔때까지 대기할 것인가.
				this.add(new NomalLabel(Language.Language[Language.Lan.CSetting.ordinal()+Language.LSelect], 20, j, 150, 30));
				this.add(new NomalLabel(Language.Language[Language.Lan.MsgCSetting.ordinal()+Language.LSelect],20,j+20,300,30));
				JCheckBox check = new JCheckBox();
				check.setSelected(Data.isChangedColor());
				check.setBounds(180, j+5, 20, 20);
				check.addActionListener(new myActionListener());
				check.setActionCommand("changed");
				this.add(check);
			}
			j += 60; //각 조건들 사이에는 Y축으로 60의 간격이 있음.
		}
		
		save = new ButtonSetting(Language.Language[Language.Lan.Save.ordinal()+Language.LSelect],"Save", 20, 405, 80, 30);
		save.addActionListener(new myActionListener());
		delete = new ButtonSetting(Language.Language[Language.Lan.Delete.ordinal()+Language.LSelect],"Delete",375,405,80,30);
		delete.addActionListener(new myActionListener());
		up = new ButtonSetting(Language.Language[Language.Lan.Up.ordinal()+Language.LSelect],"Up",179,405,50,30);
		up.addActionListener(new myActionListener());
		down = new ButtonSetting(Language.Language[Language.Lan.Down.ordinal()+Language.LSelect],"Down",233,405,50,30);
		down.addActionListener(new myActionListener());
		
		this.add(save);
		this.add(delete);
		this.add(up);
		this.add(down);
		
		this.revalidate();
		this.repaint();
		this.setVisible(see_Focus);
		System.out.println(Data.getRGB());
	}

	//버튼 및 키 설정.
	class myActionListener implements ActionListener, KeyListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				switch(e.getActionCommand()){
				
				case "Count Set-up": //횟수를 입력받아 저장
					String N = JOptionPane.showInputDialog(null,Language.Language[Language.Lan.InputNumber.ordinal()+Language.LSelect],"input",JOptionPane.QUESTION_MESSAGE);
					Data.setNumber(Integer.parseInt(N));
		        	view(); //오른쪽 페이지 갱신
					break;
				case "repeat Set-up": //초당 반복횟수를 입력받아 저장
					String R = JOptionPane.showInputDialog(null,Language.Language[Language.Lan.InputNumber.ordinal()+Language.LSelect],"input",JOptionPane.QUESTION_MESSAGE);
					if(Integer.parseInt(R)>100 || Integer.parseInt(R)<=0) break;
					Data.setRepeat(Integer.parseInt(R));
		        	view();
					break;
				case "Delay Set-up": //대기 시간을 입력받아 저장
					String D = JOptionPane.showInputDialog(null,Language.Language[Language.Lan.InputNumber.ordinal()+Language.LSelect],"input",JOptionPane.QUESTION_MESSAGE);
					Data.setDelay(Integer.parseInt(D));
		        	view();
					break;
				case "Save": //Data에 값을 저장함. 만약 저장되어있는 값이면 무시
					see_Focus = false;
					if(!Data.isSaved()) { // 저장되어있는 값이 아니라면
						Constant.data.add(Data);
						if(Data.getName().equals("Color Start"))
							ColorSet = Data.getRGB();
						Data.setSaved(true);
					}
					view();
					break;
				case "Delete": //데이터에 있는 값을 삭제시키고 오른쪽 페이지를 비활성화.
					see_Focus = false;
					if(Data.isSaved()) Constant.data.removeElement(Data);
					view();
					break;
				case "check": //체크박스를 체크시키거나 언체크시킴.
					if(Data.isHoldon()) Data.setHoldon(false);
					else Data.setHoldon(true);
					break;

				case "changed": //체크박스를 체크시키거나 언체크시킴.
					if(Data.isChangedColor()) Data.setChangedColor(false);
					else Data.setChangedColor(true);
					break;
					
				case "Up": // Data를 Routine에서 한칸 위로 올림.
					if(Data.isSaved()) {
						if(Constant.data.indexOf(Data)!=0) {
							int temp = Constant.data.indexOf(Data);
							Constant.data.removeElement(Data);
							Constant.data.insertElementAt(Data, temp-1);
						}
					}
					break;
					
				case "Down": // Data를 Routine에서 한칸 아래로 내림.
					if(Data.isSaved()) {
						if(Constant.data.indexOf(Data) != Constant.data.size()-1) {
							int temp = Constant.data.indexOf(Data);
							Constant.data.removeElement(Data);
							Constant.data.insertElementAt(Data, temp+1);
						}
					}
					break;
				case "GoS": // 좌표지점으로 마우스 이동시키기.
					new Robot().mouseMove(Data.getSmouseX(), Data.getSmouseY());
					for(int x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY(); x != Data.getSmouseX() && y != Data.getSmouseY(); x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY()) {
						int a, b;
						a = x-Data.getSmouseX();
						b = y-Data.getSmouseY();
						new Robot().mouseMove(x-a, y-b);
					}
					break;
				
				case "GoE": // 좌표지점으로 마우스 이동시키기.
					new Robot().mouseMove(Data.getEmouseX(), Data.getEmouseY());
					for(int x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY(); x != Data.getEmouseX() && y != Data.getEmouseY(); x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY()) {
						int a, b;
						a = x-Data.getEmouseX();
						b = y-Data.getEmouseY();
						new Robot().mouseMove(x-a, y-b);
					}
					break;
				}
				
				}catch(Exception ex) {

			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_1) { //1번키를 눌렀을때
				Data.setSmouseX(Constant.mouse.MouseGetX());
				Data.setSmouseY(Constant.mouse.MouseGetY());
				view();
			}
			if(e.getKeyCode() == KeyEvent.VK_2) { //2번키를 눌렀을때
				Data.setEmouseX(Constant.mouse.MouseGetX());
				Data.setEmouseY(Constant.mouse.MouseGetY());
				view();
			}
			if(e.getKeyCode() == KeyEvent.VK_3) { //3번키를 눌렀을때
				if(Data.getName().equals("Color Start")) {
					Data.setRGB(Constant.mouse.getColor());
					if(Data.isSaved()) ColorSet = Data.getRGB();
					
					if(Data.isSaved() && Constant.data.indexOf(Data) != Constant.data.size()-1) {
						for(int i=Constant.data.indexOf(Data)+1;; i++) {
							if(Constant.data.elementAt(i).getName().equals("Color End")) {ColorSet = new Color(255,255,255); break;}
							Constant.data.elementAt(i).setRGB(Data.getRGB());
							if(i == Constant.data.size()-1) break;
						}
					}
				view();
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_F5) { //'F5'번키를 눌렀을때
				JOptionPane.showMessageDialog(null, "설정창을 닫고 눌러주세요.");
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {}
		@Override
		public void keyTyped(KeyEvent e) {}

	}
}


