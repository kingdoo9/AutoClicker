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
	private int repeatN=1;
	
	public PlayEvent(int repeat) throws AWTException {
		bot = new Robot(); //마우스의 실제 클릭을 눌러줄 친구.
		repeatN = repeat; // 사용자가 지정한 횟수
		StackColor.removeAllElements();
		StackColor.add(new Color(255,255,255));
	}
	
	public int getRuntimes() {return Runtimes;}
	
	@Override
	public void run() {
		//사용자가 지정한 횟수만큼 반복 재생
		for(Runtimes=1; Runtimes<=repeatN; Runtimes++) {
			try {
				for(int j=0; j<Constant.data.size(); j++) {
					//데이터에 들어있는 것들을 하나씩 꺼냄
					DataSetting data = Constant.data.elementAt(j);
					switch(data.getName()) {
					
					//데이터 이름이 Click이면
					case "Click":
						if(StackColor.peek().equals(data.getRGB())) {
							for(int i=0; i<data.getNumber();i++) {	
								bot.mouseMove(data.getSmouseX(), data.getSmouseY());
								for(int x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY(); x != data.getSmouseX() && y != data.getSmouseY(); x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY()) {
									int a, b;
									a = x-data.getSmouseX();
									b = y-data.getSmouseY();
									bot.mouseMove(x-a, y-b);
								}
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
								for(int x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY(); x != data.getSmouseX() && y != data.getSmouseY(); x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY()) {
									int a, b;
									a = x-data.getSmouseX();
									b = y-data.getSmouseY();
									bot.mouseMove(x-a, y-b);
								}
								bot.mousePress(InputEvent.BUTTON1_MASK);
								Thread.sleep(100);
								bot.mouseMove(data.getEmouseX(), data.getEmouseY());
								for(int x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY(); x != data.getEmouseX() && y != data.getEmouseY(); x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY()) {
									int a, b;
									a = x-data.getEmouseX();
									b = y-data.getEmouseY();
									bot.mouseMove(x-a, y-b);
								}
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
						bot.mouseMove(data.getSmouseX(), data.getSmouseY());
						for(int x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY(); x != data.getSmouseX() && y != data.getSmouseY(); x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY()) {
							int a, b;
							a = x-data.getSmouseX();
							b = y-data.getSmouseY();
							bot.mouseMove(x-a, y-b);
						}
						while(data.isHoldon()) {
							Thread.sleep(100);
							bot.mouseMove(data.getSmouseX(), data.getSmouseY());
							for(int x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY(); x != data.getSmouseX() && y != data.getSmouseY(); x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY()) {
								int a, b;
								a = x-data.getSmouseX();
								b = y-data.getSmouseY();
								bot.mouseMove(x-a, y-b);
							}
							if(data.getRGB().equals(bot.getPixelColor(data.getSmouseX(), data.getSmouseY())))
								break;
						}
						if(data.getRGB().equals(bot.getPixelColor(data.getSmouseX(), data.getSmouseY()))) {
							ColorCount++;
							if(ColorCount == data.getNumber()) {
								StackColor.add(data.getRGB());
								System.out.println("comming1");
								ColorCount = 0;
							}
						}
						if(data.isChangedColor()) {
							while(true) {
								Thread.sleep(100);
								bot.mouseMove(data.getSmouseX(), data.getSmouseY());
								for(int x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY(); x != data.getSmouseX() && y != data.getSmouseY(); x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY()) {
									int a, b;
									a = x-data.getSmouseX();
									b = y-data.getSmouseY();
									bot.mouseMove(x-a, y-b);
								}
								System.out.println("comming2");
								if(!data.getRGB().equals(bot.getPixelColor(data.getSmouseX(), data.getSmouseY())))break;
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
				Thread.sleep(100);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
