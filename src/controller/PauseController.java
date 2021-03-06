
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: Controller for pause view types handling action events
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sudoku.ApplicationDelegate;
import view.PauseView;

public class PauseController extends Controller implements ActionListener {
	
	private PauseView view;
	
	public PauseController(PauseView view){
		super(view);
		this.view = view;
		this.view.setDelegate(this);
		this.view.draw();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Process event from view
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
}
