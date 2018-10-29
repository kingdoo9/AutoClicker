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
	private ButtonSetting save, delete, set1, set2, set3, up, down, GoS, GoE; //��ư�� ����
	private Color ColorSet = new Color(255,255,255); //Color���Ǻΰ� ���۵Ǹ� �� �ϴܿ� �ִ� �ֵ鵵 ���� ������ �����ϴ� ����
	private DataSetting Data;
	private boolean see_Focus = false; //ȭ�� ������, ȭ�� Ű�Է��� �ǵ��� �ϴ� boolean����
	
	public RightSettingPanel(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color); //��κ� ������ ����class�� PanelSetting�� ����.
		this.setVisible(see_Focus);
		this.setFocusable(see_Focus);
		this.addKeyListener(new myActionListener()); //Ű ������ �ϴܿ� ���α׷�����.
	}
	
	public Boolean getSee_Focus() {return see_Focus;} //�� �������� Ȱ��ȭ �Ǿ������� return. (FramePanel���� �����.)
	public void onSee_Focus() {this.see_Focus = true;} //�� �������� �����ְ� Ű�Է��� �ǵ��� ����.(SettingPanel class���� �����.) 
	public void Colorinit() { this.ColorSet = new Color(255,255,255);} //Color End��ư�� ��������  Color������ �ʱ�ȭ��(SettingPanel class���� �����.)
	public void setData(DataSetting data) {
		Data = data;
	}
	
	
	public void view() {	//������ �������� ǥ��. 
		this.removeAll();
		if(!ColorSet.equals(new Color(255,255,255))&&!Data.isSaved()&&Data.getName()!="Color Start") Data.setRGB(ColorSet); //Color Start�� �������־��ٸ� �� ����.
		int j = 20; //�����κо� ����߷� �������� ǥ�����ְ� �����.
			
		for(char i : Data.getKind()) { //�� �����͸��� ������ �������ִµ� �� ������� ������ ǥ����. 'Data ��Ű��' �� �� ������ ����.
			if(i == 'M') { //���콺 �ʱ� ��ǥ
				this.add(new NomalLabel(Language.Language[Language.Lan.SPosition.ordinal()+Language.LSelect], 20, j, 150, 30));
				this.add(new NomalLabel("X: "+Integer.toString(Data.getSmouseX())+" Y: "+Integer.toString(Data.getSmouseY()),180,j,130,30));
				this.add(new NomalLabel(Language.Language[Language.Lan.press1.ordinal()+Language.LSelect],180,j+20,180,30));
				GoS = new ButtonSetting(Language.Language[Language.Lan.gothere.ordinal()+Language.LSelect],"GoS", 300, j+5, 100, 20);
				GoS.addActionListener(new myActionListener());
				this.add(GoS);
			}else if(i == 'E') { //���콺 ���� ��ǥ
				this.add(new NomalLabel(Language.Language[Language.Lan.EPosition.ordinal()+Language.LSelect], 20, j, 150, 30));
				this.add(new NomalLabel("X: "+Integer.toString(Data.getEmouseX())+" Y: "+Integer.toString(Data.getEmouseY()),180,j,130,30));
				this.add(new NomalLabel(Language.Language[Language.Lan.press2.ordinal()+Language.LSelect],180,j+20,180,30));
				GoE = new ButtonSetting(Language.Language[Language.Lan.gothere.ordinal()+Language.LSelect],"GoE", 300, j+5, 100, 20);
				GoE.addActionListener(new myActionListener());
				this.add(GoE);
			}else if(i == 'N') { //Ƚ��
				set1 = new ButtonSetting(Language.Language[Language.Lan.setup.ordinal()+Language.LSelect],"Count Set-up", 270, j+5, 80, 20);
				set1.addActionListener(new myActionListener());
				this.add(new NomalLabel(Data.getName() +Language.Language[Language.Lan.count.ordinal()+Language.LSelect], 20, j, 150, 30));
				this.add(new InputLabel(Integer.toString(Data.getNumber()), 180, j, 80, 30));
				this.add(set1);
			}else if(i == 'R') { //�ʴ� �ݺ�Ƚ��
				set2 = new ButtonSetting(Language.Language[Language.Lan.setup.ordinal()+Language.LSelect],"repeat Set-up", 270, j+5, 80, 20);
				set2.addActionListener(new myActionListener());
				this.add(new NomalLabel(Data.getName() +Language.Language[Language.Lan.repeat.ordinal()+Language.LSelect], 20, j, 150, 30));
				this.add(new NomalLabel(Language.Language[Language.Lan.MsgRepeat.ordinal()+Language.LSelect],20,j+25,300,30));
				this.add(new InputLabel(Integer.toString(Data.getRepeat()), 180, j, 80, 30));
				this.add(set2);
			}else if(i == 'D') { //��� �ð�
				set3 = new ButtonSetting(Language.Language[Language.Lan.setup.ordinal()+Language.LSelect],"Delay Set-up", 270, j+5, 80, 20);
				set3.addActionListener(new myActionListener());
				this.add(new NomalLabel(Language.Language[Language.Lan.delay.ordinal()+Language.LSelect], 20, j, 150, 30));
				this.add(new NomalLabel(Language.Language[Language.Lan.MsgDelay.ordinal()+Language.LSelect],20,j+25,300,30));
				this.add(new InputLabel(Integer.toString(Data.getDelay()), 180, j, 80, 30));
				this.add(set3);
			}else if(i == 'C') { //�� ���Ǻ� ����
				this.add(new NomalLabel(Language.Language[Language.Lan.Color.ordinal()+Language.LSelect], 20, j, 150, 30));
				this.add(new NomalLabel(
						"R: "+Integer.toString(Data.getRGB().getRed())+" "+
						"G: "+Integer.toString(Data.getRGB().getGreen())+" "+
						"B: "+Integer.toString(Data.getRGB().getBlue()),180,j,180,30));
				ButtonSetting ViewColor = new ButtonSetting("","", 360, j, 90, 30);
				ViewColor.setBackground(Data.getRGB());
				this.add(ViewColor);
				this.add(new NomalLabel(Language.Language[Language.Lan.press3.ordinal()+Language.LSelect],180,j+20,180,30));
			}else if(i == 'H') { //���� ���ö����� ����� ���ΰ�.
				this.add(new NomalLabel(Language.Language[Language.Lan.HSetting.ordinal()+Language.LSelect], 20, j, 150, 30));
				this.add(new NomalLabel(Language.Language[Language.Lan.MsgHSetting.ordinal()+Language.LSelect],20,j+20,400,30));
				JCheckBox check = new JCheckBox();
				check.setSelected(Data.isHoldon());
				check.setBounds(180, j+5, 20, 20);
				check.addActionListener(new myActionListener());
				check.setActionCommand("check");
				this.add(check);
			}else if(i == 'c') { //���� �ٲ𶧱��� ����� ���ΰ�.
				this.add(new NomalLabel(Language.Language[Language.Lan.CSetting.ordinal()+Language.LSelect], 20, j, 150, 30));
				this.add(new NomalLabel(Language.Language[Language.Lan.MsgCSetting.ordinal()+Language.LSelect],20,j+20,300,30));
				JCheckBox check = new JCheckBox();
				check.setSelected(Data.isChangedColor());
				check.setBounds(180, j+5, 20, 20);
				check.addActionListener(new myActionListener());
				check.setActionCommand("changed");
				this.add(check);
			}
			j += 60; //�� ���ǵ� ���̿��� Y������ 60�� ������ ����.
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

	//��ư �� Ű ����.
	class myActionListener implements ActionListener, KeyListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				switch(e.getActionCommand()){
				
				case "Count Set-up": //Ƚ���� �Է¹޾� ����
					String N = JOptionPane.showInputDialog(null,Language.Language[Language.Lan.InputNumber.ordinal()+Language.LSelect],"input",JOptionPane.QUESTION_MESSAGE);
					Data.setNumber(Integer.parseInt(N));
		        	view(); //������ ������ ����
					break;
				case "repeat Set-up": //�ʴ� �ݺ�Ƚ���� �Է¹޾� ����
					String R = JOptionPane.showInputDialog(null,Language.Language[Language.Lan.InputNumber.ordinal()+Language.LSelect],"input",JOptionPane.QUESTION_MESSAGE);
					if(Integer.parseInt(R)>100 || Integer.parseInt(R)<=0) break;
					Data.setRepeat(Integer.parseInt(R));
		        	view();
					break;
				case "Delay Set-up": //��� �ð��� �Է¹޾� ����
					String D = JOptionPane.showInputDialog(null,Language.Language[Language.Lan.InputNumber.ordinal()+Language.LSelect],"input",JOptionPane.QUESTION_MESSAGE);
					Data.setDelay(Integer.parseInt(D));
		        	view();
					break;
				case "Save": //Data�� ���� ������. ���� ����Ǿ��ִ� ���̸� ����
					see_Focus = false;
					if(!Data.isSaved()) { // ����Ǿ��ִ� ���� �ƴ϶��
						Constant.data.add(Data);
						if(Data.getName().equals("Color Start"))
							ColorSet = Data.getRGB();
						Data.setSaved(true);
					}
					view();
					break;
				case "Delete": //�����Ϳ� �ִ� ���� ������Ű�� ������ �������� ��Ȱ��ȭ.
					see_Focus = false;
					if(Data.isSaved()) Constant.data.removeElement(Data);
					view();
					break;
				case "check": //üũ�ڽ��� üũ��Ű�ų� ��üũ��Ŵ.
					if(Data.isHoldon()) Data.setHoldon(false);
					else Data.setHoldon(true);
					break;

				case "changed": //üũ�ڽ��� üũ��Ű�ų� ��üũ��Ŵ.
					if(Data.isChangedColor()) Data.setChangedColor(false);
					else Data.setChangedColor(true);
					break;
					
				case "Up": // Data�� Routine���� ��ĭ ���� �ø�.
					if(Data.isSaved()) {
						if(Constant.data.indexOf(Data)!=0) {
							int temp = Constant.data.indexOf(Data);
							Constant.data.removeElement(Data);
							Constant.data.insertElementAt(Data, temp-1);
						}
					}
					break;
					
				case "Down": // Data�� Routine���� ��ĭ �Ʒ��� ����.
					if(Data.isSaved()) {
						if(Constant.data.indexOf(Data) != Constant.data.size()-1) {
							int temp = Constant.data.indexOf(Data);
							Constant.data.removeElement(Data);
							Constant.data.insertElementAt(Data, temp+1);
						}
					}
					break;
				case "GoS": // ��ǥ�������� ���콺 �̵���Ű��.
					new Robot().mouseMove(Data.getSmouseX(), Data.getSmouseY());
					for(int x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY(); x != Data.getSmouseX() && y != Data.getSmouseY(); x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY()) {
						int a, b;
						a = x-Data.getSmouseX();
						b = y-Data.getSmouseY();
						new Robot().mouseMove(x-a, y-b);
					}
					break;
				
				case "GoE": // ��ǥ�������� ���콺 �̵���Ű��.
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
			if(e.getKeyCode() == KeyEvent.VK_1) { //1��Ű�� ��������
				Data.setSmouseX(Constant.mouse.MouseGetX());
				Data.setSmouseY(Constant.mouse.MouseGetY());
				view();
			}
			if(e.getKeyCode() == KeyEvent.VK_2) { //2��Ű�� ��������
				Data.setEmouseX(Constant.mouse.MouseGetX());
				Data.setEmouseY(Constant.mouse.MouseGetY());
				view();
			}
			if(e.getKeyCode() == KeyEvent.VK_3) { //3��Ű�� ��������
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
			if(e.getKeyCode() == KeyEvent.VK_F5) { //'F5'��Ű�� ��������
				JOptionPane.showMessageDialog(null, "����â�� �ݰ� �����ּ���.");
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {}
		@Override
		public void keyTyped(KeyEvent e) {}

	}
}


