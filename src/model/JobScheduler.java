package model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobScheduler {
	
	//private static final long serialVersionUID = -5170209528353902945L;
	private ExecutorService executor;
	
	public JobScheduler(){
		executor = Executors.newSingleThreadExecutor();
	}
	
	public void schedueJob(Job j){
		System.out.println("Job Scheduled");
		executor.execute(j);
	}
	
}
