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
	private int Runtimes=1; // ���� ��� ���� �ִ����� ǥ��
	private int repeatN=1;
	
	public PlayEvent(int repeat) throws AWTException {
		bot = new Robot(); //���콺�� ���� Ŭ���� ������ ģ��.
		repeatN = repeat; // ����ڰ� ������ Ƚ��
		StackColor.removeAllElements();
		StackColor.add(new Color(255,255,255));
	}
	
	public int getRuntimes() {return Runtimes;}
	
	@Override
	public void run() {
		//����ڰ� ������ Ƚ����ŭ �ݺ� ���
		for(Runtimes=1; Runtimes<=repeatN; Runtimes++) {
			try {
				for(int j=0; j<Constant.data.size(); j++) {
					//�����Ϳ� ����ִ� �͵��� �ϳ��� ����
					DataSetting data = Constant.data.elementAt(j);
					switch(data.getName()) {
					
					//������ �̸��� Click�̸�
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
						
					//������ �̸��� Drag�̸�
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
						
					//������ �̸��� Delay�̸�
					case "Delay":
						if(StackColor.peek().equals(data.getRGB())) {
							Thread.sleep(data.getDelay());
						}
						break;
						
					//������ �̸��� Color Start�̸�
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
					
					//������ �̸��� Color End�̸�
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
