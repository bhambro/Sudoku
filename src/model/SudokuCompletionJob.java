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
