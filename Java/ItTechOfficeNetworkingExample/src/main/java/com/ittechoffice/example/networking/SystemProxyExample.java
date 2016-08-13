package com.ittechoffice.example.networking;

import java.util.Properties;

public class SystemProxyExample {
	public static void main(String[] args){
    	Properties props = System.getProperties();
    	for (Object key: props.keySet()){
    		System.out.println(key.toString());
    	}
	}
}
