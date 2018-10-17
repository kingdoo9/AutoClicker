package Main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;


public class Main {
	public static void main(String[] args) throws AWTException, InterruptedException {

		new Panels.FramePanel();
		
		Robot bot = new Robot();
//		bot.mouseMove(50, 50); // 5분의 4정도 만 움직인다.
//		bot.mousePress(InputEvent.BUTTON1_MASK);
//		bot.mouseMove(500, 500);
//		bot.mouseRelease(InputEvent.BUTTON1_MASK);
//		bot.mousePress(InputEvent.BUTTON1_MASK);
//		bot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
}

//해야할것 반복횟수 적기
//