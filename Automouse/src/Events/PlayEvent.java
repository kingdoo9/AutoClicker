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
	}
	
	public int getRuntimes() {return Runtimes;}
	
	@Override
	public void run() {
		for(Runtimes=1; Runtimes<=repeatN; Runtimes++) {
			try {
				for(int j=0; j<Constant.data.size(); j++) {
					DataSetting data = Constant.data.elementAt(j);
					switch(data.getName()) {
					
					case "Click":
						if(data.getRGB().equals(new Color(255,255,255)) || StackColor.peek().equals(data.getRGB())) {
							for(int i=0; i<data.getNumber();i++) {	
								bot.mouseMove(data.getSmouseX(), data.getSmouseY());
								bot.mousePress(InputEvent.BUTTON1_MASK);
								bot.mouseRelease(InputEvent.BUTTON1_MASK);
								Thread.sleep(1000/data.getRepeat());
							}
						}

						break;
					case "Drag":
						if(data.getRGB().equals(new Color(255,255,255)) || StackColor.peek().equals(data.getRGB())) {
							for(int i=0; i<data.getNumber();i++) {	
								bot.mouseMove(data.getSmouseX(), data.getSmouseY());
								bot.mousePress(InputEvent.BUTTON1_MASK);
								bot.mouseMove(data.getEmouseX(), data.getEmouseY());
								bot.mouseRelease(InputEvent.BUTTON1_MASK);
								Thread.sleep(1000/data.getRepeat());
							}
						}

						break;
					case "Delay":
						if(data.getRGB().equals(new Color(255,255,255)) || StackColor.peek().equals(data.getRGB())) {
							Thread.sleep(data.getDelay());
						}
						break;
					case "Color Start":
						bot.mouseMove(data.getSmouseX(), data.getSmouseY());
						while(data.isHoldon()) {
							Thread.sleep(100);
							if(data.getRGB().equals(bot.getPixelColor(data.getSmouseX(), data.getSmouseY())))
								break;
						}
						if(data.getRGB().equals(bot.getPixelColor(data.getSmouseX(), data.getSmouseY()))) {
							ColorCount++;
							if(ColorCount == data.getNumber()) {
								StackColor.add(data.getRGB());
								ColorCount = 0;
							}
						}
						break;
					case "Color End":
						StackColor.pop();
						break;
					}
				}
			}catch(Exception e) {}
		}
	}
}
