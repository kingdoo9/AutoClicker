package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import Constants.Constant;
import Constants.Language;
import Data.FileData;
import Data.RoutineData;
import Panels.FramePanel.myActionListener;
import Setting.ButtonSetting;
import Setting.DataSetting;
import Setting.PanelSetting;

public class LeftPanel extends PanelSetting{
	private static final long serialVersionUID = 1L;
	private ButtonSetting save, load, New, lang;
	private RoutineData RD;
	
	public LeftPanel(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color); //��κ� ������ ����class�� PanelSetting�� ����.
	}

	public void View() {
		// TODO Auto-generated method stub
		this.removeAll();
		
		
		//����, �ҷ����� ��ư
		save = new ButtonSetting(Language.Language[Language.Lan.Save.ordinal()+Language.LSelect],"Save", 10, 420, 80, 30); // ���� ��ư�� x=10,y=420 ���������� ũ�� 80 X 30 ���� ��ư ����
		save.addActionListener(new myActionListener()); //��ư Ŭ���� ������ �ϴܿ� ���α׷�����.
		load = new ButtonSetting(Language.Language[Language.Lan.Load.ordinal()+Language.LSelect],"Load", 100, 420, 80, 30); // �ҷ����� ��ư�� x=100,y=420 ���������� ũ�� 80 X 30 ���� ��ư ����
		load.addActionListener(new myActionListener()); //��ư Ŭ���� ������ �ϴܿ� ���α׷�����.
		New = new ButtonSetting(Language.Language[Language.Lan.New.ordinal()+Language.LSelect],"New", 310, 420, 80, 30); // �ҷ����� ��ư�� x=100,y=420 ���������� ũ�� 80 X 30 ���� ��ư ����
		New.addActionListener(new myActionListener());
		lang = new ButtonSetting(Language.Language[Language.Lan.Language.ordinal()+Language.LSelect],"Language", 410, 420, 80, 30); // �ҷ����� ��ư�� x=100,y=420 ���������� ũ�� 80 X 30 ���� ��ư ����
		lang.addActionListener(new myActionListener());
	
		this.add(save);
		this.add(load);
		this.add(New);
		this.add(lang);
	
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
					
				case "Language": // ��ư�� �Է��� Language�̸�
					int lan = JOptionPane.showOptionDialog(null, Language.Language[Language.Lan.MsgLanguage.ordinal()+Language.LSelect], "new", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, Language.Choose, null);
					
					if(lan == 0)Language.LSelect = 0;
					else Language.LSelect = Language.Language.length/2;
					break;
				}
			}catch(Exception E) {}
		}
	}
}
