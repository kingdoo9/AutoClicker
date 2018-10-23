package Data;

import Setting.DataSetting;

public class Delay extends DataSetting {
	private static final long serialVersionUID = 1L;
	
	private char[] element = {'D'};

	public Delay() {
		this.setKind(element);
		this.setName("Delay");
	}
	
}
