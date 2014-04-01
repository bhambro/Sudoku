package view;

import java.awt.Graphics;

import javax.swing.*;

//Custom jPanel to draw the grid structure on the GUI Sudoku View

public class GridPanel extends JPanel {
	
	public void paint(Graphics g){
		//g.drawRect(32, 26, 90, 87);
		
		int height = 87;
		int width = 92;
		
		for(int col = 0; col < 3; col++){
			for(int row = 0; row < 3; row++){
				int x = (width * col) + 32;
				int y = (height * row) + 26;
				g.drawRect(x, y, width, height);
			}
		}
	}

}
