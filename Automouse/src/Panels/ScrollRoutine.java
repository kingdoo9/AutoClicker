package Panels;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ScrollRoutine extends JScrollPane {
	private static final long serialVersionUID = 1L;
	
	public ScrollRoutine() {
		this.setBounds(10,60,250,350);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		JScrollBar Vbar = getVerticalScrollBar();
		Vbar.addAdjustmentListener(new AdjustmentListener(){
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// TODO Auto-generated method stub
				getViewport().revalidate();
				getViewport().repaint();
			}
		});
	}

}
