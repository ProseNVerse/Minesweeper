package minesweeperPackage;

import javax.swing.JButton;

public class MSButton extends JButton {
	private static final long serialVersionUID = 1L;
	boolean hasBomb;
	
	public MSButton (boolean bomb) {
		super();
		this.hasBomb = bomb;
	}
	
	
	
}
