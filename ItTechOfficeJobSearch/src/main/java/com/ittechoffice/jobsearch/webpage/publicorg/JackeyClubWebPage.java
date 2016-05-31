package com.ittechoffice.jobsearch.webpage.publicorg;

import java.text.ParseException;

import com.ittechoffice.jobsearch.base.BaseJobPage;

public class JackeyClubWebPage extends BaseJobPage{
	private static String url = "http://corporate.hkjc.com/corporate/english/career/full-time.aspx#bottom_nav_home";
	
	public JackeyClubWebPage(){
		super(url);
	}

	@Override
	protected void processLastUpdated() throws ParseException {
		
	}

	@Override
	protected void processJobs() {
		
	}
}
