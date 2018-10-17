package Events;

import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.basic.BasicTableUI.MouseInputHandler;

import Data.Click;
import Panels.RightSettingPanel;
import Setting.DataSetting;
import Setting.PanelSetting;

public class MouseEvent implements MouseInputListener{
	private static final long serialVersionUID = 1L;
		private int mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
		private int mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
		private int ClickX=0, ClickY= 0;
		private PanelSetting PS;

		
	
		public MouseEvent(PanelSetting ps) {
			// TODO Auto-generated constructor stub
			this.PS = ps;
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
		public int getClickX() {
			return ClickX;
		}public int getClickY() {
			return ClickY;
		}
		

		
	
}
