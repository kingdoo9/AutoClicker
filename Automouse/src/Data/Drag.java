package Data;

import Setting.DataSetting;

public class Drag extends DataSetting { //��κ� �������� ���������� DataSetting.java Ŭ������ ����ִ�.
	
	private static final long serialVersionUID = 1L;
	private char[] element = {'M','E','N','R'}; //M = ���콺1��ǥ, E = ���콺2��ǥ, N = Ŭ�� ��, R = �ʴ� �ݺ�Ƚ��

	public Drag() {
		this.setKind(element);
		this.setName("Drag");
	}
	
}
