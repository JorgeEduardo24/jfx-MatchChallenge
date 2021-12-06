package threads;

import javafx.application.Platform;
import model.Bar;
import ui.MathChallengeGUI;

public class BarThread extends Thread{
	private Bar b;
	private MathChallengeGUI pBarGUI;
	private int time;
	
	public BarThread(Bar bar, MathChallengeGUI pBar, int t) {
		b = bar;
		pBarGUI = pBar;
		time = t;
	}
	
	public void run() {
		while (b.isActive()) {
			b.advance();
			Platform.runLater(new Thread() {
				public void run() {
					pBarGUI.updateBarQ1();
				}
			});
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
