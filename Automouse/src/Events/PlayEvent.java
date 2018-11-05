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
	private int repeatN=1; // �� ��� ���ƾ� �ϴ��� ǥ��
	private int j; //���� ���° data�� �����ϴ��� ǥ��
	
	public PlayEvent(int repeat) throws AWTException {
		bot = new Robot(); //���콺�� ���� Ŭ���� ������ ģ��.
		repeatN = repeat; // ����ڰ� ������ Ƚ��
		
		StackColor.removeAllElements(); // ���ÿ� �ִ� ������ ����� ��� �÷� �ϳ��� ����.
		StackColor.add(new Color(255,255,255));
		setColor();  //������ �÷������� ��� data�� �ǽ���. 
	}
	
	public void setColor() { //������ �÷������� ��� data�� �ǽ���. 
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
	
	public void checkPoint(int dataX, int dataY) { //�پ��� �ػ󵵸� ȣȯ�����ϰ� ����. ���콺 ��ġ�� �����ʹٸ����� ��Ȯ�� ������ ã�ư�.
		for(int x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY(); x != dataX && y != dataY; x=Constant.mouse.MouseGetX(), y=Constant.mouse.MouseGetY()) {
			int a, b;
			a = x-dataX;
			b = y-dataY;
			bot.mouseMove(x-a, y-b);
		}
	}
	
	@Override
	public void run() {
		//����ڰ� ������ Ƚ����ŭ �ݺ� ���
		for(Runtimes=1; Runtimes<=repeatN; Runtimes++) {
			try {
				for(j=0; j<Constant.data.size(); j++) {
					//�����Ϳ� ����ִ� �͵��� �ϳ��� ����
					DataSetting data = Constant.data.elementAt(j);
					switch(data.getName()) {
					
					//������ �̸��� Click�̸�
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
						
					//������ �̸��� Drag�̸�
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
						
					//������ �̸��� Delay�̸�
					case "Delay":
						if(StackColor.peek().equals(data.getRGB())) {
							Thread.sleep(data.getDelay());
						}
						break;
						
					//������ �̸��� Color Start�̸�
					case "Color Start":
						bot.mouseMove(data.getSmouseX(), data.getSmouseY()); //���콺�� ���ϴ� �ڸ���
						checkPoint(data.getSmouseX(), data.getSmouseY());
						
						while(data.isHoldon()) { //Hold-on ��ư�� ������ �ִ� ���, ���� ���ö����� ���� �����.
							Thread.sleep(100);
							bot.mouseMove(data.getSmouseX(), data.getSmouseY());
							checkPoint(data.getSmouseX(), data.getSmouseY());
							
							if(data.getRGB().equals(bot.getPixelColor(data.getSmouseX(), data.getSmouseY())))
								break;
						}
						
						//��ġ�� ���� ���Դٸ� stack�� ������.
						if(data.getRGB().equals(bot.getPixelColor(data.getSmouseX(), data.getSmouseY()))) {
							ColorCount++;
							if(ColorCount == data.getNumber()) {
								StackColor.add(data.getRGB());
								ColorCount = 0;
							}
							
							//changed-Color ��ư�� ������ �ִ� ���, ���� �ٸ������� �ٲ𶧱��� ���� �����
							if(data.isChangedColor()) {
								while(true) {
									Thread.sleep(100);
									bot.mouseMove(data.getSmouseX(), data.getSmouseY());
									checkPoint(data.getSmouseX(), data.getSmouseY());
									
									if(!data.getRGB().equals(bot.getPixelColor(data.getSmouseX(), data.getSmouseY())))break;
								}
							}
						}else {
							for(; j<Constant.data.size(); j++) { //���� �������� ������Ű�� ���ߴٸ� Color End ���� �̵�
								if(Constant.data.elementAt(j).getName().equals("Color End") && Constant.data.elementAt(j).getRGB().equals(data.getRGB())) break;
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
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
