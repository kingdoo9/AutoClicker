package Data;

import Setting.DataSetting;

public class ColorS extends DataSetting { //��κ� �������� ���������� DataSetting.java Ŭ������ ����ִ�.
	
	private static final long serialVersionUID = 1L;
	//M = ���콺��ǥ, N = Ŭ�� ��, C = �� ����, H = ��� ����, c = �� �ٲ� ����
	private char[] element = {'M','N','C','H','c'}; 

	
	public ColorS() {
		this.setKind(element);
		this.setName("Color Start");
	}

	
}
