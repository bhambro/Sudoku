
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: Controller for any menu view types to interact with the menu model
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MenuModel;

import sudoku.ApplicationDelegate;
import view.MenuView;

public class MenuController extends Controller implements ActionListener {
	
	private MenuView view;
	private MenuModel model;
	
	public MenuController(MenuView menuView){
		super(menuView);
		model = new MenuModel(this);
		view = menuView;
		view.setDelegate(this);
		view.draw();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Process actions sent from the view
		switch(e.getActionCommand()){
		case "newGameEvent":
			if(view.getPlayerName().equals("")){
				view.showMessage("Please enter your name");
			} else {
				ApplicationDelegate.getInstance().newGame(view.getPlayerName(), view.getLevel());
			}
			break;
		case "loadGameEvent":
			if(view.isFileSelected()){
				ApplicationDelegate.getInstance().loadGame(view.getSelectedFileName() + ".ser");
			}
			break;
		}
	}
	
	public String[] getSavedGames(){
		//Fetch a list of the save game files from the menu model
		return model.getSavedGames();
	}
}
