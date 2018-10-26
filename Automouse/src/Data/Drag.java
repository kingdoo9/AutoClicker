package Data;

import Setting.DataSetting;

public class Drag extends DataSetting { //대부분 설정들은 상위설정인 DataSetting.java 클래스에 들어있다.
	
	private static final long serialVersionUID = 1L;
	private char[] element = {'M','E','N','R'}; //M = 마우스1좌표, E = 마우스2좌표, N = 클릭 수, R = 초당 반복횟수

	public Drag() {
		this.setKind(element);
		this.setName("Drag");
	}
	
}
