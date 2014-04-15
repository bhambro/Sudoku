
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: Timer task to track the duration of a game session
 */

package model;

import java.io.Serializable;
import java.util.TimerTask;

public class GameTimerTask extends TimerTask implements Serializable {
	
	private static final long serialVersionUID = 4337908188199392701L;
	//Delegate to recieve a 'tick' event every second from this class
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
		
		return minsS + ":" + secsS;
	}
	
	public int getSeconds(){
		return seconds;
	}

}
