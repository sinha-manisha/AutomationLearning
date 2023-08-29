package com.automationExercise.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {
		File src= new File(".//Configuration/config.properties");
		try {
			FileInputStream file= new FileInputStream(src);
			pro=new Properties();
			pro.load(file);	
		}
		catch(Exception e)
		{
			System.out.println("Exception is: "+e.getMessage());
		}
	}
	public String getURL() {
		return pro.getProperty("baseURL");
	}
	public String getHomeTitle() {
		return pro.getProperty("homePageTitle");
	}
	public String getChromePath() {
		return pro.getProperty("chromepath");
	}
	public String getFireFoxPath() {
		return pro.getProperty("geckopath");
	}
	public String getSignUpText() {
		return pro.getProperty("signupText");
	}
	public String getSignUpForm() {
		return pro.getProperty("signUpForm");
	}
	public String getAccountCreated() {
		return pro.getProperty("accountCreated");
	}
	public String getAccountDeleted() {
		return pro.getProperty("accountDeleted");
	}
	public String getLoginText() {
		return pro.getProperty("loginPageText");
	}
	public String getContactUsText() {
		return pro.getProperty("contactUsPageText");
	}
	public String getTestPageTitle() {
		return pro.getProperty("testPageTitle");
	}

}
