package view;

import controller.MenuController;

//Specific implementations of a menu view must implement this interface

public interface MenuView extends View {
	public void setDelegate(MenuController c);
	public String getPlayerName();
	public int getLevel();
	public String getSelectedFileName();
	public boolean isFileSelected();
}

