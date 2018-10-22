package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Constants.Constant;
import Setting.ButtonSetting;
import Setting.PanelSetting;

public class RoutinePanel extends PanelSetting{
	private static final long serialVersionUID = 1L;
	private RightSettingPanel RS;
	private int BoundY;
	private int DataNum;
	private int DataSize;
	private int Page=1;
	private NomalLabel pages;
	private ButtonSetting prev, next;


	public RoutinePanel(int x, int y, int width, int height, Color color, RightSettingPanel rightsetting) {
		super(x, y, width, height, color);
		this.RS = rightsetting;
	}
	
	public void View() {
		this.removeAll();
		
		DataNum = 0;
		BoundY = 1;

		
		
		prev = new ButtonSetting("Prev",20,319,80,20);
		prev.addActionListener(new myActionListener());
		next = new ButtonSetting("Next",149,319,80,20);
		next.addActionListener(new myActionListener());
		
		pages = new NomalLabel(Integer.toString(Page), 119, 319, 20, 20);
		DataSize = Constant.data.size();
		
		
		
		
		for(int i=(Page-1)*9; i<DataSize && i<Page*9; i++) {
			ButtonSetting button = new ButtonSetting(Constant.data.elementAt(i).getName(), 1, BoundY, 248, 33);
			button.setActionCommand(Integer.toString(DataNum));
			button.addActionListener(new myActionListener());
			this.add(button);
			DataNum++;
			BoundY += 34;
		}
		
		this.add(pages);
		this.add(prev);
		this.add(next);
		this.repaint();
	}
	
	class myActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				switch(e.getActionCommand()) {
				
				case "Prev" :
					if(Page != 1) { Page--; View();}
					break;
				case "Next" :
					if(Page < (DataSize/9)+1) { Page++; View();}
					break;
					
				default :
					RS.onSee_Focus();
					RS.view(Constant.data.elementAt(Integer.parseInt(e.getActionCommand())));
					View();
					break;
				
				
				}
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
