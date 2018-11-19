package Setting;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import Constants.Constant;

public class ButtonSetting extends JButton{
	private static final long serialVersionUID = 1L;

	//버튼 설정
	public ButtonSetting(String title, String Commend, int x, int y, int width, int height) { 
		super(title); //제목설정
		this.setActionCommand(Commend); //명령제목 설정
		this.setFont(new Font(title,Font.BOLD,Constant.setting.getNumber())); //글씨크기 설정
		this.setBounds(x, y, width, height); //위치 설정 x, y떨어진 만큼 width, height 크기를 가짐
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY)); //테두리 설정 위,왼,아,오 두께 1씩  회색으로
		this.setBackground(Color.LIGHT_GRAY); // 배경 설정
	}
}
