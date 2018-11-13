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
	
	public void View(PlayEvent play) { //FramePanel로 인해 항상 화면 갱신
		this.removeAll();
		this.setBounds(Constant.PreferSize(500, 10, Constant.LeftWidth),Constant.PreferSize(465, 60, Constant.LeftHeight),Constant.PreferSize(500, 250, Constant.LeftWidth),Constant.PreferSize(465, 350, Constant.LeftHeight));
		Play = play;
		
		BoundY = 1; //각 버튼끼리 거리를 조절해 생성
		DataNum = (Page-1)*9; //데이타에 숫자를 정함. 버튼을 눌렀을때 그 데이터를 설정창으로 보내기 위함.
		
		if(play.isAlive()) Page = (play.getJ()/9)+1;
		
		prev = new ButtonSetting(Language.Language[Language.Lan.prev.ordinal()+Language.LSelect],"Prev",Constant.PreferSize(250, 20, this.getWidth()),Constant.PreferSize(350, 319, this.getHeight()),Constant.PreferSize(250, 80, this.getWidth()),Constant.PreferSize(350, 20, this.getHeight())); //이전 페이지 버튼
		prev.addActionListener(new myActionListener()); //이 설정은 페이지 하단에 프로그래밍함.
		
		next = new ButtonSetting(Language.Language[Language.Lan.next.ordinal()+Language.LSelect],"Next",Constant.PreferSize(250, 149, this.getWidth()),Constant.PreferSize(350, 319, this.getHeight()),Constant.PreferSize(250, 80, this.getWidth()),Constant.PreferSize(350, 20, this.getHeight())); //다음 페이지 버튼
		next.addActionListener(new myActionListener());
		
		pages = new NomalLabel(Integer.toString(Page), Constant.PreferSize(250, 119, this.getWidth()),Constant.PreferSize(350, 319, this.getHeight()),Constant.PreferSize(250, 20, this.getWidth()),Constant.PreferSize(350, 20, this.getHeight())); //페이지 숫자표시 label
		DataSize = Constant.data.size(); //현재 Routine 크기를 저장

		for(int i=(Page-1)*9; i<DataSize && i<Page*9; i++) { //(페이지-1)*9 부터 데이터를 불러와서 9개까지 화면에 표시
			ButtonSetting button = new ButtonSetting(Constant.data.elementAt(i).getName(),Integer.toString(DataNum), 1, BoundY, Constant.PreferSize(250, 248, this.getWidth()), Constant.PreferSize(350, 33, this.getHeight()));
			button.addActionListener(new myActionListener());
			if(play.isAlive() && i == play.getJ()) button.setBackground(new Color(223,223,223)); // 프로그램이 시작되었을때 지금위치를 표시해줌
			if(Constant.RightP.getSee_Focus() && i == Constant.RightP.getNumberData()) button.setBackground(new Color(223,223,223)); // 버튼을 클릭했을때 그 버튼의 위치를 표시해줌
			this.add(button);
			DataNum++;
			BoundY += Constant.PreferSize(350, 34, this.getHeight()); //각 버튼끼리 떨어져있는 거리
		}
		
		

		
		this.add(pages);
		this.add(prev);
		this.add(next);
		this.repaint();
	}
	
	//버튼 설정
	class myActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				switch(e.getActionCommand()) {
				
				case "Prev" : //이전페이지
					if(Page != 1) { Page--; View(Play);}
					break;
				case "Next" : //다음페이지
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
