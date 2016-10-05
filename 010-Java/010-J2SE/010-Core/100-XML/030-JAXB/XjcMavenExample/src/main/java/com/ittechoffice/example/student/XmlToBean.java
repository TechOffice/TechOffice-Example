package com.ittechoffice.example.student;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.ittechoffice.example.student.model.Student;

public class XmlToBean {
	public static void main(String[] args) throws JAXBException{
		InputStream stream = XmlToBean.class.getClassLoader().getResourceAsStream("student.xml");
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
//		 StreamSource xml = new StreamSource("src/resources/student.xml");
//		         Unmarshaller unmarshaller = jc.createUnmarshaller();
//		         JAXBElement<Customer> je1 = unmarshaller.unmarshal(xml, Customer.class);
//		         Customer customer = je1.getValue();



	}
}
