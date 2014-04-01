package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class SudokuCell extends BoardCell implements Serializable {
	
	private static final long serialVersionUID = -2081270802115634541L;
	private int region;
	private int hiddenValue;
	private boolean editable;
	private ArrayList<Integer> attempts;
	
	public SudokuCell(int row, int column, int region){
		super(row, column);
		this.region = region;
		this.editable = false;
		attempts = new ArrayList<Integer>();
		generateAttempts();
	}
	
	public void generateAttempts(){
		//Populate possible numbers this cell could hold
		attempts.clear();
		for(int x = 0; x <= 9; x++){
			attempts.add(x);
		}
	}
	
	public boolean allTriesComplete(){
		if(attempts.size() > 0){
			return false;
		} else {
			return true;
		}
	}
	
	public int generateRandFromAvail(){
		int max = attempts.size();
		if(max == 1){
			return attempts.get(0);
		}
		
		Random rGen = new Random();
		int randNum = rGen.nextInt(max -1);
		return attempts.get(randNum);
	}
	
	public void removeFromAvail(int val){
		for(int rm = 0; rm < attempts.size(); rm++){
			if(attempts.get(rm) == val){
				attempts.remove(rm);
			}
		}
	}

	public int getRegion() {
		return region;
	}

	public void setRegion(int region) {
		this.region = region;
	}

	public int getHiddenValue() {
		return hiddenValue;
	}

	public void setHiddenValue(int hiddenValue) {
		this.hiddenValue = hiddenValue;
	}
	
	public void setEditable(boolean flag){
		this.editable = flag;
	}
	
	public boolean getEditable(){
		return this.editable;
	}	
}
