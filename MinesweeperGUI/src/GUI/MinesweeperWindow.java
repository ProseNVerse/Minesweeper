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
		
		panel.setBounds(0, 0, 361, 361); //39
		panel.setLayout(null);
		panel.setVisible(true);
		frame.getContentPane().add(panel);
		
		setmineField(25,10);
		
	}



//	public ArrayList<ArrayList<JButton>> getmineField() {
//		return mineField;
//	}



	public void setmineField(int buttonSize, int gridSize) {
		mineField = new MSButton[gridSize][gridSize];
		
		for(int i = 0; i < gridSize; i++) {
			for(int j = 0; j < gridSize; j++) {
				mineField[i][j] = new MSButton(true);
				mineField[i][j].setSize(buttonSize,buttonSize);
				mineField[i][j].setLocation(
						(panel.getWidth() - buttonSize*gridSize + buttonSize)/2 + 
						i*buttonSize,j*buttonSize+40);
				mineField[i][j].setBackground(new Color(238 ,238,238));
				mineField[i][j].setVisible(true);
				this.panel.add(mineField[i][j]);
			}
		}
	}
	
	public int mineAt(int i, int j) {
		int mHeight = 0;
			int mWidth = 0;
		    if(j >= 0 && j < mHeight && i >= 0 && i < mWidth) {
		      return 1;
		    } else {
		      return 0;
		    }
		  }
	
	public char minesNear(int i, int j) {
		int mines = 0;
		// check mines in all directions
		mines += mineAt(i - 1, j - 1);  // NW
		mines += mineAt(i - 1, j);      // N
		mines += mineAt(i - 1, j + 1);  // NE
		mines += mineAt(i, j - 1);      // W
		mines += mineAt(i, j + 1);      // E
		mines += mineAt(i + 1, j - 1);  // SW
		mines += mineAt(i + 1, j);      // S
		mines += mineAt(i + 1, j + 1);  // SE
		   if(mines > 0) {
		      return (char)(mines + 48);
		   		} else {
				    return ' ';
				}
			}
		

public static void mines(MSButton[][] buttons)
{
    Random rand = new Random();
    int mineCount = 0;
    while (mineCount < 30)
    {
        int randomInteger = (int) (rand.nextDouble() * buttons.length);
        int randomInteger2 = (int) (rand.nextDouble() * buttons[0].length);
        if (buttons[randomInteger][randomInteger2].getText().equals("X"))
            continue;
        else
        {
            buttons[randomInteger][randomInteger2].setText("X");
            mineCount++;
        }
    }

}
}
