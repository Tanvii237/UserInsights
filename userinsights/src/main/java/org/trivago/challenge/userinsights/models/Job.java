package org.trivago.challenge.userinsights.models;

import org.trivago.challenge.userinsights.models.Insights.INSIGHT_TYPE;

public class Job {
	
	public static enum JOB_STATUS {
		PENDING,
		PROGRESS,
		SUCCESSFUL,
		FAILED
	}
	
	private static Integer idInitializer = 0;
	
	private final Integer jobId = ++ idInitializer; 

	private JOB_STATUS jobStatus = JOB_STATUS.PENDING; 
	
	private String userId;
	
	private Integer topNHotel;
	
	private Integer topKAmenities;
	
	private INSIGHT_TYPE insightType;

	@SuppressWarnings("unused")
	private Job() {}
	
	public Job(String userId, INSIGHT_TYPE requestInsightType, Integer nHotels, Integer nAmenities){
		this.insightType = requestInsightType;
		this.userId = userId;
		this.topNHotel = nHotels;
		this.topKAmenities = nAmenities;
	}
	
	public Integer getTopNHotel() {
		return topNHotel;
	}

	public void setTopNHotel(Integer topNHotel) {
		this.topNHotel = topNHotel;
	}

	public Integer getTopKAmenities() {
		return topKAmenities;
	}

	public void setTopKAmenities(Integer topKAmenities) {
		this.topKAmenities = topKAmenities;
	}

	public INSIGHT_TYPE getInsightType() {
		return insightType;
	}

	public void setInsightType(INSIGHT_TYPE insightType) {
		this.insightType = insightType;
	}
	
	public JOB_STATUS getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(JOB_STATUS jobStatus) {
		this.jobStatus = jobStatus;
	}

	public Integer getJobId() {
		return jobId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobStatus=" + jobStatus + ", userId=" + userId + ", insightType="
				+ insightType + "]";
	}
	
	
	
	
}
