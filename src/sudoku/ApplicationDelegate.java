
/*
 * Author: Ben Hambrook
 * Date: 15/4/14
 * Purpose: Application delegate - main controller or navigator for transitioning
 * 			between views
 */

package sudoku;

import java.util.Calendar;

import model.Serializer;
import model.SudokuGameModel;
import view.CliMenuView;
import view.CliPauseView;
import view.CliSudokuView;
import view.GuiMenuView;
import view.GuiPauseView;
import view.GuiSudokuView;
import controller.MenuController;
import controller.PauseController;
import controller.SudokuController;

public class ApplicationDelegate {
	
private static ApplicationDelegate self;
	
	private MenuController menuController;
	private SudokuController sudokuController;
	private PauseController pauseController;
	
	public enum ViewType {
		CLI_VIEWTYPE, GUI_VIEWTYPE
	}
	
	private ViewType viewType;
	
	private ApplicationDelegate(){
		//Default to GUI view type
		viewType = ViewType.GUI_VIEWTYPE;
	}
	
	public static ApplicationDelegate getInstance(){
		if(self == null){
			self = new ApplicationDelegate();
		}
		return self;
	}
	
	public void setViewType(ViewType vt){
		viewType = vt;
	}
	
	public void showMainMenu(){
		
		//Hide the pause controller view if exists
		if(pauseController != null){
			pauseController.hideView();
			pauseController = null;
		}
		
		if(sudokuController != null){
			sudokuController.hideView();
			sudokuController = null;
		}
		
		//Create and inject relevant view depending on type
		//Add custom views here
		if(viewType == ViewType.GUI_VIEWTYPE){
			menuController = new MenuController(new GuiMenuView());
		} else {
			menuController = new MenuController(new CliMenuView());
		}
	}
	
	public void newGame(String playerName, int level){
		//Create controller object injecting correct view
		menuController.hideView();
		if(viewType == ViewType.GUI_VIEWTYPE){
			sudokuController = new SudokuController(new GuiSudokuView(), level, playerName);
		} else {
			sudokuController = new SudokuController(new CliSudokuView(), level, playerName);
		}
	}
	
	public void loadGame(String fileName){
		//Call on serializer object to restore a saved gameModel instance
		menuController.hideView();
		SudokuGameModel sudokuModel = (SudokuGameModel) Serializer.getInstance().unSerialize(fileName);
		int startPos = fileName.indexOf("/");
		int splitPos = fileName.indexOf("-");
		String name = fileName.substring(startPos +1, splitPos);
		
		//Create and inject correct view, view independant of view used in previous game session
		if(viewType == ViewType.GUI_VIEWTYPE){
			sudokuController = new SudokuController(new GuiSudokuView(), sudokuModel, name);
		} else {
			sudokuController = new SudokuController(new CliSudokuView(), sudokuModel, name);
		}
	}
	
	public void saveGame(){
		//Call on serializer object to save the current gameModel instance
		//Naming convension: player name + date
		//Limitation: only one game session can be saved for one player name on one day
		
		String date = Calendar.getInstance().get(Calendar.DATE) + "-" + Calendar.getInstance().get(Calendar.MONTH) + "-" + Calendar.getInstance().get(Calendar.YEAR);
		String fileName = "saveGames/" + sudokuController.getModel().getPlayerName() + "-" + date + ".ser";
		Serializer.getInstance().serialize(sudokuController.getModel(), fileName);
	}
	
	public void resumeGame(){
		//Hide pauseView and call method to resume the game instance
		if(pauseController != null){
			pauseController.hideView();
		}
		sudokuController.resumeGame();
	}
	
	public void showPauseMenu(){
		//Create pause controller instance injecting correct view
		if(viewType == ViewType.GUI_VIEWTYPE){
			pauseController = new PauseController(new GuiPauseView());
		} else {
			pauseController = new PauseController(new CliPauseView());
		}
	}
}
