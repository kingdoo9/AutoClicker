package Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener{
	private static final long serialVersionUID = 1L;
		private final String title;
	
		public ButtonListener(String title) {
		// TODO Auto-generated constructor stub
			this.title = title;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(title.matches("Save")) {
				System.out.println("saved");
			}else if(title.matches("Load")) {
				System.out.println("loaded");
			}else if(title.matches("save")) {
				
			}
			
		}
	
}
