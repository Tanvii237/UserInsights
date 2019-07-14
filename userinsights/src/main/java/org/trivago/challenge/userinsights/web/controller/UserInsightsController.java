package org.trivago.challenge.userinsights.web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.trivago.challenge.userinsights.models.*;
import org.trivago.challenge.userinsights.models.Insights.INSIGHT_TYPE;
import org.trivago.challenge.userinsights.processors.JobManager;


@RestController
public class UserInsightsController {
	
	@Autowired
	JobManager manager;
	
	// Create a new job with the userID and request Insight type
	@RequestMapping(value = "/insights", method = RequestMethod.POST)
	public ResponseEntity<RequestInsights> requestInsightAndInitiateJob(@RequestBody RequestInsights req, 	UriComponentsBuilder ucBuilder) {
		System.out.println("Requesting Insight");
		
		// Initiate Job
		Integer referenceJobId = manager.initiateJob(req.getUserId(), req.getInsightType(), req.getTopNHotels(), req.getTopKAmenities());
		req.setJobId(referenceJobId); 
		
		// send job id in the response
		return new ResponseEntity<RequestInsights>(req, HttpStatus.CREATED);
	}
	
	// Send all Jobs
	@RequestMapping(value = "/insights", method = RequestMethod.GET)
	public ResponseEntity<String> getInsight(){
		return new ResponseEntity<String>("All jobs", HttpStatus.OK);
	}
	
	// Send job with id
	@RequestMapping(value = "/insights/{jobId}", method = RequestMethod.GET)
	public ResponseEntity<Job> getInsight(@PathVariable int jobId){
		Job ins = new Job("asd", INSIGHT_TYPE.INSIGHT_HOTEL, 7, 7);
		return new ResponseEntity<Job>(ins, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/healthz", method = RequestMethod.GET)
	public ResponseEntity<String> healthcheck() {
		return new ResponseEntity<String>("API Healthy!", HttpStatus.OK);
	}
}
