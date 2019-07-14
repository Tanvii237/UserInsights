package org.trivago.challenge.userinsights.processors;

import org.trivago.challenge.userinsights.models.Job;

public class InsightWorker extends Thread {

	public void run() {
		System.out.println("Worker running");
			if(!JobManager.jobQueue.isEmpty()) {
				System.out.println("BEFORE:     " +JobManager.jobQueue.toString());
				processJob(JobManager.jobQueue.poll());
				System.out.println("AFTER:     " +JobManager.jobQueue.toString());
				
			}
			System.out.println("Worker Finished");
	}
	
	
	public void processJob(Job job) {
		System.out.println("IN PROCESS JOB");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
