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
			 								

			 								
			 								 "저장하기", "불러오기", "새로만들기", "시작", "정지", "언어", "현 좌표",
			 								 "다음", "이전", "클릭 설정", "드래그 설정", "대기 설정",
			 								 "색 조건 설정", "색 조건 종료", "삭제하기", "위로", "아래로", "색 설정 :",
			 								 "저장시 파일명을 입력해주세요. \n \\ /  :  \"  *  ?  .  <  >  |  \n 입력시 파일이 생성되지 않을 수 있습니다.",
			 								 "불러올 파일명을 입력해주세요.", "('1'번 키를 눌러주세요)", "('2'번 키를 눌러주세요)", "('3'번 키를 눌러주세요)",
			 								 "설정", " 횟수 :", " 반복 :", "대기 시간 :", "( 초당 몇회 반복 )", "( 1000 = 1초 )",
			 								 "시작 좌표 :","종료 좌표 :", "정말로 새로만드시겠습니까?",
			 								 "어떤 언어를 선택하시겠습니까?", "멈춤 설정" , "색 변경 설정",
			 								 "( 설정한 색이 나올때까지 잠시 대기합니다. )", "( 색이 변경되면 그때 다시 진행합니다. )",
				 							 "숫자를 입력해 주세요.", "좌표로 가기", "일반 설정", "고급 설정",
				 							 "몇번 반복하시겠습니까?", "입력 형식이 올바르지 않습니다."
			 								 
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
	 public static String[] Choose = {"English","한국어"};

}
