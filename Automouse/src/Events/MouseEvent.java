package Events;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;

import javax.swing.event.MouseInputListener;

public class MouseEvent implements MouseInputListener{
		private int mouseX;
		private int mouseY;
		private Thread mousePoint= new mousePoint(); //���콺 �����̴� ��ǥ�� �׻� �޾Ƶ��̴� Thread
		
		public MouseEvent() {
			mousePoint.start(); //�׽� �۵��ϰ� ����.
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
		
		public int MouseGetX() {return mouseX;} // ���콺 X��ǥ ��ȯ
		public int MouseGetY() {return mouseY;} // ���콺 Y��ǥ ��ȯ
		
		//���콺 ��ġ�� �ִ� �ȼ� �÷��� �������� �Լ�.
		public Color getColor() { 
			try {
				return new Robot().getPixelColor(mouseX, mouseY);		
			} catch (AWTException e) {}
			return null;
		}
		//�׽� ���콺 ��ǥ�� �������� class. (Runnable�� ���� �׽� �������̴�.)
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
