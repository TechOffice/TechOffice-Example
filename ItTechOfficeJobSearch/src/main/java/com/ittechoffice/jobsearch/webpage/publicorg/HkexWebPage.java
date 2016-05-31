package com.ittechoffice.jobsearch.webpage.publicorg;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.regex.Pattern;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.ittechoffice.jobsearch.base.BaseJobPage;
import com.ittechoffice.jobsearch.model.Job;
import com.ittechoffice.jobsearch.utils.StringUtils;
import com.ittechoffice.jobsearch.utils.WebClientUtils;

public class HkexWebPage extends BaseJobPage{
	private static String url = "https://www.hkex.com.hk/eng/exchange/job_opp/job.htm";
	private static String institionName = "HKEX";
	
	private String mainTableId = "//*[@id='ctl00_PlaceHolderMain_ctl03__ControlWrapper_RichHtmlField']";
	private String lastUpdatedXpath = "//*[@id='ctl00_MSO_ContentDiv']/div[2]/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td";
	private String lastUpdatedDesc = "if(url_level1 == \"eng\"){document.write(\"Updated:&nbsp;\")}else{document.write(\"更新日期:&nbsp;\")}Updated:";
	
	public HkexWebPage() {
		super(url);
	}
	
	public String temp; 
	
	protected void processLastUpdated() throws ParseException{
		HtmlElement lastUpdateHtmlElement = page.getFirstByXPath(lastUpdatedXpath);
		String lastUpdatedText = lastUpdateHtmlElement.getTextContent();
		lastUpdatedText = lastUpdatedText.replace(lastUpdatedDesc, "");
		lastUpdatedText = StringUtils.removeFirstLastChar(lastUpdatedText.trim()).trim();
		lastUpdated = lastUpdatedDateFormat.parse(lastUpdatedText);
	}
	
	protected void processJobs(){
		HtmlElement lastUpdateHtmlElement = page.getFirstByXPath(mainTableId);
		DomNodeList<HtmlElement> jobHtmlElementList = lastUpdateHtmlElement.getElementsByTagName("li");
		for (int i=1; i<jobHtmlElementList.size(); i++){
			HtmlElement jobElement = jobHtmlElementList.get(i);
			String position = jobElement.getTextContent();
			position = position.replace(Character.toString ((char) 160), "").trim();
			if (!"".equals(position)){
				Job job = new Job();
				job.setPosition(position);
				job.setInstitionName(institionName);
				job.setUrl(url);
			}
		}
	}		

	
	public static void main(String[] args) throws Exception{
		HkexWebPage hkexWebPage = new HkexWebPage();
		hkexWebPage.process();
	}




}
