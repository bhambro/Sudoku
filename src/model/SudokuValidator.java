
/*
 * Author: Ben Hambrook
 * Date: 15/4/14
 * Purpose: Abstract validator serving as a general type for all specific validators
 */

package model;

import java.util.ArrayList;

public abstract class SudokuValidator {
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
