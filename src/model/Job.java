/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: Abstract job for all jobs requiring delegate notification on completion
 */

package model;

public abstract class Job extends Thread {
	
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