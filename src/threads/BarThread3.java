package threads;

import javafx.application.Platform;
import model.Bar;
import ui.MathChallengeGUI;

public class BarThread3 extends Thread{
	private Bar b;
	private MathChallengeGUI pBarGUI;
	private int time;
	
	public BarThread3(Bar bar, MathChallengeGUI pBar, int t) {
		b = bar;
		pBarGUI = pBar;
		time = t;
	}
	
	public void run() {
		while (b.isActive()) {
			b.advance();
			Platform.runLater(new Thread() {
				public void run() {
					pBarGUI.updateBarQ3();
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
