package model;

public abstract class SudokuJob extends Job {
	
	protected SudokuGameModel delegate;

	public SudokuJob(SudokuGameModel delegate) {
		super(delegate);
		this.delegate = delegate;
	}

}
