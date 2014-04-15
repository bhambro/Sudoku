
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: All implementations of sudoku (game) view must implement this interface
 */

package view;

import controller.SudokuController;

public abstract interface SudokuView extends View {
	public void setTimerText(String time);
	public void setGridValue(int index, int value, boolean editable);
	public void setDelegate(SudokuController c);
}

