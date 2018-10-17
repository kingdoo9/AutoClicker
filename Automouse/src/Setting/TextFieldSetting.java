package Setting;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TextFieldSetting extends JTextField{
	private static final long serialVersionUID = 1L;

	public TextFieldSetting(String title, int x, int y, int width, int height) {
		super(title);
		this.setFont(new Font(title,Font.BOLD,15));
		this.setBounds(x, y, width, height);
	}
}
