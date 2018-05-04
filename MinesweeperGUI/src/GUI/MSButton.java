package GUI;

import javax.swing.JButton;

public class MSButton extends JButton {
	private static final long serialVersionUID = 1L;
	boolean hasBomb;
	String numBombs;
	
	public MSButton (boolean bomb) {
		super();
		this.hasBomb = bomb;
		numBombs = "B";
	}
	
	public boolean getBomb () {
		return this.hasBomb;
	}
	
	public void setBomb (boolean arg) {
		this.hasBomb = arg;
	}
	
	public String getNumBombs() {
		return this.numBombs;
	}
	
	public void setNumBombs(String arg) {
		this.numBombs = arg;
	}
}