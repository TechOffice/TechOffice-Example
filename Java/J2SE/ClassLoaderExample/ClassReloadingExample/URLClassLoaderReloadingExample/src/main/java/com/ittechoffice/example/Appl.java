package com.ittechoffice.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Appl {
	public static void main(String[] args) throws URISyntaxException, MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Path root = Paths.get(Appl.class.getClassLoader().getResource(".").toURI()).getParent().getParent().getParent();
		Path newClassPath = root.resolve("URLClassLoaderClassesExample/target/classes/");
		URL newClassPathUrl = newClassPath.toUri().toURL();
		URL[] newClassPathUrlArr = new URL[] {newClassPathUrl};
		URLClassLoader classLoader = new URLClassLoader(newClassPathUrlArr);
		Class example1Class = classLoader.loadClass("com.ittechoffice.example.Example1");
		Object example1 = example1Class.newInstance();
		Method example1ClassSayHiMethod = example1Class.getDeclaredMethod("sayHi");
		example1ClassSayHiMethod.invoke(example1);
	}
}
