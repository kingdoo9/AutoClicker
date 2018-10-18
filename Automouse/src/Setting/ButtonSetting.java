package Setting;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ButtonSetting extends JButton{
	private static final long serialVersionUID = 1L;

	public ButtonSetting(String title, int x, int y, int width, int height) {
		super(title);
		this.setFont(new Font(title,Font.BOLD,15));
		this.setBounds(x, y, width, height);
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
		this.setBackground(Color.LIGHT_GRAY);
	}
}
