package Setting;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class PanelSetting extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public PanelSetting(int x, int y, int width, int height, Color color) {
		this.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.gray)); //�г� �׵θ� ���� �β�2�� ȸ������
		this.setBounds(x, y, width, height); // ��ġ ����
		this.setLayout(null); // ���̾ƿ� ����
		this.setBackground(color); // ���ȭ�� ����
		this.setFocusable(false);// ��Ŀ���� ���� �ʵ��� ����.
	}


}
