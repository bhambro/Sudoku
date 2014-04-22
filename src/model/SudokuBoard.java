
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: Sudoku board implementation of generic board to contain all sudoku cells and
 * 			manage the creation of a valid sudoku puzzle
 */

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class SudokuBoard extends Board implements Serializable {
	
	private static final long serialVersionUID = 2000218201634998573L;
	private ArrayList<SudokuCell> cells;
	private boolean built;
	
	public SudokuBoard(){
		cells = new ArrayList<SudokuCell>();
	}
	
	public void constructBoard(int level){
		//Sudoku puzzle alogarithm inspired by a VB.NET implementation: 
		//http://www.codeproject.com/Articles/23206/Sudoku-Algorithm-Generates-a-Valid-Sudoku-in
		
		//Empty existing cells
		cells.clear();
		
		for(int col = 0; col < 9; col++){
			for(int row = 0; row < 9; row++){
				cells.add(new SudokuCell(row, col, getRegion(col, row)));
			}
		}
		
		int cellCounter = 0;
		while(cellCounter < 81){
			SudokuCell thisCell = cells.get(cellCounter);
			if(!thisCell.allTriesComplete()){
				//Not all tries complete
				int possibleValue = thisCell.generateRandFromAvail();
				//Perform conflict checking to validate possibleValue
				RegionValidator regValidator = new RegionValidator(null, cells, thisCell.getRegion());
				ColumnValidator colValidator = new ColumnValidator(regValidator, cells, thisCell.getColumn());
				RowValidator rowValidator = new RowValidator(colValidator, cells, thisCell.getRow());
				
				if(rowValidator.validate(possibleValue)){
					//Valid - insert into cell value
					thisCell.setValue(possibleValue);
					thisCell.setHiddenValue(possibleValue);
					//Remove value from available list in the cell
					thisCell.removeFromAvail(possibleValue);
					cellCounter += 1;
				} else {
					//Conflict was found - possible not valid
					thisCell.removeFromAvail(possibleValue);
					continue;
				}
			} else {
				//No values to try in the available list
				//Back track - re create attempts for cell and move back one cell
				thisCell.generateAttempts();
				cellCounter = cellCounter -1;
				cells.get(cellCounter).setValue(0);
				cells.get(cellCounter).setHiddenValue(0);
			}
		}
		
		
		//Value hiding pased on level
		int toHide = level * 5;
		Random randomGenerator = new Random();
		
		for(int i = 1; i < toHide; i++){
			while(true){
				int randNum = randomGenerator.nextInt(80);
				if(cells.get(randNum).getValue() != 0){
					cells.get(randNum).setValue(0);
					cells.get(randNum).setEditable(true);
					break;
				}
			}
		}
		built = true;
	}
	
	private int getRegion(int col, int row){
		//Use chain of responsibility breaking into regions - 3 rows and 3 columns per region
		RegionSelector groupC = new RegionSelector(9, null);
		RegionSelector groupB = new RegionSelector(6, groupC);
		RegionSelector groupA = new RegionSelector(3, groupB);
		return groupA.getRegion(col, row);
	}
	
	public boolean isComplete(){
		for(int c = 0; c < cells.size(); c++){
			SudokuCell thisCell = cells.get(c);
			if(thisCell.getValue() == 0){
				return false;
			}
			
			RegionValidator regionValidator = new RegionValidator(null, cells, thisCell.getRegion());
			ColumnValidator columnValidator = new ColumnValidator(regionValidator, cells, thisCell.getColumn());
			RowValidator rValidator = new RowValidator(columnValidator, cells, thisCell.getRow());
			
			if(!rValidator.validate(thisCell)){
				return false;
			}
			
		}
		return true;
	}
	
	public void updateCellValue(int cellIndex, int value){
		cells.get(cellIndex).setValue(value);
	}
	
	public int getCellValue(int cellIndex){
		return cells.get(cellIndex).getValue();
	}
	
	public ArrayList<SudokuCell> getCells(){
		return cells;
	}
	
	public boolean isBuilt(){
		return built;
	}
	
	public void setBuilt(boolean flag){
		built = flag;
	}
}
