package Data;

import Setting.DataSetting;

public class Delay extends DataSetting { //��κ� �������� ���������� DataSetting.java Ŭ������ ����ִ�.
	
	private static final long serialVersionUID = 1L;
	private char[] element = {'D'}; // D = ��� �ð�

	public Delay() {
		this.setKind(element);
		this.setName("Delay");
	}
	
}
