package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;
import java.lang.String;

import GUI.MSButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MinesweeperWindow {

	public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();

	private MSButton[][] mineField;
	
	int mMines = 100; // number of mines

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MinesweeperWindow window = new MinesweeperWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MinesweeperWindow() {
		initialize();
	}

	private void initialize() {
		/*
		 * Create a frame and call a function to build panels for different layouts
		 */
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		panel.setBounds(10, 0, 368, 361); //39
		panel.setLayout(null);
		panel.setVisible(true);
		frame.getContentPane().add(panel);
		
		setmineField(25,10);
		
	}

	public void setmineField(int buttonSize, int gridSize) {
		mineField = new MSButton[gridSize][gridSize];

		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				mineField[i][j] = new MSButton(true);
				mineField[i][j].setSize(buttonSize, buttonSize);
				mineField[i][j].setLocation(
						(panel.getWidth() - buttonSize * gridSize + buttonSize) / 2 + i * buttonSize,
						j * buttonSize + 40);
				mineField[i][j].setBackground(new Color(238, 238, 238));
				mineField[i][j].setVisible(true);

				mineField[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// The main GUI button feature - the click, to be used here unsparingly
						mineField[i][j].getBomb();
					}
				});


				this.panel.add(mineField[i][j]);
			}
		}
		
		this.setMines(gridSize);
		this.setHiddenText(gridSize);
	}

	public int mineAt(int i, int j) {
		int mHeight = 0;
		int mWidth = 0;
		if (j >= 0 && j < mHeight && i >= 0 && i < mWidth) {
			if (mineField[i][j].getBomb() == true) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	public void setMines(int gridSize) {
		Random rand = new Random();
		int mineCount = 0;
		while (mineCount < 30) {
			int randomInteger = (int) (rand.nextInt(gridSize));
			int randomInteger2 = (int) (rand.nextInt(gridSize));
			if (mineField[randomInteger][randomInteger2].getBomb() == false) {
				mineField[randomInteger][randomInteger2].setBomb(true);
				mineCount++;
				
			}
		}
	}
	
	public void setHiddenText(int gridSize) {
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				if (mineField[i][j].getBomb() == true) {
					mineField[i][j].setText("B");
				} else {
					int mines = 0;
					mines += mineAt(i - 1, j - 1);
					mines += mineAt(i	 , j - 1);
					mines += mineAt(i + 1, j - 1);
					mines += mineAt(i - 1, j    );
					mines += mineAt(i + 1, j    );
					mines += mineAt(i - 1, j + 1);
					mines += mineAt(i    , j + 1);
					mines += mineAt(i + 1, j + 1);
					
					mineField[i][j].setText(Integer.toString(mines));
				}
			}
		}
	}

}
