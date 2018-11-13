package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import Constants.Constant;
import Constants.Language;
import Data.FileData;
import Data.RoutineData;
import Setting.ButtonSetting;
import Setting.DataSetting;
import Setting.PanelSetting;

public class LeftPanel extends PanelSetting{
	private static final long serialVersionUID = 1L;
	private ButtonSetting save, load, New, setting;
	private RoutineData RD;
	
	public LeftPanel(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color); //��κ� ������ ����class�� PanelSetting�� ����.
	}

	public void View() {
		// TODO Auto-generated method stub
		this.removeAll();
		
		Constant.LeftWidth = this.getWidth();
		Constant.LeftHeight = this.getHeight();
		
		this.setBounds(0,0,Constant.PreferSize(1000, 500,Constant.FrameWidth),Constant.PreferSize(500, 465,Constant.Frameheight));
		//����, �ҷ����� ��ư
		save = new ButtonSetting(Language.Language[Language.Lan.Save.ordinal()+Language.LSelect],"Save",//�Ʒ��� ũ�⼳��
				Constant.PreferSize(500, 10,this.getWidth()), Constant.PreferSize(465, 420,this.getHeight()), Constant.PreferSize(500, 80,this.getWidth()), Constant.PreferSize(500, 30,this.getHeight())); // ���� ��ư�� x=10,y=420 ���������� ũ�� 80 X 30 ���� ��ư ����(����)
		save.addActionListener(new myActionListener()); //��ư Ŭ���� ������ �ϴܿ� ���α׷�����.
		
		load = new ButtonSetting(Language.Language[Language.Lan.Load.ordinal()+Language.LSelect],"Load",//�Ʒ��� ũ�⼳��
				Constant.PreferSize(500, 100,this.getWidth()), Constant.PreferSize(465, 420,this.getHeight()), Constant.PreferSize(500, 80,this.getWidth()), Constant.PreferSize(500, 30,this.getHeight())); // �ҷ����� ��ư�� x=100,y=420 ���������� ũ�� 80 X 30 ���� ��ư ����(����)
		load.addActionListener(new myActionListener()); //��ư Ŭ���� ������ �ϴܿ� ���α׷�����.
		
		New = new ButtonSetting(Language.Language[Language.Lan.New.ordinal()+Language.LSelect],"New",//�Ʒ��� ũ�⼳��
				Constant.PreferSize(500, 310,this.getWidth()), Constant.PreferSize(465, 420,this.getHeight()), Constant.PreferSize(500, 80,this.getWidth()), Constant.PreferSize(500, 30,this.getHeight())); // ���θ���� ��ư�� x=100,y=420 ���������� ũ�� 80 X 30 ���� ��ư ����(����)
		New.addActionListener(new myActionListener());
		
		setting = new ButtonSetting(Language.Language[Language.Lan.Language.ordinal()+Language.LSelect],"Language",//�Ʒ��� ũ�⼳��
				Constant.PreferSize(500, 410,this.getWidth()), Constant.PreferSize(465, 420,this.getHeight()), Constant.PreferSize(500, 80,this.getWidth()), Constant.PreferSize(500, 30,this.getHeight())); // ���� ��ư�� x=100,y=420 ���������� ũ�� 80 X 30 ���� ��ư ����(����)
		setting.addActionListener(new myActionListener());
	
		this.add(save);
		this.add(load);
		this.add(New);
		this.add(setting);
	
	}
	
	class myActionListener implements ActionListener{
		@SuppressWarnings("unchecked")
		@Override
		//��ư ����
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 //������ ���� ����ִ� �Լ�.
			try {
				switch(e.getActionCommand()) {
				
				case "Save": //��ư�� �Է��� Save�̸�
					String S = JOptionPane.showInputDialog(null,Language.Language[Language.Lan.MsgSFile.ordinal()+Language.LSelect],"input",JOptionPane.QUESTION_MESSAGE);
					RD = new RoutineData(); 
					RD.setObj(Constant.data); // Routine ���� ����ȭ ��Ű��
					new FileData(); //������ ������ִ� class�� �����ѵ�
					FileData.save(S, RD.getObj()); //������ �Է��� �����̸� D�� Routine���� ������.
					break;
					
				case "Load": // ��ư�� �Է��� Load�̸�
					String L = JOptionPane.showInputDialog(null,Language.Language[Language.Lan.MsgLFile.ordinal()+Language.LSelect],"input",JOptionPane.QUESTION_MESSAGE);
					new FileData();
					Constant.data = (Vector<DataSetting>) FileData.read(L); //������ �о Constant Ŭ������ data�� ����.
					break;
					
				case "New": // ��ư�� �Է��� New�̸�
					int Ok = JOptionPane.showOptionDialog(null, Language.Language[Language.Lan.MsgNFile.ordinal()+Language.LSelect], "new", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					if(Ok == 0) Constant.data.removeAllElements();
					break;
					
				case "setting": // ��ư�� �Է��� Language�̸�
					int lan = JOptionPane.showOptionDialog(null, Language.Language[Language.Lan.MsgLanguage.ordinal()+Language.LSelect], "new", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, Language.Choose, null);
					
					if(lan == 0)Language.LSelect = 0;
					else Language.LSelect = Language.Language.length/2;
					break;
				}
			}catch(Exception E) {}
		}
	}
}
