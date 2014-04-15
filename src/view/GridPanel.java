
/*
 * Author: Ben Hambrook
 * Date: 15/4/14
 * Purpose: Custom JPanel to draw the grid structure on the GUI
 * 			sudoku view
 */

package view;

import java.awt.Graphics;

import javax.swing.*;

public class GridPanel extends JPanel {
	
	private static final long serialVersionUID = 8708668360184364276L;

	public void paint(Graphics g){
		
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
