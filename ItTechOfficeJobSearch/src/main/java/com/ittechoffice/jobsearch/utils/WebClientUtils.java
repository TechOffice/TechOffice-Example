package com.ittechoffice.jobsearch.utils;

import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;
import org.w3c.css.sac.CSSException;
import org.w3c.css.sac.CSSParseException;
import org.w3c.css.sac.ErrorHandler;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.IncorrectnessListener;
import com.gargoylesoftware.htmlunit.WebClient;

public class WebClientUtils {
	
	public static WebClient getWebClient(){
		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
	    java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF); 
	    java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);
	    WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38);
        webClient.getOptions().setUseInsecureSSL(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.setIncorrectnessListener(new IncorrectnessListener() {
            public void notify(String arg0, Object arg1) {
            }
        });
        webClient.setCssErrorHandler(new ErrorHandler() {
        	public void warning(CSSParseException exception) throws CSSException {
            }
            public void fatalError(CSSParseException exception) throws CSSException {
            }
            public void error(CSSParseException exception) throws CSSException {
            }
        });
        return webClient;
	}
}
