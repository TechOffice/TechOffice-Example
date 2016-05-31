package com.ittechoffice.jobsearch.webpage.publicorg;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.ittechoffice.jobsearch.base.BaseJobPage;
import com.ittechoffice.jobsearch.model.Job;

public class MpfaWebPage extends BaseJobPage{
	private static String url = "http://www.mpfa.org.hk/eng/mpfa/join_us/job_opportunities/index.jsp";
	private String institionName = "MPFA";
	private String jobTableXpath = "//*[@id='printcontent']/div/table";
	private String lastUpdatedXpath = "//*[@id='printDate']";
	private String lattUpdateDesc = "Last Revision Date: ";
	
	public MpfaWebPage(){
		super(url);
	}
	
	protected void processLastUpdated() throws ParseException{
		HtmlElement lastUpdateHtmlElement =  page.getFirstByXPath(lastUpdatedXpath);
		String lastUpdatedText = lastUpdateHtmlElement.getTextContent();
		lastUpdatedText = lastUpdatedText.replace(lattUpdateDesc, "");
		lastUpdated = lastUpdatedDateFormat.parse(lastUpdatedText);
	}
	
	protected void processJobs() throws ParseException{
		HtmlElement jobTableHtmlElement =  page.getFirstByXPath(jobTableXpath);
		DomNodeList<HtmlElement> jobHtmlElementList = jobTableHtmlElement.getElementsByTagName("tr");
		for (int i=1; i<jobHtmlElementList.size(); i++){
			HtmlElement jobElement = jobHtmlElementList.get(i);
			String position = jobElement.getElementsByTagName("td").get(0).getTextContent();
			String deadLine = jobElement.getElementsByTagName("td").get(1).getTextContent();
			SimpleDateFormat deadLineDateFormat = new SimpleDateFormat("dd MM yyyy");
			Job job = new Job();
			job.setInstitionName(institionName);
			job.setUrl(url);
			System.out.println(deadLine);
			job.setDeadLine(deadLineDateFormat.parse(deadLine));
			job.setPosition(position);
			jobList.add(job);
		}
	}
	
	public static void main(String[] args) throws Exception{
//		MpfaWebPage mpfaWebPage = new MpfaWebPage();
//		mpfaWebPage.process();
//		List<Job> jobs = mpfaWebPage.getJobList();
//		for (Job job: jobs){
//			System.out.format("%-10s %-10s\n", job.getPosition(), job.getDeadLine());
//		}
		String dateString = "29 April 2016";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
		Date d = dateFormat.parse(dateString);
	}
}
