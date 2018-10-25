package Data;

import Setting.DataSetting;

public class ColorS extends DataSetting { //대부분 설정들은 상위설정인 DataSetting.java 클래스에 들어있다.
	
	private static final long serialVersionUID = 1L;
	//M = 마우스좌표, N = 클릭 수, C = 색 정보, H = 대기 여부, c = 색 바뀜 여부
	private char[] element = {'M','N','C','H','c'}; 

	
	public ColorS() {
		this.setKind(element);
		this.setName("Color Start");
	}

	
}
