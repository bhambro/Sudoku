package model;

import java.util.ArrayList;

public class RowValidator extends SudokuValidator {
	
	private int row;
	
	public RowValidator(SudokuValidator next, ArrayList<SudokuCell> cells, int row){
		super(next, cells);
		this.row = row;
	}
	
	public boolean validate(int value){
		for(int c = 0; c < cells.size(); c++){
			if(cells.get(c).getRow() == row){
				toValidate.add(cells.get(c));
			}
		}
		
		if(validateValues(value)){
			//Continue to next
			if(next != null){
				return next.validate(value);
			} else {
				return true;
			}
		}
		return false;
	}

}
