package com.ittechoffice.example;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Dom4jToolService {
	
	@Autowired
	private Dom4jHelper dom4jHelper;
	
	public String parse(String xml) throws DocumentException{
		Document document = dom4jHelper.parse(xml);
		return document.asXML();
	}
	
	public List queryByXpath(String xml, String xpath) throws DocumentException{
		Document document = dom4jHelper.parse(xml);
		List list = document.selectNodes(xpath);
		return list;
	}
}
