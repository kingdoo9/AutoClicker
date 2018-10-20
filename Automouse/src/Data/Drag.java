package Data;

import Setting.DataSetting;

public class Drag extends DataSetting {
	private char[] element = {'S','E','N','R'};

	public Drag() {
		this.setKind(element);
		this.setName("Drag");
	}
	
}
