
/*
 * Author: Ben Hambrook
 * Date: 15/4/14
 * Purpose: Specific implementation of generic job class to handle the task of generating
 * 			the sudoku board on a seperate thread
 */

package model;

public class SudokuCreatorJob extends SudokuJob {
	
	private SudokuBoard sudokuBoard;
	
	public SudokuCreatorJob(SudokuBoard sudokuBoard, SudokuGameModel delegate){
		super(delegate);
		this.sudokuBoard = sudokuBoard;
		System.out.println("Job Created");
	}
	
	public void run(){
		//Perform operations on the sudoku board to create the puzzle
		sudokuBoard.constructBoard(delegate.getLevel());
		
		//On completion call job completion
		delegate.jobDidComplete(this);
	}

}
