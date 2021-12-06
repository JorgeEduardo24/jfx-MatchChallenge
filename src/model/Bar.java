package model;

public class Bar {
	public final static int MAX_LEVEL = 400;
	private int progressLevel;
	private boolean active;
	public Bar() {
		progressLevel = 0;
		active = true;
	}
	
	public int getProgressLevel() {
		return progressLevel;
	}
	
	public void advance() {
		if(progressLevel>=MAX_LEVEL) {
			active = false;
		}else {			
			progressLevel++;
		}
	}
	
	public void setActive(boolean act) {
		active = act;
	}
	
	public boolean isActive() {
		return active;
	}
}
