package Setting;

import java.awt.Font;
import javax.swing.JLabel;

import Constants.Constant;

public abstract class LabelSetting extends JLabel{
	private static final long serialVersionUID = 1L;

	public LabelSetting(String title, int x, int y, int width, int height) {
		super(title); //���� ������ ǥ��
		this.setFont(new Font(title,Font.BOLD,Constant.setting.getNumber())); //�� �۲� ����
		this.setBounds(x, y, width, height); // �� ��ġ ����
	}
}
