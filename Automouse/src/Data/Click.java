package Data;

import Setting.DataSetting;

public class Click extends DataSetting{ //��κ� �������� ���������� DataSetting.java Ŭ������ ����ִ�.
	
	private static final long serialVersionUID = 1L;
	private char[] element = {'M','N','R'}; //M = ���콺��ǥ, N = Ŭ�� ��, R = �ʴ� �ݺ�Ƚ��
	
	public Click() {
		this.setKind(element);
		this.setName("Click");
	}

	
}
