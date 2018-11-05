package Events;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Stack;

import Constants.Constant;
import Setting.DataSetting;

public class PlayEvent extends Thread implements Runnable{
	private Robot bot;
	private Stack<Color> StackColor = new Stack<>();
	private int ColorCount = 0; 
	private int Runtimes=1; // 현재 몇번 돌고 있는지를 표시
	private int repeatN=1; // 총 몇번 돌아야 하는지 표시
	private int j; //현재 몇번째 data를 실행하는지 표시
	
	public PlayEvent(int repeat) throws AWTException {
		bot = new Robot(); //마우스의 실제 클릭을 눌러줄 친구.
		repeatN = repeat; // 사용자가 지정한 횟수
		
		StackColor.removeAllElements(); // 스택에 있는 모든것을 지우고 흰색 컬러 하나를 넣음.
		StackColor.add(new Color(255,255,255));
		setColor();  //시작전 컬러세팅을 모든 data에 실시함. 
	}
	
	public void setColor() { //시작전 컬러세팅을 모든 data에 실시함. 
		for(DataSetting data : Constant.data) {
			if(data.getName().equals("Color Start")) {
				StackColor.add(data.getRGB());
			}
			if(data.getName().equals("Color End")) {
				data.setRGB(StackColor.pop());
			}
			if(!data.getName().equals("Color Start")&&!data.getName().equals("Color End")) {
				data.setRGB(StackColor.peek());
			}
		}
		
	}
	public int getRuntimes() {return Runtimes;}
	public int getRepeatN() {return repeatN;}
	public int getJ() {return j;}
	
	public void checkPoint(int dataX, int dataY) { //다양한 해상도를 호환가능하게 설정. 마우스 위치가 실제와다르더라도 정확한 지점을 찾아감.
		for(int x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY(); x != dataX && y != dataY; x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY()) {
			int a, b;
			a = x-dataX;
			b = y-dataY;
			bot.mouseMove(x-a, y-b);
		}
	}
	
	@Override
	public void run() {
		//사용자가 지정한 횟수만큼 반복 재생
		for(Runtimes=1; Runtimes<=repeatN; Runtimes++) {
			try {
				for(j=0; j<Constant.data.size(); j++) {
					//데이터에 들어있는 것들을 하나씩 꺼냄
					DataSetting data = Constant.data.elementAt(j);
					switch(data.getName()) {
					
					//데이터 이름이 Click이면
					case "Click":
						if(StackColor.peek().equals(data.getRGB())) {
							for(int i=0; i<data.getNumber();i++) {	
								bot.mouseMove(data.getSmouseX(), data.getSmouseY());
								checkPoint(data.getSmouseX(), data.getSmouseY());
								
								bot.mousePress(InputEvent.BUTTON1_MASK);
								bot.mouseRelease(InputEvent.BUTTON1_MASK);
								Thread.sleep(1000/data.getRepeat());
							}
						}
						break;
						
					//데이터 이름이 Drag이면
					case "Drag":
						if(StackColor.peek().equals(data.getRGB())) {
							for(int i=0; i<data.getNumber();i++) {	
								bot.mouseMove(data.getSmouseX(), data.getSmouseY());
								checkPoint(data.getSmouseX(), data.getSmouseY());
								
								bot.mousePress(InputEvent.BUTTON1_MASK);
								
								Thread.sleep(100);
								
								bot.mouseMove(data.getEmouseX(), data.getEmouseY());
								checkPoint(data.getEmouseX(), data.getEmouseY());
								
								bot.mouseRelease(InputEvent.BUTTON1_MASK);
								Thread.sleep(1000/data.getRepeat());
							}
						}
						break;
						
					//데이터 이름이 Delay이면
					case "Delay":
						if(StackColor.peek().equals(data.getRGB())) {
							Thread.sleep(data.getDelay());
						}
						break;
						
					//데이터 이름이 Color Start이면
					case "Color Start":
						bot.mouseMove(data.getSmouseX(), data.getSmouseY()); //마우스를 원하는 자리에
						checkPoint(data.getSmouseX(), data.getSmouseY());
						
						while(data.isHoldon()) { //Hold-on 버튼이 눌러져 있는 경우, 색이 나올때까지 마냥 대기함.
							Thread.sleep(100);
							bot.mouseMove(data.getSmouseX(), data.getSmouseY());
							checkPoint(data.getSmouseX(), data.getSmouseY());
							
							if(data.getRGB().equals(bot.getPixelColor(data.getSmouseX(), data.getSmouseY())))
								break;
						}
						
						//일치한 색이 나왔다면 stack에 저장함.
						if(data.getRGB().equals(bot.getPixelColor(data.getSmouseX(), data.getSmouseY()))) {
							ColorCount++;
							if(ColorCount == data.getNumber()) {
								StackColor.add(data.getRGB());
								ColorCount = 0;
							}
							
							//changed-Color 버튼이 눌러져 있는 경우, 색이 다른색으로 바뀔때까지 마냥 대기함
							if(data.isChangedColor()) {
								while(true) {
									Thread.sleep(100);
									bot.mouseMove(data.getSmouseX(), data.getSmouseY());
									checkPoint(data.getSmouseX(), data.getSmouseY());
									
									if(!data.getRGB().equals(bot.getPixelColor(data.getSmouseX(), data.getSmouseY())))break;
								}
							}
						}else {
							for(; j<Constant.data.size(); j++) { //만약 색조건을 만족시키지 못했다면 Color End 까지 이동
								if(Constant.data.elementAt(j).getName().equals("Color End") && Constant.data.elementAt(j).getRGB().equals(data.getRGB())) break;
							}
						}
						

						break;
					
					//데이터 이름이 Color End이면
					case "Color End":
						if(StackColor.size()>1) {
							StackColor.pop();
						}
						break;
					}
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
