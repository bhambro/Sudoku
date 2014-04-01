package model;

public abstract class Job extends Thread {
	
	//Abstract job with notion of calling its delegate when
	//job is complete (where delegate implements jobCompletion)
	
	protected BoardGameModel delegate;
	
	public Job(BoardGameModel delegate){
		this.delegate = delegate;
	}
	
	public void run(){
		//Perform job operation
		
		//Call jobCompletion
		delegate.jobDidComplete(this);
	}
}