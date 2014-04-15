
/*
 * Author: Ben Hambrook
 * Date: 15/4/14
 * Purpose: Abstract controller for all controllers to inherit from
 */

package controller;

import view.View;

public abstract class Controller {
	
	private View view;
	
	public Controller(View v){
		view = v;
	}
	
	public Controller(){
		//Empty constructor required for de-serialization of child classes
	}
	
	public void hideView(){
		view.destroy();
	}
	
}
