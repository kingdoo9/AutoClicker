package Data;

import Setting.DataSetting;

public class ColorS extends DataSetting {
	private static final long serialVersionUID = 1L;
	
	private char[] element = {'M','N','C','H'};
	public ColorS() {
		this.setKind(element);
		this.setName("Color Start");
	}
	
}
