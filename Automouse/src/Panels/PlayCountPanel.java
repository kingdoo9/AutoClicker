package Panels;

import java.awt.Color;

import Constants.Language;
import Events.PlayEvent;
import Labels.NomalLabel;
import Setting.PanelSetting;

public class PlayCountPanel extends PanelSetting {
	private static final long serialVersionUID = 1L;
	private int Runtimes, RepeatCount;
	
	public PlayCountPanel(int x, int y, int width, int height, Color color) { //F5Ű�� ���� ���ۉ����� ��� ���ư��� ���� �������.
		super(x, y, width, height, color);

	}

	public void View(PlayEvent play) {
		this.removeAll();
		if(play.isAlive()) {
			Runtimes = play.getRuntimes(); // ���α׷��� �������̶�� ��� ���ư������� ��ȯ
			RepeatCount = play.getRepeatN(); // ���α׷��� �������̶�� ��� ���ư��� �ϴ����� ��ȯ
		}else {
			Runtimes = 0; //���α׷��� ������¶�� 0�� ���
			RepeatCount = 0;
		}
		this.add(new NomalLabel("P : " + Integer.toString(Runtimes) + " / " + Integer.toString(RepeatCount) , 10, 10, 100, 20));

		this.repaint();
		
	}

}
