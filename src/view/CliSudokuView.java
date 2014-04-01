package view;

import controller.SudokuController;

//Sudoku (game) view implementation for CLI view (Not Implemented)

public class CliSudokuView implements SudokuView {

	@Override
	public void draw() {
		System.out.println("The CLI Sudoku View has not been developed yet please use the GUI view");
	}

	@Override
	public void showMessage(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTimerText(String time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGridValue(int index, int value, boolean editable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDelegate(SudokuController c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVisible(boolean flag) {
		// TODO Auto-generated method stub
		
	}

}
