package Data;

import Setting.DataSetting;

public class Setting extends DataSetting{
	private static final long serialVersionUID = 1L;
	
	private char[] element = {'F','L','P'}; //F = ��Ʈ������, N = ���, R = ���� ����Ʈ
	
	public Setting() {
		this.setKind(element);
		this.setName("Setting");
	}

}
