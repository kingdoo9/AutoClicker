package Panels;

import java.awt.Color;

import Constants.Constant;
import Events.PlayEvent;
import Setting.NomalLabel;
import Setting.PanelSetting;

public class PlayCountPanel extends PanelSetting {
	private static final long serialVersionUID = 1L;
	private int Runtimes, RepeatCount;
	
	public PlayCountPanel(int x, int y, int width, int height, Color color) { //F5Ű�� ���� ���ۉ����� ��� ���ư��� ���� �������.
		super(x, y, width, height, color);

	}

	public void View(PlayEvent play) {
		this.removeAll();
		if(Constant.FrameWidth > 300 && Constant.Frameheight > 300)
			this.setBounds(Constant.PreferSize(500, 385, Constant.LeftWidth),Constant.PreferSize(465, 10, Constant.LeftHeight),Constant.PreferSize(500, 105, Constant.LeftWidth),Constant.PreferSize(465, 40, Constant.LeftHeight));
		else this.setBounds(10,10,Constant.PreferSize(500, 450, Constant.LeftWidth),80);
		
		if(play.isAlive()) {
			Runtimes = play.getRuntimes(); // ���α׷��� �������̶�� ��� ���ư������� ��ȯ
			RepeatCount = play.getRepeatN(); // ���α׷��� �������̶�� ��� ���ư��� �ϴ����� ��ȯ
		}else {
			Runtimes = 0; //���α׷��� ������¶�� 0�� ���
			RepeatCount = 0;
		}
		this.add(new NomalLabel("P : " + Integer.toString(Runtimes) + " / " + Integer.toString(RepeatCount) , Constant.PreferSize(105, 10, this.getWidth()),Constant.PreferSize(40, 10, this.getHeight()),Constant.PreferSize(105, 100, this.getWidth()),Constant.PreferSize(40, 20, this.getHeight())));

		this.repaint();
		
	}

}
