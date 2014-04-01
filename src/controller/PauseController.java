package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sudoku.ApplicationDelegate;
import view.PauseView;

public class PauseController implements ActionListener {
	
	private PauseView view;
	
	public PauseController(PauseView view){
		this.view = view;
		this.view.setDelegate(this);
		this.view.draw();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "resume":
			ApplicationDelegate.getInstance().resumeGame();
			break;
		case "save":
			ApplicationDelegate.getInstance().saveGame();
			view.showMessage("Game Saved");
			view.disableSaveFunction();
			break;
		case "menu":
			ApplicationDelegate.getInstance().showMainMenu();
			break;
		case "exit":
			System.exit(0);
			break;
		}
	}
	
	public void hideView(){
		view.destroy();
	}

}
