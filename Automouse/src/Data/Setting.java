package Data;

import Setting.DataSetting;

public class Setting extends DataSetting{
	private static final long serialVersionUID = 1L;
	
	private char[] element = {'F','L','P'}; //F = ��Ʈ������, L = ���, P = ���� ����Ʈ
	
	public Setting() {
		this.setKind(element);
		this.setName("Setting");
		this.setNumber(15); //��Ʈ ũ�Ⱑ ��
		this.setEmouseX(1); //��� ������ �� 1 = ���� , 2 = �ѱ���
	}

}
