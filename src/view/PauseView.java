
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: All implementations of a pause view (CLI and GUI) must implement this interface
 */

package view;

import controller.PauseController;

public interface PauseView extends View {
	public void setDelegate(PauseController c);
	public void disableSaveFunction();
}
