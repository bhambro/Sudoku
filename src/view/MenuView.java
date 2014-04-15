
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: All MenuView implementations (CLI and GUI) must implement this interface
 */

package view;

import controller.MenuController;

public interface MenuView extends View {
	public void setDelegate(MenuController c);
	public String getPlayerName();
	public int getLevel();
	public String getSelectedFileName();
	public boolean isFileSelected();
}

