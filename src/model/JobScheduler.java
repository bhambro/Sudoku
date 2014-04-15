
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: Job scheduler owned by a board model for scheduling jobs on a single thread
 */

package model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobScheduler {
	
	private ExecutorService executor;
	
	public JobScheduler(){
		executor = Executors.newSingleThreadExecutor();
	}
	
	public void schedueJob(Job j){
		System.out.println("Job Scheduled");
		executor.execute(j);
	}
	
}
