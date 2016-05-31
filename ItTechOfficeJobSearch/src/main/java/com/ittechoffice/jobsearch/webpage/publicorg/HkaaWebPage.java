package com.ittechoffice.jobsearch.webpage.publicorg;

import java.text.SimpleDateFormat;

import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.ittechoffice.jobsearch.base.BaseJobPage;
import com.ittechoffice.jobsearch.model.Job;

public class HkaaWebPage extends BaseJobPage{
	private static String url = "http://www.hongkongairport.com/eng/business/airport-authority/career/careeropportunity.html";
	private String mainTableXpath = "//*[@id='innerpage']/table";
	
	public HkaaWebPage(){
		super(url);
	}

	@Override
	protected void processLastUpdated() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processJobs() throws Exception {
		SimpleDateFormat jobDeadlineDateFormat = new SimpleDateFormat("yyyy/mm/dd");
		HtmlElement jobTableHtmlElement = page.getFirstByXPath(mainTableXpath);
		DomNodeList<HtmlElement> rowNodeList = jobTableHtmlElement.getElementsByTagName("tr");
		for (int i =0; i<rowNodeList.size();i++){
			HtmlElement rowElement = rowNodeList.get(i);
			DomNodeList<HtmlElement> colNodeList = rowElement.getElementsByTagName("td");
			if (colNodeList != null && colNodeList.size() > 0){
				Job job = new Job();
				String position = colNodeList.get(0).getElementsByTagName("a").get(0).getTextContent();
				String deadline = colNodeList.get(1).getTextContent();
				job.setPosition(position);
				job.setDeadLine(jobDeadlineDateFormat.parse(deadline));
				System.out.println(position);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		HkaaWebPage hkiaWebPage = new HkaaWebPage();
		hkiaWebPage.process();
	}
	
}
