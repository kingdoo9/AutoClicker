package Main;

import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;


import Panels.FramePanel;


public class Main {
	public static void main(String[] args) throws AWTException, InterruptedException {
		new FramePanel();
	}
}