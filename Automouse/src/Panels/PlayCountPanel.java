package Panels;

import java.awt.Color;

import Constants.Language;
import Events.PlayEvent;
import Labels.NomalLabel;
import Setting.PanelSetting;

public class PlayCountPanel extends PanelSetting {
	private static final long serialVersionUID = 1L;
	private int Runtimes, RepeatCount;
	
	public PlayCountPanel(int x, int y, int width, int height, Color color) { //F5키를 눌러 시작됬을때 몇번 돌아갔는 지를 출력해줌.
		super(x, y, width, height, color);

	}

	public void View(PlayEvent play) {
		this.removeAll();
		if(play.isAlive()) {
			Runtimes = play.getRuntimes(); // 프로그램이 시작중이라면 몇번 돌아갔는지를 반환
			RepeatCount = play.getRepeatN(); // 프로그램이 시작중이라면 몇번 돌아가야 하는지를 반환
		}else {
			Runtimes = 0; //프로그램이 종료상태라면 0을 출력
			RepeatCount = 0;
		}
		this.add(new NomalLabel("P : " + Integer.toString(Runtimes) + " / " + Integer.toString(RepeatCount) , 10, 10, 100, 20));

		this.repaint();
		
	}

}
