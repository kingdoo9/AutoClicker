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
	private int BoundY=1, DataNum, DataSize, Page=1;
	private NomalLabel pages;
	private ButtonSetting prev, next;
	private PlayEvent Play;

	public RoutinePanel(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}
	
	public void View(PlayEvent play) { //FramePanel�� ���� �׻� ȭ�� ����
		this.removeAll();
		this.setBounds(Constant.PreferSize(500, 10, Constant.LeftWidth),Constant.PreferSize(465, 60, Constant.LeftHeight),Constant.PreferSize(500, 250, Constant.LeftWidth),Constant.PreferSize(465, 350, Constant.LeftHeight));
		Play = play;
		
		BoundY = 1; //�� ��ư���� �Ÿ��� ������ ����
		DataNum = (Page-1)*9; //����Ÿ�� ���ڸ� ����. ��ư�� �������� �� �����͸� ����â���� ������ ����.
		
		if(play.isAlive()) Page = (play.getJ()/9)+1;
		
		prev = new ButtonSetting(Language.Language[Language.Lan.prev.ordinal()+Language.LSelect],"Prev",Constant.PreferSize(250, 20, this.getWidth()),Constant.PreferSize(350, 319, this.getHeight()),Constant.PreferSize(250, 80, this.getWidth()),Constant.PreferSize(350, 20, this.getHeight())); //���� ������ ��ư
		prev.addActionListener(new myActionListener()); //�� ������ ������ �ϴܿ� ���α׷�����.
		
		next = new ButtonSetting(Language.Language[Language.Lan.next.ordinal()+Language.LSelect],"Next",Constant.PreferSize(250, 149, this.getWidth()),Constant.PreferSize(350, 319, this.getHeight()),Constant.PreferSize(250, 80, this.getWidth()),Constant.PreferSize(350, 20, this.getHeight())); //���� ������ ��ư
		next.addActionListener(new myActionListener());
		
		pages = new NomalLabel(Integer.toString(Page), Constant.PreferSize(250, 119, this.getWidth()),Constant.PreferSize(350, 319, this.getHeight()),Constant.PreferSize(250, 20, this.getWidth()),Constant.PreferSize(350, 20, this.getHeight())); //������ ����ǥ�� label
		DataSize = Constant.data.size(); //���� Routine ũ�⸦ ����

		for(int i=(Page-1)*9; i<DataSize && i<Page*9; i++) { //(������-1)*9 ���� �����͸� �ҷ��ͼ� 9������ ȭ�鿡 ǥ��
			ButtonSetting button = new ButtonSetting(Constant.data.elementAt(i).getName(),Integer.toString(DataNum), 1, BoundY, Constant.PreferSize(250, 248, this.getWidth()), Constant.PreferSize(350, 33, this.getHeight()));
			button.addActionListener(new myActionListener());
			if(play.isAlive() && i == play.getJ()) button.setBackground(new Color(223,223,223)); // ���α׷��� ���۵Ǿ����� ������ġ�� ǥ������
			if(Constant.RightP.getSee_Focus() && i == Constant.RightP.getNumberData()) button.setBackground(new Color(223,223,223)); // ��ư�� Ŭ�������� �� ��ư�� ��ġ�� ǥ������
			this.add(button);
			DataNum++;
			BoundY += Constant.PreferSize(350, 34, this.getHeight()); //�� ��ư���� �������ִ� �Ÿ�
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
					Constant.RightP.onSee_Focus();
					Constant.RightP.setData(Constant.data.elementAt(Integer.parseInt(e.getActionCommand())));
					Constant.RightP.view();
					break;
				
				
				}
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
