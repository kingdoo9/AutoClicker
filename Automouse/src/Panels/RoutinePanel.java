package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Constants.Constant;
import Constants.Language;
import Events.PlayEvent;
import Labels.NomalLabel;
import Setting.ButtonSetting;
import Setting.PanelSetting;

public class RoutinePanel extends PanelSetting{
	private static final long serialVersionUID = 1L;
	private RightSettingPanel RS;
	private int BoundY=1, DataNum, DataSize, Page=1;
	private NomalLabel pages;
	private ButtonSetting prev, next;
	private PlayEvent Play;

	public RoutinePanel(int x, int y, int width, int height, Color color, RightSettingPanel rightsetting) {
		super(x, y, width, height, color);
		this.RS = rightsetting;
	}
	
	public void View(PlayEvent play) { //FramePanel�� ���� �׻� ȭ�� ����
		this.removeAll();
		Play = play;
		
		BoundY = 1; //�� ��ư���� �Ÿ��� ������ ����
		DataNum = (Page-1)*9; //����Ÿ�� ���ڸ� ����. ��ư�� �������� �� �����͸� ����â���� ������ ����.
		
		prev = new ButtonSetting(Language.Language[Language.Lan.prev.ordinal()+Language.LSelect],"Prev",20,319,80,20); //���� ������ ��ư
		prev.addActionListener(new myActionListener()); //�� ������ ������ �ϴܿ� ���α׷�����.
		
		next = new ButtonSetting(Language.Language[Language.Lan.next.ordinal()+Language.LSelect],"Next",149,319,80,20); //���� ������ ��ư
		next.addActionListener(new myActionListener());
		
		pages = new NomalLabel(Integer.toString(Page), 119, 319, 20, 20); //������ ����ǥ�� label
		DataSize = Constant.data.size(); //���� Routine ũ�⸦ ����

		for(int i=(Page-1)*9; i<DataSize && i<Page*9; i++) { //(������-1)*9 ���� �����͸� �ҷ��ͼ� 9������ ȭ�鿡 ǥ��
			ButtonSetting button = new ButtonSetting(Constant.data.elementAt(i).getName(),Integer.toString(DataNum), 1, BoundY, 248, 33);
			button.addActionListener(new myActionListener());
			if(play.isAlive() && i == play.getJ()) button.setBackground(new Color(223,223,223));
			this.add(button);
			DataNum++;
			BoundY += 34; //�� ��ư���� �������ִ� �Ÿ�
		}
		
		this.add(pages);
		this.add(prev);
		this.add(next);
		this.repaint();
	}
	
	//��ư ����
	class myActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				switch(e.getActionCommand()) {
				
				case "Prev" : //����������
					if(Page != 1) { Page--; View(Play);}
					break;
				case "Next" : //����������
					if(Page < (DataSize/9)+1) { Page++; View(Play);}
					break;
					
				default :
					RS.onSee_Focus();
					RS.setData(Constant.data.elementAt(Integer.parseInt(e.getActionCommand())));
					RS.view();
					break;
				
				
				}
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
