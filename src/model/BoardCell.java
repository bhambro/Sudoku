package model;

import java.io.Serializable;

public abstract class BoardCell implements Serializable {
	
	private static final long serialVersionUID = -5461702209611653324L;
	private int value;
	private int row;
	private int column;
	
	public BoardCell(int row, int column){
		this.row = row;
		this.column = column;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
}
