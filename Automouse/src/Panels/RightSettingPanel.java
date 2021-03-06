package Panels;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Constants.Constant;
import Constants.Language;
import Setting.ButtonSetting;
import Setting.DataSetting;
import Setting.InputLabel;
import Setting.NomalLabel;
import Setting.PanelSetting;

public class RightSettingPanel extends PanelSetting{
	private static final long serialVersionUID = 1L;
	private ButtonSetting save, delete, set1, set2, set3, set4, set5, set6, up, down, GoS, GoE; //버튼들 설정
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
	public int getNumberData() {return Constant.data.indexOf(Data);}
	public void setData(DataSetting data) {
		Data = data;
	}
	
	
	public void view() {	//오른쪽 페이지를 표시. 
		this.removeAll();
		this.setBounds(Constant.PreferSize(495, 10, Constant.RightWidth),Constant.PreferSize(455, 10, Constant.RightHeight),Constant.PreferSize(495, 465, Constant.RightWidth),Constant.PreferSize(455, 425, Constant.RightHeight));
		int j = Constant.PreferSize(465, 20, this.getHeight()); //일정부분씩 떨어뜨려 설정들을 표시해주게 만든다.
			
		for(char i : Data.getKind()) { //각 데이터마다 종류를 가지고있는데 그 종류대로 다음을 표시함. 'Data 패키지' 의 각 설정을 참고.
			if(i == 'M') { //마우스 초기 좌표
				this.add(new NomalLabel(Language.Language[Language.Lan.SPosition.ordinal()+Language.LSelect], Constant.PreferSize(475, 20, this.getWidth()), j, Constant.PreferSize(475, 150, this.getWidth()), Constant.PreferSize(445, 30, this.getHeight())));
				this.add(new NomalLabel("X: "+Integer.toString(Data.getSmouseX())+" Y: "+Integer.toString(Data.getSmouseY()),Constant.PreferSize(475, 180, this.getWidth()),j,Constant.PreferSize(475, 130, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				this.add(new NomalLabel(Language.Language[Language.Lan.press1.ordinal()+Language.LSelect],Constant.PreferSize(475, 180, this.getWidth()),j+Constant.PreferSize(445, 20, this.getHeight()),Constant.PreferSize(475, 180, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				GoS = new ButtonSetting(Language.Language[Language.Lan.gothere.ordinal()+Language.LSelect],"GoS", Constant.PreferSize(475, 300, this.getWidth()), j+Constant.PreferSize(445, 5, this.getHeight()), Constant.PreferSize(475, 100, this.getWidth()), Constant.PreferSize(445, 20, this.getHeight()));
				GoS.addActionListener(new myActionListener());
				this.add(GoS);
			}else if(i == 'E') { //마우스 종료 좌표
				this.add(new NomalLabel(Language.Language[Language.Lan.EPosition.ordinal()+Language.LSelect], Constant.PreferSize(475, 20, this.getWidth()),j,Constant.PreferSize(475, 150, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				this.add(new NomalLabel("X: "+Integer.toString(Data.getEmouseX())+" Y: "+Integer.toString(Data.getEmouseY()),Constant.PreferSize(475, 180, this.getWidth()),j,Constant.PreferSize(475, 130, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				this.add(new NomalLabel(Language.Language[Language.Lan.press2.ordinal()+Language.LSelect],Constant.PreferSize(475, 180, this.getWidth()),j+Constant.PreferSize(445, 20, this.getHeight()),Constant.PreferSize(475, 180, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				GoE = new ButtonSetting(Language.Language[Language.Lan.gothere.ordinal()+Language.LSelect],"GoE", Constant.PreferSize(475, 300, this.getWidth()),j+Constant.PreferSize(445, 5, this.getHeight()),Constant.PreferSize(475, 100, this.getWidth()),Constant.PreferSize(445, 20, this.getHeight()));
				GoE.addActionListener(new myActionListener());
				this.add(GoE);
			}else if(i == 'N') { //횟수
				set1 = new ButtonSetting(Language.Language[Language.Lan.setup.ordinal()+Language.LSelect],"Count Set-up", Constant.PreferSize(475, 270, this.getWidth()),j+Constant.PreferSize(445, 5, this.getHeight()),Constant.PreferSize(475, 80, this.getWidth()),Constant.PreferSize(445, 20, this.getHeight()));
				set1.addActionListener(new myActionListener());
				this.add(new NomalLabel(Data.getName() +Language.Language[Language.Lan.count.ordinal()+Language.LSelect], Constant.PreferSize(475, 20, this.getWidth()),j,Constant.PreferSize(475, 150, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				this.add(new InputLabel(Integer.toString(Data.getNumber()), Constant.PreferSize(475, 180, this.getWidth()),j,Constant.PreferSize(475, 80, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				this.add(set1);
			}else if(i == 'R') { //초당 반복횟수
				set2 = new ButtonSetting(Language.Language[Language.Lan.setup.ordinal()+Language.LSelect],"repeat Set-up", Constant.PreferSize(475, 270, this.getWidth()),j+Constant.PreferSize(445, 5, this.getHeight()),Constant.PreferSize(475, 80, this.getWidth()),Constant.PreferSize(445, 20, this.getHeight()));
				set2.addActionListener(new myActionListener());
				this.add(new NomalLabel(Data.getName() +Language.Language[Language.Lan.repeat.ordinal()+Language.LSelect], Constant.PreferSize(475, 20, this.getWidth()),j,Constant.PreferSize(475, 150, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				this.add(new NomalLabel(Language.Language[Language.Lan.MsgRepeat.ordinal()+Language.LSelect],Constant.PreferSize(475, 20, this.getWidth()),j+Constant.PreferSize(445, 25, this.getHeight()),Constant.PreferSize(475, 300, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				this.add(new InputLabel(Integer.toString(Data.getRepeat()), Constant.PreferSize(475, 180, this.getWidth()),j,Constant.PreferSize(475, 80, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				this.add(set2);
			}else if(i == 'D') { //대기 시간
				set3 = new ButtonSetting(Language.Language[Language.Lan.setup.ordinal()+Language.LSelect],"Delay Set-up", Constant.PreferSize(475, 270, this.getWidth()),j+Constant.PreferSize(445, 5, this.getHeight()),Constant.PreferSize(475, 80, this.getWidth()),Constant.PreferSize(445, 20, this.getHeight()));
				set3.addActionListener(new myActionListener());
				this.add(new NomalLabel(Language.Language[Language.Lan.delay.ordinal()+Language.LSelect], Constant.PreferSize(475, 20, this.getWidth()),j,Constant.PreferSize(475, 150, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				this.add(new NomalLabel(Language.Language[Language.Lan.MsgDelay.ordinal()+Language.LSelect],Constant.PreferSize(475, 20, this.getWidth()),j+Constant.PreferSize(445, 25, this.getHeight()),Constant.PreferSize(475, 300, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				this.add(new InputLabel(Integer.toString(Data.getDelay()), Constant.PreferSize(475, 180, this.getWidth()),j,Constant.PreferSize(475, 80, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				this.add(set3);
			}else if(i == 'C') { //색 조건부 설정
				this.add(new NomalLabel(Language.Language[Language.Lan.Color.ordinal()+Language.LSelect], Constant.PreferSize(475, 20, this.getWidth()),j,Constant.PreferSize(475, 150, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				this.add(new NomalLabel(
						"R: "+Integer.toString(Data.getRGB().getRed())+" "+
						"G: "+Integer.toString(Data.getRGB().getGreen())+" "+
						"B: "+Integer.toString(Data.getRGB().getBlue()),Constant.PreferSize(475, 180, this.getWidth()),j,Constant.PreferSize(475, 180, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				ButtonSetting ViewColor = new ButtonSetting("","", Constant.PreferSize(475, 360, this.getWidth()),j,Constant.PreferSize(475, 90, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight()));
				ViewColor.setBackground(Data.getRGB());
				this.add(ViewColor);
				this.add(new NomalLabel(Language.Language[Language.Lan.press3.ordinal()+Language.LSelect],Constant.PreferSize(475, 180, this.getWidth()),j+Constant.PreferSize(445, 20, this.getHeight()),Constant.PreferSize(475, 180, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
			}else if(i == 'H') { //색이 나올때까지 대기할 것인가.
				this.add(new NomalLabel(Language.Language[Language.Lan.HSetting.ordinal()+Language.LSelect], Constant.PreferSize(475, 20, this.getWidth()),j,Constant.PreferSize(475, 150, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				this.add(new NomalLabel(Language.Language[Language.Lan.MsgHSetting.ordinal()+Language.LSelect],Constant.PreferSize(475, 20, this.getWidth()),j+Constant.PreferSize(445, 20, this.getHeight()),Constant.PreferSize(475, 400, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				JCheckBox check = new JCheckBox();
				check.setSelected(Data.isHoldon());
				check.setBounds(Constant.PreferSize(475, 180, this.getWidth()),j+Constant.PreferSize(445, 5, this.getHeight()),20,20);
				check.addActionListener(new myActionListener());
				check.setActionCommand("check");
				this.add(check);
			}else if(i == 'c') { //색이 바뀔때까지 대기할 것인가.
				this.add(new NomalLabel(Language.Language[Language.Lan.CSetting.ordinal()+Language.LSelect], Constant.PreferSize(475, 20, this.getWidth()),j,Constant.PreferSize(475, 150, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				this.add(new NomalLabel(Language.Language[Language.Lan.MsgCSetting.ordinal()+Language.LSelect],Constant.PreferSize(475, 20, this.getWidth()),j+Constant.PreferSize(445, 20, this.getHeight()),Constant.PreferSize(475, 300, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				JCheckBox check = new JCheckBox();
				check.setSelected(Data.isChangedColor());
				check.setBounds(Constant.PreferSize(475, 180, this.getWidth()),j+Constant.PreferSize(445, 5, this.getHeight()),20,20);
				check.addActionListener(new myActionListener());
				check.setActionCommand("changed");
				this.add(check);
			}else if(i == 'F') { //폰트 사이즈 변경
				this.add(new NomalLabel(Language.Language[Language.Lan.Font.ordinal()+Language.LSelect], Constant.PreferSize(475, 20, this.getWidth()),j,Constant.PreferSize(475, 150, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				this.add(new InputLabel(Integer.toString(Data.getNumber()), Constant.PreferSize(475, 180, this.getWidth()),j,Constant.PreferSize(475, 80, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				set4 = new ButtonSetting(Language.Language[Language.Lan.setup.ordinal()+Language.LSelect],"Font Set-up", Constant.PreferSize(475, 270, this.getWidth()),j+Constant.PreferSize(445, 5, this.getHeight()),Constant.PreferSize(475, 80, this.getWidth()),Constant.PreferSize(445, 20, this.getHeight()));
				set4.addActionListener(new myActionListener());
				this.add(set4);
			}else if(i == 'L') { //색이 바뀔때까지 대기할 것인가.
				this.add(new NomalLabel(Language.Language[Language.Lan.Language.ordinal()+Language.LSelect], Constant.PreferSize(475, 20, this.getWidth()),j,Constant.PreferSize(475, 150, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight())));
				set5 = new ButtonSetting("English","Eng", Constant.PreferSize(475, 180, this.getWidth()),j,Constant.PreferSize(475, 80, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight()));
				set5.addActionListener(new myActionListener());
				this.add(set5);
				set6 = new ButtonSetting("한국어","Kor", Constant.PreferSize(475, 280, this.getWidth()),j,Constant.PreferSize(475, 80, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight()));
				set6.addActionListener(new myActionListener());
				this.add(set6);
			}else if(i == 'P') { //색이 바뀔때까지 대기할 것인가.
				
			}
			j += Constant.PreferSize(465, 60, this.getHeight()); //각 조건들 사이에는 Y축으로 60의 간격이 있음.
		}
		
		save = new ButtonSetting(Language.Language[Language.Lan.Save.ordinal()+Language.LSelect],"Save", Constant.PreferSize(475, 20, this.getWidth()),Constant.PreferSize(445, 405, this.getHeight()),Constant.PreferSize(475, 80, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight()));
		save.addActionListener(new myActionListener());
		delete = new ButtonSetting(Language.Language[Language.Lan.Delete.ordinal()+Language.LSelect],"Delete",Constant.PreferSize(475, 375, this.getWidth()),Constant.PreferSize(445, 405, this.getHeight()),Constant.PreferSize(475, 80, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight()));
		delete.addActionListener(new myActionListener());
		up = new ButtonSetting(Language.Language[Language.Lan.Up.ordinal()+Language.LSelect],"Up",Constant.PreferSize(475, 179, this.getWidth()),Constant.PreferSize(445, 405, this.getHeight()),Constant.PreferSize(475, 50, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight()));
		up.addActionListener(new myActionListener());
		down = new ButtonSetting(Language.Language[Language.Lan.Down.ordinal()+Language.LSelect],"Down",Constant.PreferSize(475, 233, this.getWidth()),Constant.PreferSize(445, 405, this.getHeight()),Constant.PreferSize(475, 50, this.getWidth()),Constant.PreferSize(445, 30, this.getHeight()));
		down.addActionListener(new myActionListener());
		
		this.add(save);
		this.add(delete);
		this.add(up);
		this.add(down);

		this.revalidate();
		this.repaint();
		this.setVisible(see_Focus);
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
				case "Font Set-up": //대기 시간을 입력받아 저장
					String F = JOptionPane.showInputDialog(null,Language.Language[Language.Lan.InputNumber.ordinal()+Language.LSelect],"input",JOptionPane.QUESTION_MESSAGE);
					Data.setNumber(Integer.parseInt(F));
		        	view();
					break;
				case "Save": //Data에 값을 저장함. 만약 저장되어있는 값이면 무시
					see_Focus = false;
					if(Data.getName().equals("Setting")) {}
					else if(!Data.isSaved()) { // 저장되어있는 값이 아니라면
						Constant.data.add(Data);
						Data.setSaved(true);
						if(Constant.data.size() > 9 && Constant.data.size()%9 == 1) Constant.Page++;
					}
					view();
					break;
				case "Delete": //데이터에 있는 값을 삭제시키고 오른쪽 페이지를 비활성화.
					see_Focus = false;
					if(Data.isSaved()) {
						Constant.data.removeElement(Data);
					}
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
							Constant.Page = (temp-1)/9+1;
						}
					}
					break;			
				case "Down": // Data를 Routine에서 한칸 아래로 내림.
					if(Data.isSaved()) {
						if(Constant.data.indexOf(Data) != Constant.data.size()-1) {
							int temp = Constant.data.indexOf(Data);
							Constant.data.removeElement(Data);
							Constant.data.insertElementAt(Data, temp+1);
							Constant.Page = (temp+1)/9+1;
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
				case "Eng": // Data를 Routine에서 한칸 아래로 내림.
					Language.LSelect = 0;
					view();
					break;
				case "Kor": // Data를 Routine에서 한칸 아래로 내림.
					Language.LSelect = Language.Language.length/2;
					view();
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


