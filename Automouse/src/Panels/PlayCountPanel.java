package Panels;

import java.awt.Color;

import Constants.Constant;
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
		this.setBounds(Constant.PreferSize(500, 385, Constant.LeftWidth),Constant.PreferSize(465, 10, Constant.LeftHeight),Constant.PreferSize(500, 105, Constant.LeftWidth),Constant.PreferSize(465, 40, Constant.LeftHeight));
		if(play.isAlive()) {
			Runtimes = play.getRuntimes(); // 프로그램이 시작중이라면 몇번 돌아갔는지를 반환
			RepeatCount = play.getRepeatN(); // 프로그램이 시작중이라면 몇번 돌아가야 하는지를 반환
		}else {
			Runtimes = 0; //프로그램이 종료상태라면 0을 출력
			RepeatCount = 0;
		}
		this.add(new NomalLabel("P : " + Integer.toString(Runtimes) + " / " + Integer.toString(RepeatCount) , Constant.PreferSize(105, 10, this.getWidth()),Constant.PreferSize(40, 10, this.getHeight()),Constant.PreferSize(105, 100, this.getWidth()),Constant.PreferSize(40, 20, this.getHeight())));

		this.repaint();
		
	}

}
