
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: Implementation of MenuView serving as a command line interface
 */

package view;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.MenuController;

public class CliMenuView implements MenuView {
	
	private MenuController controller;
	private BufferedReader in;
	
	private String playerName;
	private int level;
	private String selectedFileName;
	
	
	public CliMenuView(){
		in = new BufferedReader(new InputStreamReader(System.in));
		level = -1;
	}

	@Override
	public void draw() {
		String response = "";
		while(!response.equals("n") && !response.equals("l")){
			System.out.println("Welcome to Sudoku type [n] to start new game or [l] to load a game");
			try{
				response = in.readLine();
			} catch(IOException e){
				continue;
			}
		}
		
		if(response.equals("n")){
			//New Game
			
			while(playerName == null || playerName.equals("")){
				System.out.println("Please enter your name: ");
				try{
					playerName = in.readLine();
				} catch(IOException e){
					continue;
				}
			}
			
			while(level < 0 || level > 10){
				System.out.println("Select puzzle level (between 1 and 10)");
				try{
					String lvl = in.readLine();
					level = Integer.parseInt(lvl);
				} catch(IOException e){
					continue;
				}
			}
			
			ActionEvent newGameEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "newGameEvent");
			controller.actionPerformed(newGameEvent);
			
		} else {
			//Load Game
			String[] files = controller.getSavedGames();
			int selectedIndex = -1;
			
			while(selectedIndex < 0 && selectedIndex > files.length){
				System.out.println("Saved Games:");
				for(int f = 0; f < files.length; f++){
					System.out.println("[" + f + "] " + files[f]);
				}
				System.out.println("Enter a number to select a file");
				try{
					String fNum = in.readLine();
					selectedIndex = Integer.parseInt(fNum);
				} catch(IOException e){
					continue;
				}
			}
			
			selectedFileName = files[selectedIndex];
			ActionEvent loadGameEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "loadGameEvent");
			controller.actionPerformed(loadGameEvent);
			
		}
	}

	@Override
	public void showMessage(String msg) {
		System.out.println(msg);
	}

	@Override
	public void destroy() {
		//No destroy needed for CLI view type
	}

	@Override
	public void setDelegate(MenuController c) {
		controller = c;
	}

	@Override
	public String getPlayerName() {
		return playerName;
	}

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public String getSelectedFileName() {
		return "saveGames/" + selectedFileName;
	}

	@Override
	public void setVisible(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isFileSelected() {
		// TODO Auto-generated method stub
		return false;
	}

}
