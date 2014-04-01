package model;

import java.io.Serializable;
import java.util.TimerTask;

public class GameTimerTask extends TimerTask implements Serializable {
	
	//Timer task to track the time of game session while being serializable
	
	private static final long serialVersionUID = 4337908188199392701L;
	private SudokuGameModel delegate;
	private int seconds;
	
	public GameTimerTask(SudokuGameModel model){
		delegate = model;
	}
	
	public GameTimerTask(SudokuGameModel model, int seconds){
		delegate = model;
		this.seconds = seconds;
	}
	
	public void run(){
		seconds += 1;
		delegate.controller.gameTimerDidUpdate(composeTimeString(seconds));
	}
	
	public String composeTimeString(int s){
		int secs = s;
		int mins = 0;
		if(s > 59){
			mins = s / 60;
			secs = s % 60;
		}
		
		String secsS = secs + "";
		String minsS = mins + "";
		
		
		
		if(secs < 10){
			secsS = "0" + secs;
		}
		
		if (mins < 10){
			minsS = "0" + mins;
		}
		
		String returnable = minsS + ":" + secsS;
		
		return returnable;
	}
	
	public int getSeconds(){
		return seconds;
	}

}
