package com.testjsonwebservice.pss;

public class Psirt {
	
	private String headline; 
	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getAlertVersion() {
		return alertVersion;
	}

	public void setAlertVersion(String alertVersion) {
		this.alertVersion = alertVersion;
	}

	public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}

	public String getFirstPublished() {
		return firstPublished;
	}

	public void setFirstPublished(String firstPublished) {
		this.firstPublished = firstPublished;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getImpact() {
		return impact;
	}

	public void setImpact(String impact) {
		this.impact = impact;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String alertVersion; 
	private String alertId; 
	private String firstPublished; 
	private String lastUpdated; 
	private String impact; 
	private String url; 

	public Psirt() {
		
	}
	
	
}
