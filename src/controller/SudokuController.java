
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: Controller for sudoku view types interacting with the sudoku game model
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import sudoku.ApplicationDelegate;
import view.SudokuTextBox;
import view.SudokuView;

import model.SudokuCell;
import model.SudokuGameModel;

public class SudokuController extends Controller implements ActionListener, Serializable {
	
	private static final long serialVersionUID = 4636304156861532347L;
	private SudokuGameModel model;
	private SudokuView view;
	
	public SudokuController(SudokuView view, int level, String playerName){
		super(view);
		//New game
		this.view = view;
		this.view.setDelegate(this);
		
		model = new SudokuGameModel(this, playerName);
		model.createBoard(level);
	}
	
	public SudokuController(SudokuView view, SudokuGameModel savedModel, String playerName){
		super(view);
		//Start game from existing saved game model
		this.view = view;
		this.view.setDelegate(this);
		model = savedModel;
		//Connections with the saved model re-linked
		model.setController(this);
		model.setPlayerName(playerName);
		
		//Prevent cell-update events from firing
		model.getBoard().setBuilt(false);
		loadViewWithData();
		//Allow cell-update events
		model.getBoard().setBuilt(true);
		model.resume();
	}
	
	public SudokuController(){
		//Empty constructor for de-serialization process
		super(null);
	}
	
	public void loadViewWithData(){
		ArrayList<SudokuCell> cells = model.getBoard().getCells();
		for(int c = 0; c < cells.size(); c++){
			SudokuCell tCell = cells.get(c);
			view.setGridValue(c, tCell.getValue(), tCell.getEditable());
		}
		//Call the view to draw its contents to the output (dependant on view type)
		view.draw();
	}
	
	public void gameTimerDidUpdate(String time){
		view.setTimerText(time);
	}
	
	public void gameCompleted(String time){
		view.showMessage("Puzzle completed in " + time);
		ApplicationDelegate.getInstance().showMainMenu();
	}
	
	public SudokuGameModel getModel(){
		return model;
	}
	
	public void pauseGame(){
		model.pause();
		view.setVisible(false);
	}
	
	public void resumeGame(){
		model.resume();
		view.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Process events from the view
		switch(e.getActionCommand()){
		case "cellUpdated":
			//Reguardless of the type of view (GUI or CLI) everything uses events
			//Update cell always has a source of SudokuTextBox
			SudokuTextBox src = (SudokuTextBox) e.getSource();
			
			int val;
			try{
				val = Integer.parseInt(src.getText());
			} catch(Exception ex){
				val = 0;
			}
			
			if(val < 1 || val > 9){
				//Invalid sudoku value (not between 1 and 9)
				view.setGridValue(src.getIndex(), 0, true);
				break;
			}
			
			model.setCellValue(src.getIndex(), val);
			model.getGameCompletion();
			break;
			
		case "pause":
			pauseGame();
			ApplicationDelegate.getInstance().showPauseMenu();
			break;
		}
	}

}
