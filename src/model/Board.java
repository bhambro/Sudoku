package model;

import java.util.ArrayList;

public abstract class Board {
	
	//Cells not used in abstract class
	@SuppressWarnings("unused")
	private ArrayList<BoardCell> cells;
	
	public Board(){
		cells = new ArrayList<BoardCell>();
	}
	
	public void constructBoard(){
		
	}

}
