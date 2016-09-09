package com.ittechoffice.example;

import java.io.File;
import java.io.IOException;

import com.sun.codemodel.JClassAlreadyExistsException;

public class Appl {
	public static void main(String[] args) throws JClassAlreadyExistsException, IOException{
		PojoGenerator PojoGenerator = new PojoGenerator("", "User");
		PojoGenerator.addField(String.class, "name");
		PojoGenerator.addField(String.class, "lname");
		PojoGenerator.generateCode(new File("D:/Users/Ben_c/workspace/CodeModelExample/Output"));
	}
}
