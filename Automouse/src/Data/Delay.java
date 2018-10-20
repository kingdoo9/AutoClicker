package Data;

import Setting.DataSetting;

public class Delay extends DataSetting {
	private char[] element = {'D'};

	public Delay() {
		this.setKind(element);
		this.setName("Delay");
	}
	
}
