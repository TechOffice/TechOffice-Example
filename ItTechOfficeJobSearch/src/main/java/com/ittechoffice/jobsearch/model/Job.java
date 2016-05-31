package com.ittechoffice.jobsearch.model;

import java.util.Date;

public class Job {
	private String institionName;
	private String url;
	private String position;
	private Date deadLine;
	public String getInstitionName() {
		return institionName;
	}
	public void setInstitionName(String institionName) {
		this.institionName = institionName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	
	
}
