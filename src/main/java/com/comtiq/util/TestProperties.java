package com.comtiq.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class TestProperties {

	public static final String BROWSER = "BROWSER";
	public static final String EMAIL = "EMAIL";
	public static final String PASSWORD = "PASSWORD";
	public static final String URL = "URL";

	
	EBrowser browser;
	String emailAddress;
	String password;
	public EBrowser getBrowser() {
		return browser;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public String getUrl() {
		return url;
	}

	public static TestProperties getProperties() {
		return properties;
	}
	String url;
	private static TestProperties properties = null;
	private TestProperties() throws Exception{
		Properties defaultProps = new Properties();
		FileInputStream in = new FileInputStream("test.properties");
		defaultProps.load(in);
		emailAddress = defaultProps.getProperty(EMAIL);
		password = defaultProps.getProperty(PASSWORD);
		url = defaultProps.getProperty(URL);
		String b = defaultProps.getProperty(BROWSER);
		browser = EBrowser.valueOf(b);
		in.close();
	}
	
	public static TestProperties getInstance(){
		if(properties == null){
			
			try {
				properties = new TestProperties();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return properties;
		
	}
	public static void main(String[] args)
	{
		TestProperties p = TestProperties.getInstance();
	}
	
}
