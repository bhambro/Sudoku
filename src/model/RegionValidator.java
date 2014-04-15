
/*
 * Author: Ben Hambrook
 * Date: 15/4/14
 * Purpose: Region validator a type of sudoku validator used by the sudoku board to validate
 * 			a possible value in regions
 */

package model;

import java.util.ArrayList;

public class RegionValidator extends SudokuValidator {
	
	private int region;
	
	public RegionValidator(SudokuValidator next, ArrayList<SudokuCell> cells, int region){
		super(next, cells);
		this.region = region;
	}
	
	public boolean validate(int value){
		for(int c = 0; c < cells.size(); c++){
			if(cells.get(c).getRegion() == region){
				toValidate.add(cells.get(c));
			}
		}
		
		if(validateValues(value)){
			//Continue to next validator
			if(next != null){
				return next.validate(value);
			} else {
				return true;
			}
		}
		return false;
	}

}
