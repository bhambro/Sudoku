package model;

import java.io.Serializable;
import controller.SudokuController;

public class SudokuGameModel extends BoardGameModel implements Serializable {
	
	private static final long serialVersionUID = 7203962626099057604L;
	private SudokuBoard board;
	protected SudokuController controller; //Controller is the delegate
	private SerializableTimer sudokuTimer;
	private GameTimerTask timerTask;
	private int level;
	
	public SudokuGameModel(SudokuController controller, String playerName){
		super(playerName);
		this.controller = controller;
		board = new SudokuBoard();
	}
	
	public SudokuGameModel(){
		
	}
	
	
	public void createBoard(int level){
		this.level = level;
		jobScheduler.schedueJob(new SudokuCreatorJob(board, this));
	}
	
	public void jobDidComplete(Job j){
		
		if(j.getClass() == SudokuCreatorJob.class){
			//Board was created
			System.out.println("Job was creator job");
			
			//Send the cell values to the view
			controller.loadViewWithData();
			
			//Start the timer
			sudokuTimer = new SerializableTimer();
			timerTask = new GameTimerTask(this);
			sudokuTimer.schedule(timerTask, 1000, 1000);
			
			
		} else if(j.getClass() == SudokuCompletionJob.class){
			System.out.println("Job was completion job");
			SudokuCompletionJob job = (SudokuCompletionJob) j;
			if(job.getSuccess()){
				System.out.println("Success is true");
				//Stop Timer
				pause();
				controller.gameCompleted(timerTask.composeTimeString(timerTask.getSeconds()));
			} else {
				System.out.println("Success is false");
			}
		}
		
		System.out.println("Job did complete");
	}
	
	public void getGameCompletion(){
		System.out.println("Checking if board is built");
		if(board.isBuilt()){
			System.out.println("Scheduling completion job");
			if(jobScheduler == null){
				jobScheduler = new JobScheduler();
			}
			jobScheduler.schedueJob(new SudokuCompletionJob(this, board));
		}
	}
	
	public void setController(SudokuController controller){
		this.controller = controller;
	}
	
	public void pause(){
		System.out.println("Timer Canceled");
		sudokuTimer.cancel();
		sudokuTimer = null;
	}
	
	public void resume(){
		System.out.println("Resuming Timer");
		timerTask = new GameTimerTask(this, timerTask.getSeconds());
		sudokuTimer = new SerializableTimer();
		sudokuTimer.schedule(timerTask, 1000, 1000);
	}
	
	public SudokuBoard getBoard(){
		return board;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setCellValue(int index, int value){
		board.updateCellValue(index, value);
	}
	
	public String getGameTime(){
		return timerTask.composeTimeString(timerTask.getSeconds());
	}

}
