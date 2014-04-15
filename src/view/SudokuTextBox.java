
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: Custom text field element to store a cell index
 */

package view;

import javax.swing.JTextField;

public class SudokuTextBox extends JTextField {
	
	private static final long serialVersionUID = 525700320980249262L;
	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
