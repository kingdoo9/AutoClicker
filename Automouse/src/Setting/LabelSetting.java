package Setting;

import java.awt.Font;
import javax.swing.JLabel;

public abstract class LabelSetting extends JLabel{
	private static final long serialVersionUID = 1L;

	public LabelSetting(String title, int x, int y, int width, int height) {
		super(title);
		this.setFont(new Font(title,Font.BOLD,15));
		this.setBounds(x, y, width, height);
	}
}
