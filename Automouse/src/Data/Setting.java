package Data;

import Setting.DataSetting;

public class Setting extends DataSetting{
	private static final long serialVersionUID = 1L;
	
	private char[] element = {'F','L','P'}; //F = 폰트사이즈, L = 언어, P = 시작 포인트
	
	public Setting() {
		this.setKind(element);
		this.setName("Setting");
		this.setNumber(15); //폰트 크기가 됨
		this.setEmouseX(1); //언어 설정이 됨 1 = 영어 , 2 = 한국어
	}

}
