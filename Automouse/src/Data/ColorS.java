package Data;

import Setting.DataSetting;

public class ColorS extends DataSetting { //��κ� �������� ���������� DataSetting.java Ŭ������ ����ִ�.
	
	private static final long serialVersionUID = 1L;
	private char[] element = {'M','N','C','H'}; //M = ���콺��ǥ, N = Ŭ�� ��, C = �� ����, H = ��� ����
	
	public ColorS() {
		this.setKind(element);
		this.setName("Color Start");
	}
	
}
