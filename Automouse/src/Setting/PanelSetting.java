package Setting;

import java.awt.Color;
import java.awt.Component;
import java.awt.MouseInfo;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Data.Click;
import Events.ButtonListener;
import Events.MouseEvent;

public abstract class PanelSetting extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public PanelSetting(int x, int y, int width, int height, Color color) {
		this.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.gray));
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setBackground(color);
	}

	public abstract void view(DataSetting data);

}
