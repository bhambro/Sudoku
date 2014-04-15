
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: Abstract sudoku job class adding ability to store sudoku
 * 			game model as the delegate
 */

package model;

public abstract class SudokuJob extends Job {
	
	protected SudokuGameModel delegate;

	public SudokuJob(SudokuGameModel delegate) {
		super(delegate);
		this.delegate = delegate;
	}

}
