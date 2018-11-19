package Setting;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Constants.Constant;

public abstract class PanelSetting extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public PanelSetting(int x, int y, int width, int height, Color color) {
		this.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.gray)); //�г� �׵θ� ���� �β�2�� ȸ������
		this.setBounds(x, y, width, height); // ��ġ ����
		this.setLayout(null); // ���̾ƿ� ����
		this.setBackground(color); // ���ȭ�� ����
		this.setFocusable(false);// ��Ŀ���� ���� �ʵ��� ����.
		this.setFont(new Font("Font1",Font.BOLD,Constant.setting.getNumber()));
	}


}
