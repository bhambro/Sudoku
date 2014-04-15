
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: Specific implementation of generic job class to handle the actions
 * 			required to check if a game is complete or not on a seperate thread
 */

package model;

public class SudokuCompletionJob extends SudokuJob {
	
	private SudokuBoard board;
	private boolean success;

	public SudokuCompletionJob(SudokuGameModel delegate, SudokuBoard board) {
		super(delegate);
		this.board = board;
	}
	
	public void run(){
		//Check if the board is complete
		success = board.isComplete();
		
		//On completion call job completion
		delegate.jobDidComplete(this);
	}
	
	public boolean getSuccess(){
		return success;
	}
}
