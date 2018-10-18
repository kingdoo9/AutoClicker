package Events;

import java.awt.MouseInfo;

import javax.swing.event.MouseInputListener;

public class MouseEvent implements MouseInputListener{
		private int mouseX;
		private int mouseY;
		private Thread mousePoint= new mousePoint();
		public MouseEvent() {
			mousePoint.start();
		}
		
		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseMoved(java.awt.event.MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseDragged(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public int MouseGetX() {
		
			return mouseX;
		}
		public int MouseGetY() {
			
			return mouseY;
		}
		
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
