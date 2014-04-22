
/*
 * Author: Ben Hambrook
 * Date: 15/4/14
 * Purpose: Row validator a type of sudoku validator used by sudoku model to validate a
 * 			possible value in all rows
 */

package model;

import java.util.ArrayList;

public class RowValidator extends SudokuValidator {
	
	private int row;
	
	public RowValidator(SudokuValidator next, ArrayList<SudokuCell> cells, int row){
		super(next, cells);
		this.row = row;
	}
	
	public boolean validate(SudokuCell cell){
		//Validate for completion
		for(int c = 0; c < cells.size(); c++){
			if(cells.get(c).getRow() == cell.getRow() && cells.get(c) != cell){
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
		for(int c = 0; c < cells.size(); c++){
			if(cells.get(c).getRow() == row){
				toValidate.add(cells.get(c));
			}
		}
		
		if(validateValues(value)){
			System.out.println("Row validator valid");
			//Continue to next
			if(next != null){
				return next.validate(value);
			} else {
				return true;
			}
		}
		System.out.println("Row validator failed");
		return false;
	}

}
