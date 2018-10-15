package Setting;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import Events.ButtonListener;
import Panels.RightSettingPanel;

public class ButtonSetting extends JButton{
	private static final long serialVersionUID = 1L;

	public ButtonSetting(String title, int x, int y, int width, int height, PanelSetting PS) {
		super(title);
		ButtonListener BL = new ButtonListener(title, PS);
		this.setFont(new Font(title,Font.BOLD,15));
		this.setBounds(x, y, width, height);
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
		this.setBackground(Color.LIGHT_GRAY);
		this.addActionListener(BL);
	}
}
