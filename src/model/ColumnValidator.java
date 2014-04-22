
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: Column validator of type sudoku validator used to validate all columns in sudoku grid
 */

package model;

import java.util.ArrayList;

public class ColumnValidator extends SudokuValidator {
	private int col;
	
	public ColumnValidator(SudokuValidator next, ArrayList<SudokuCell> cells, int col){
		super(next, cells);
		this.col = col;
	}
	
	public boolean validate(SudokuCell cell){
		//Validate for completion
		for(int c = 0; c < cells.size(); c++){
			if(cells.get(c).getColumn() == cell.getColumn() && cells.get(c) != cell){
				toValidate.add(cells.get(c));
			}
		}
		
		if(validateValues(cell.getValue())){
			if(next != null){
				return next.validate(cell);
			} else {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean validate(int value){
		//Validate for build
		for(int c = 0; c < cells.size(); c++){
			if(cells.get(c).getColumn() == col){
				toValidate.add(cells.get(c));
			}
		}
		
		if(validateValues(value)){
			System.out.println("Column validator valid");
			if(next != null){
				return next.validate(value);
			} else {
				return true;
			}
		}
		System.out.println("Column validator failed");
		return false;
	}
}
