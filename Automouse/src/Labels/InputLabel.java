package Labels;

import java.awt.Color;

import javax.swing.BorderFactory;

import Setting.LabelSetting;

public class InputLabel extends LabelSetting { //오른쪽 페이지에서 클릭수등을 표시하기 위해 만든 Label 설정 class
	private static final long serialVersionUID = 1L;

	public InputLabel(String title, int x, int y, int width, int height) {
		super(title, x, y, width, height); //대부분 설정은 상위 class인 LabelSetting에 들어있다.
		// TODO Auto-generated constructor stub
		
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray)); //테두리 크기 1, 테두리색은 회색으로 설정
		this.setBackground(Color.white); // 배경화면은 흰색으로 설정
	}

}
