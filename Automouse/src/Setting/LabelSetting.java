package Setting;

import java.awt.Font;
import javax.swing.JLabel;

public abstract class LabelSetting extends JLabel{
	private static final long serialVersionUID = 1L;

	public LabelSetting(String title, int x, int y, int width, int height) {
		super(title); //라벨의 내용을 표시
		this.setFont(new Font(title,Font.BOLD,15)); //라벨 글꼴 설정
		this.setBounds(x, y, width, height); // 라벨 위치 설정
	}
}
