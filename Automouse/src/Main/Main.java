package Main;

import java.awt.AWTException;
import java.awt.Robot;

import Panels.FramePanel;


public class Main {
	public static void main(String[] args) throws AWTException, InterruptedException {

		new FramePanel();
		Robot bot = new Robot();
//		bot.mouseMove(50, 50); // 5���� 4���� �� �����δ�.
//		bot.mousePress(InputEvent.BUTTON1_MASK);
//		bot.mouseMove(500, 500);
//		bot.mouseRelease(InputEvent.BUTTON1_MASK);
//		bot.mousePress(InputEvent.BUTTON1_MASK);
//		bot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
}