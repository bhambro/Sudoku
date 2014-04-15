
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: Abstract board containing many abstract board cells
 */

package model;

import java.util.ArrayList;

public abstract class Board {
	
	//Cells not used in abstract class
	@SuppressWarnings("unused")
	private ArrayList<BoardCell> cells;
	
	public Board(){
		cells = new ArrayList<BoardCell>();
	}
	
	//Method definition must be implemented in inherited classes
	public abstract void constructBoard(int level);

}
