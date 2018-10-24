package Data;

import Setting.DataSetting;

public class ColorE extends DataSetting { //대부분 설정들은 상위설정인 DataSetting.java 클래스에 들어있다.
	
	private static final long serialVersionUID = 1L;
	private char[] element = {};

	public ColorE() {
		this.setKind(element);
		this.setName("Color End");
	}
	
}
