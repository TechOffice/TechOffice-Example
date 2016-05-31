package com.ittechoffice.jobsearch.appl;

import java.util.ArrayList;
import java.util.List;

import com.ittechoffice.jobsearch.base.BaseJobPage;
import com.ittechoffice.jobsearch.model.Job;
import com.ittechoffice.jobsearch.webpage.publicorg.HaWebPage;
import com.ittechoffice.jobsearch.webpage.publicorg.HkexWebPage;

public class JobSearchAppl {
	
	private List<BaseJobPage> pageList; 
	private List<Job> jobList;
	
	public JobSearchAppl(){
		pageList = new ArrayList<BaseJobPage>();
		jobList = new ArrayList<Job>();
	}
	
	public void add(BaseJobPage page){
		pageList.add(page);
	}
	
	public void process() throws Exception{
		for (BaseJobPage page:pageList){
			page.process();
			jobList.addAll(page.getJobList());
		}
	}
	
	public List<Job> getJobList(){
		return jobList;
	}
	
	public static void main(String[] args) throws Exception{
		JobSearchAppl appl = new JobSearchAppl();
		appl.add(new HaWebPage());
		appl.add(new HkexWebPage());
		appl.process();
	}
}
