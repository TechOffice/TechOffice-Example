package com.ittechoffice.jobsearch.base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.ittechoffice.jobsearch.model.Job;
import com.ittechoffice.jobsearch.utils.WebClientUtils;

public abstract class BaseJobPage {
	protected String url;
	protected WebClient webClient;
	protected HtmlPage page;
	protected List<Job> jobList;
	protected Date lastUpdated;
	protected String lastUpdatedDateFormatStr = "dd/mm/yyyy";
	protected SimpleDateFormat lastUpdatedDateFormat;
	
	public BaseJobPage(String url){
		this.url = url;
		lastUpdatedDateFormat = new SimpleDateFormat(lastUpdatedDateFormatStr);
	    jobList = new ArrayList<Job>();
	}
	
	public BaseJobPage(String url, String lastUpdatedDateFormatStr){
		this.url = url;
		this.lastUpdatedDateFormatStr = lastUpdatedDateFormatStr;
		lastUpdatedDateFormat = new SimpleDateFormat(lastUpdatedDateFormatStr);
	    jobList = new ArrayList<Job>();
	}
	
	public final void process() throws Exception{
	    webClient = WebClientUtils.getWebClient();
		page = webClient.getPage(url);
		processLastUpdated();
		processJobs();
		webClient.close();
	}

	protected abstract void processLastUpdated() throws Exception;
	
	protected abstract void processJobs() throws Exception;
	
	public List<Job> getJobList(){
		return jobList;
	}
	
}
