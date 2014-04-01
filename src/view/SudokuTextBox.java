package view;

import javax.swing.JTextField;

//Custom text field element to store cell ID's

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
