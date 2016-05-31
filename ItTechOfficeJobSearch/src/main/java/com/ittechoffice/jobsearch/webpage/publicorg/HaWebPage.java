package com.ittechoffice.jobsearch.webpage.publicorg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.FrameWindow;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.ittechoffice.jobsearch.base.BaseJobPage;
import com.ittechoffice.jobsearch.model.Job;

public class HaWebPage extends BaseJobPage{
	protected static String url = "http://www.ha.org.hk/visitor/ha_visitor_index.asp?Content_ID=2010&Lang=ENG";
	private String jobTableXpath = "//*[@id='contentarea']/table/tbody/tr/td/li[6]/table[2]/tbody/tr[2]/td/table";
	
	public HaWebPage(){
		super(url);
	}
	
	@Override
	protected void processLastUpdated() throws ParseException {
		// ha do not contain last updated info
	}

	@Override
	protected void processJobs() throws ParseException {
		List<FrameWindow> window = page.getFrames();
		HtmlPage pageTwo = (HtmlPage) window.get(0).getEnclosedPage();
		SimpleDateFormat jobDeadlineDateFormat = new SimpleDateFormat("dd/m/yyyy");
		HtmlElement jobTablesHtmlElement = pageTwo.getFirstByXPath(jobTableXpath);
		DomNodeList<HtmlElement> jobSubTablesHtmlElementList =jobTablesHtmlElement.getElementsByTagName("table");
		for (int i = 0; i<jobSubTablesHtmlElementList.size(); i++){
			HtmlElement jobSubTableHtmlElement = jobSubTablesHtmlElementList.get(i);
			DomNodeList<HtmlElement> jobInfoRowHtmlElementList = jobSubTableHtmlElement.getElementsByTagName("tr");
			for (int j=0; j<jobInfoRowHtmlElementList.getLength(); j++){
				HtmlElement jobInfoRowHtmlElement = jobInfoRowHtmlElementList.get(j);
				List<HtmlElement> jobInfoColHtmlElementList = jobInfoRowHtmlElement.getElementsByTagName("td");
				if (jobInfoColHtmlElementList.size() > 2){
					String position = jobInfoColHtmlElementList.get(2).getElementsByTagName("a").get(0).getTextContent().trim();
					String deadline = jobInfoColHtmlElementList.get(3).getTextContent().trim().replace(" ", "");
					Job job = new Job();
					job.setPosition(position);
					job.setDeadLine(jobDeadlineDateFormat.parse(deadline));
					System.out.println(position);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		HaWebPage haWebPage = new HaWebPage();
		haWebPage.process();
	}
}
