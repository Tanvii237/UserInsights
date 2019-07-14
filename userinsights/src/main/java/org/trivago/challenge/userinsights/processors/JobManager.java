package org.trivago.challenge.userinsights.processors;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.omg.CORBA.INITIALIZE;
import org.springframework.stereotype.Service;
import org.trivago.challenge.userinsights.models.Insights.INSIGHT_TYPE;
import org.trivago.challenge.userinsights.models.Job;

@Service("manager")
public class JobManager {
	
	JobManager(){
		initializeData();
	}
	
	public static Map<Integer, Job> hMap = new ConcurrentHashMap<Integer, Job>();
	public static Queue<Job> jobQueue = new ConcurrentLinkedQueue<Job>(); //thread safe queue for job objects 
	
	
	public Integer initiateJob(String requestUserId, INSIGHT_TYPE requestInsightType, Integer topNHotel, Integer topKAmenities) {
		
		// Create a job
		Job insightJob = new Job(requestUserId, requestInsightType, topNHotel, topKAmenities);
		
		// create an entry into map object 
		hMap.put(insightJob.getJobId(), insightJob);
		
		//put the job object in the queue
		jobQueue.add(insightJob);
		
		System.out.println(hMap.toString());
		System.out.println(jobQueue.toString());
		
		// Start an asynchronous job
		InsightWorker worker = new InsightWorker();
		worker.start();
		
		return insightJob.getJobId();
	}
	
	public Job getJob(Integer jobId) {
		Job job = hMap.get(jobId);
		
		return job;
	}
	
	public void initializeData() {
		
	}
}
