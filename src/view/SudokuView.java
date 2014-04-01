package view;

import controller.SudokuController;

//Specific implementations of a sudoku view (game view) must implement this interface

public abstract interface SudokuView extends View {
	public void setTimerText(String time);
	public void setGridValue(int index, int value, boolean editable);
	public void setDelegate(SudokuController c);
}

