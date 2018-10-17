package Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import Data.Click;
import Data.ColorS;
import Data.Delay;
import Data.Drag;
import Setting.DataSetting;
import Setting.PanelSetting;

public class ButtonListener implements ActionListener{
	private static final long serialVersionUID = 1L;
		private final String title;
		private PanelSetting PS;
		private Queue<DataSetting> routine = new LinkedList<>();
		private DataSetting DS;
		public ButtonListener(String title, PanelSetting PS) {
		// TODO Auto-generated constructor stub
			this.title = title;
			this.PS = PS;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(title.matches("Save")) {
				System.out.println("saved");
			}else if(title.matches("Load")) {
				System.out.println("loaded");
			}else if(title.matches("save")) {
				PS.setVisible(false);
			}else if(title.matches("Click Setting")) {
				DS = new Click();
				PS.view(DS);
			}else if(title.matches("Drag Setting")) {
				DS = new Drag();
				PS.view(DS);
			}else if(title.matches("Delay Setting")) {
				DS = new Delay();
				PS.view(DS);
			}else if(title.matches("Color Start")) {
				DS = new ColorS();
				PS.view(DS);
			}
			
		}
	
}
