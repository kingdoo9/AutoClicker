package Data;

import Setting.DataSetting;

public class ColorS extends DataSetting {
	private char[] element = {'M','C'};

	public ColorS() {
		this.setKind(element);
		this.setName("Color Start");
	}
	
}
