
/*
 * Author: Ben Hambrook
 * Date: 15/4/14
 * Purpose: Region selector used by sudoku board to select region for a cell
 * 			implemented in a chain of responsibility design pattern
 */

package model;

public class RegionSelector {
	
	private RegionSelector next;
	private int maxVal;
	
	public RegionSelector(int maxVal, RegionSelector next){
		this.maxVal = maxVal;
		this.next = next;
	}
	
	public int getRegion(int col, int row){
		if(col < maxVal){
			switch(row){
			case 0:
			case 1:
			case 2:
				return maxVal -2;
			case 3:
			case 4:
			case 5:
				return maxVal -1;
			case 6:
			case 7:
			case 8:
				return maxVal;
			}
		}
		
		if(next != null){
			return next.getRegion(col, row);
		}
		return -1;
	}

}
