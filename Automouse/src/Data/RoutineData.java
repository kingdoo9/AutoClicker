package Data;

import java.io.Serializable;
import java.util.Vector;

import Setting.DataSetting;

public class RoutineData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Vector<DataSetting> obj;
	
	public void setObj(Vector<DataSetting> obj) {
		this.obj = obj;
	}
	public Vector<DataSetting> getObj() {
		return obj;
	}

}
