package Data;

import Setting.DataSetting;

public class Click extends DataSetting{
	private static final long serialVersionUID = 1L;
	private char[] element = {'M','N','R'};
	
	public Click() {
		this.setKind(element);
		this.setName("Click");
	}

	
}
