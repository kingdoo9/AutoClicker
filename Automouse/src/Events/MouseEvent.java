package Events;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;

import javax.swing.event.MouseInputListener;

public class MouseEvent implements MouseInputListener{
		private int mouseX;
		private int mouseY;
		private Thread mousePoint= new mousePoint(); //마우스 움직이는 좌표를 항상 받아들이는 Thread
		
		public MouseEvent() {
			mousePoint.start(); //항시 작동하게 설정.
		}
		
		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {}
		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {}
		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {}
		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {}
		@Override
		public void mouseMoved(java.awt.event.MouseEvent arg0) {}
		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {}
		@Override
		public void mouseDragged(java.awt.event.MouseEvent e) {}
		
		public int MouseGetX() {return mouseX;} // 마우스 X좌표 반환
		public int MouseGetY() {return mouseY;} // 마우스 Y좌표 반환
		
		//마우스 위치에 있는 픽셀 컬러를 가져오는 함수.
		public Color getColor() { 
			try {
				return new Robot().getPixelColor(mouseX, mouseY);		
			} catch (AWTException e) {}
			return null;
		}
		//항시 마우스 좌표를 가져오는 class. (Runnable로 인해 항시 실행중이다.)
		class mousePoint extends Thread implements Runnable{
			
			@Override
			public void run(){ 
				while (true){ 
			        try{ 
			        	
			        	mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
			    		mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
			    		Thread.sleep(120); 
			        }catch (Exception ex){ } 
				} 
			}
		}

		
	
}
