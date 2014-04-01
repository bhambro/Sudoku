package model;

import java.util.ArrayList;

public class SudokuValidator {
	protected SudokuValidator next;
	protected ArrayList<SudokuCell> cells;
	protected ArrayList<SudokuCell> toValidate;
	
	public SudokuValidator(SudokuValidator next, ArrayList<SudokuCell> cells){
		this.next = next;
		this.cells = cells;
		toValidate = new ArrayList<SudokuCell>();
	}
	
	protected boolean validateValues(int value){
		for(int i = 0; i < toValidate.size(); i++){
			if(toValidate.get(i).getHiddenValue() == value){
				return false;
			}
		}
		return true;
	}
	
	public boolean validate(int value){
		if(next == null){
			return true;
		}
		return false;
	}
}
