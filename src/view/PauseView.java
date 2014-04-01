package view;

import controller.PauseController;

//Specific implementations of a pause view must implement this interface

public interface PauseView extends View {
	public void setDelegate(PauseController c);
	public void disableSaveFunction();
}
