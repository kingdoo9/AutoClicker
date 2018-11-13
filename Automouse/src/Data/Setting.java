package Data;

import Setting.DataSetting;

public class Setting extends DataSetting{
	private static final long serialVersionUID = 1L;
	
	private char[] element = {'F','L','P'}; //F = 폰트사이즈, N = 언어, R = 시작 포인트
	
	public Setting() {
		this.setKind(element);
		this.setName("Setting");
	}

}
