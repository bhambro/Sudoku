package model;

interface JobCompletion {
	public void jobDidComplete(Job j);
}

public abstract class BoardGameModel implements JobCompletion {
	
	protected JobScheduler jobScheduler;
	protected Board board;
	private String playerName;
	
	public BoardGameModel(String playerName){
		//Create job schedule and board
		this.playerName = playerName;
		jobScheduler = new JobScheduler();
	}
	
	public BoardGameModel(){
		
	}
	
	public void createBoard(int level){
		//Add a new job to scheduler to create board puzzle
		//This is dependant on the implementation of board game
	}
	
	public void jobDidComplete(Job j){
		//Process job completion
	}
	
	public String getPlayerName(){
		return playerName;
	}
	
	public void setPlayerName(String n){
		playerName = n;
	}

}
