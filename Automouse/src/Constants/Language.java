package Constants;

public class Language {

	 public static final String Language[] = {"Save", "Load", "New", "Start", "Stop", "Language", "mouse",
			 								"next", "prev", "Click Setting", "Drag Setting", "Deley Setting",
			 								"Color Start", "Color End", "Delete", "Up", "Down", "Color :",
			 								"Input File name \n If \\  /  :  \"  *  ?  .  <  >  |  \n you type, The file can't save.",
			 								"Load File name.", "(Press '1' Key)", "(Press '2' Key)", "(Press '3' Key)",
			 								"set-up", " Count :", " repeat :", "Delay time :", "( per 1 secend )", "( 1000 = 1s )",
			 								"Start Position :", "End Position :", "Really Create new File?",
			 								"Which language would you choose?",	"Hold-On Setting", "Color Changed",
			 								"( Hold-On Routines, When the Color comes out. )","( If Color Changed, Then Continue. )",
			 								"Input Number", "Go there", "general settings", "advanced settings",
			 								"How many times will you repeat?", "Input type doesn't correct.",
			 								

			 								
			 								 "�����ϱ�", "�ҷ�����", "���θ����", "����", "����", "���", "�� ��ǥ",
			 								 "����", "����", "Ŭ�� ����", "�巡�� ����", "��� ����",
			 								 "�� ���� ����", "�� ���� ����", "�����ϱ�", "����", "�Ʒ���", "�� ���� :",
			 								 "����� ���ϸ��� �Է����ּ���. \n \\ /  :  \"  *  ?  .  <  >  |  \n �Է½� ������ �������� ���� �� �ֽ��ϴ�.",
			 								 "�ҷ��� ���ϸ��� �Է����ּ���.", "('1'�� Ű�� �����ּ���)", "('2'�� Ű�� �����ּ���)", "('3'�� Ű�� �����ּ���)",
			 								 "����", " Ƚ�� :", " �ݺ� :", "��� �ð� :", "( �ʴ� ��ȸ �ݺ� )", "( 1000 = 1�� )",
			 								 "���� ��ǥ :","���� ��ǥ :", "������ ���θ���ðڽ��ϱ�?",
			 								 "� �� �����Ͻðڽ��ϱ�?", "���� ����" , "�� ���� ����",
			 								 "( ������ ���� ���ö����� ��� ����մϴ�. )", "( ���� ����Ǹ� �׶� �ٽ� �����մϴ�. )",
				 							 "���ڸ� �Է��� �ּ���.", "��ǥ�� ����", "�Ϲ� ����", "��� ����",
				 							 "��� �ݺ��Ͻðڽ��ϱ�?", "�Է� ������ �ùٸ��� �ʽ��ϴ�."
			 								 
			 								 };
	
	 public static enum Lan {Save, Load, New, Start, Stop, Language, mouse,
		 					next, prev, click, Drag, Delay,
		 					ColorS, ColorE, Delete, Up, Down, Color,
		 					MsgSFile,
		 					MsgLFile, press1, press2, press3,
		 					setup, count, repeat, delay, MsgRepeat, MsgDelay,
		 					SPosition, EPosition , MsgNFile,
		 					MsgLanguage, HSetting, CSetting,
		 					MsgHSetting, MsgCSetting,
		 					InputNumber, gothere, general_settings , advanced_settings,
		 					MsgStart, MsgError
	 						};
	 
	 public static int LSelect = 0;
	 public static String[] Choose = {"English","�ѱ���"};

}
