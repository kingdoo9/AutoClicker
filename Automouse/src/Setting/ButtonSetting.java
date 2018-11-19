package Setting;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import Constants.Constant;

public class ButtonSetting extends JButton{
	private static final long serialVersionUID = 1L;

	//��ư ����
	public ButtonSetting(String title, String Commend, int x, int y, int width, int height) { 
		super(title); //������
		this.setActionCommand(Commend); //������� ����
		this.setFont(new Font(title,Font.BOLD,Constant.setting.getNumber())); //�۾�ũ�� ����
		this.setBounds(x, y, width, height); //��ġ ���� x, y������ ��ŭ width, height ũ�⸦ ����
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY)); //�׵θ� ���� ��,��,��,�� �β� 1��  ȸ������
		this.setBackground(Color.LIGHT_GRAY); // ��� ����
	}
}
