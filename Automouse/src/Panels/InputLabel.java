package Panels;

import java.awt.Color;

import javax.swing.BorderFactory;

import Setting.LabelSetting;

public class InputLabel extends LabelSetting {
	private static final long serialVersionUID = 1L;

	public InputLabel(String title, int x, int y, int width, int height) {
		super(title, x, y, width, height);
		// TODO Auto-generated constructor stub
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
		this.setBackground(Color.white);
	}

}
