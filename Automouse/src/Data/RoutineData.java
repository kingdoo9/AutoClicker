package Data;

import java.io.Serializable;
import java.util.Vector;

import Setting.DataSetting;

public class RoutineData implements Serializable { //Routine ���� ����ȭ�ϱ� ���� ����ȭ(Serializable)���� class
	private static final long serialVersionUID = 1L;
	
	private Vector<DataSetting> obj; 
	
	//get-set Functions
	public void setObj(Vector<DataSetting> obj) {this.obj = obj;}
	public Vector<DataSetting> getObj() {return obj;}

}
