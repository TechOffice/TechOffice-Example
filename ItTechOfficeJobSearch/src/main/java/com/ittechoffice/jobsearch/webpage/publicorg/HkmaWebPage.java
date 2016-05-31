package com.ittechoffice.jobsearch.webpage.publicorg;

import java.text.SimpleDateFormat;
import java.util.Locale;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.ittechoffice.jobsearch.base.BaseJobPage;
import com.ittechoffice.jobsearch.model.Job;

public class HkmaWebPage extends BaseJobPage{
	private static String url = "http://www.hkma.gov.hk/eng/about-the-hkma/careers-hkma/recruitment/";
	private String lastUpdatedId = "lastUpdate";
	private String lastUpdatedDesc = "Last revision date:  ";
	private String lastUpdatedDateFormatStr = "dd MMM yyyy";
	private String mainTableXpath = "//*[@id='content']/div/table";
	
	
	public HkmaWebPage(){
		super(url);
	}
	
	@Override
	protected void processLastUpdated() throws Exception {
		DomElement lastUpdatedElement = page.getElementById(lastUpdatedId);
		String lastDateStr = lastUpdatedElement.getTextContent().replace(lastUpdatedDesc, "");
		SimpleDateFormat lastUpdatedDateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
		lastUpdated = lastUpdatedDateFormat.parse(lastDateStr);
	}
	
	@Override
	protected void processJobs() throws Exception {
		HtmlElement tableHtmlElement = page.getFirstByXPath(mainTableXpath);
		DomNodeList<HtmlElement> rowList = tableHtmlElement.getElementsByTagName("tr");
		for (int i=0; i<rowList.size(); i++){
			HtmlElement row = rowList.get(i);
			DomNodeList<HtmlElement> colList = row.getElementsByTagName("td");
			if (colList.size() > 0 ){
				Job job = new Job();
				String postion = colList.get(0).getTextContent();
				String deadlineStr = colList.get(1).getTextContent();
				SimpleDateFormat deadlineDateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
				job.setPosition(postion);
				job.setDeadLine(deadlineDateFormat.parse(deadlineStr));
				jobList.add(job);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		HkmaWebPage hkmaWebPage = new HkmaWebPage();
		hkmaWebPage.process();
	}
}
