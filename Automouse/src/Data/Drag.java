package Data;

import Setting.DataSetting;

public class Drag extends DataSetting {
	private static final long serialVersionUID = 1L;
	
	private char[] element = {'S','E','N','R'};

	public Drag() {
		this.setKind(element);
		this.setName("Drag");
	}
	
}
