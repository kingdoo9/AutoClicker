package Setting;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class PanelSetting extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public PanelSetting(int x, int y, int width, int height, Color color) {
		this.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.gray)); //패널 테두리 설정 두께2씩 회색으로
		this.setBounds(x, y, width, height); // 위치 설정
		this.setLayout(null); // 레이아웃 설정
		this.setBackground(color); // 배경화면 설정
		this.setFocusable(false);// 포커스를 잡지 않도록 설정.
	}


}
