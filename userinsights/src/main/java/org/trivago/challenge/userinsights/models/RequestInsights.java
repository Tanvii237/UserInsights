package org.trivago.challenge.userinsights.models;

import org.trivago.challenge.userinsights.models.Insights.INSIGHT_TYPE;

public class RequestInsights {

	private String userId;
	private INSIGHT_TYPE insightType;
	private Integer jobId;
	private Integer topNHotels = new Integer(3);
	private Integer topKAmenities = new Integer(3);;
	
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public INSIGHT_TYPE getInsightType() {
		return insightType;
	}
	public void setInsightType(INSIGHT_TYPE insightType) {
		this.insightType = insightType;
	}
	public Integer getTopNHotels() {
		return topNHotels;
	}
	public void setTopNHotels(Integer topNHotels) {
		this.topNHotels = topNHotels;
	}
	public Integer getTopKAmenities() {
		return topKAmenities;
	}
	public void setTopKAmenities(Integer topKAmenities) {
		this.topKAmenities = topKAmenities;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
