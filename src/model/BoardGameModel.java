
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: Abstract board game model to be used as a base to develop specific board games
 */

package model;

interface JobCompletion {
	public void jobDidComplete(Job j);
}

public abstract class BoardGameModel implements JobCompletion {
	
	//Assumed that all board games will require jobs to be run, a board and a player name
	
	protected JobScheduler jobScheduler;
	protected Board board;
	private String playerName;
	
	public BoardGameModel(String playerName){
		//Create job schedule and board
		this.playerName = playerName;
		jobScheduler = new JobScheduler();
	}
	
	public BoardGameModel(){
		//Empty constructor for un-serialization purposes
	}
	
	//Abstract method definitions for implementation in child classes
	public abstract void createBoard(int level);
	public abstract void jobDidComplete(Job j);
	
	public String getPlayerName(){
		return playerName;
	}
	
	public void setPlayerName(String n){
		playerName = n;
	}

}
