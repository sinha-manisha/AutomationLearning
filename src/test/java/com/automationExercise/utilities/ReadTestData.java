package com.automationExercise.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadTestData {
	Properties pro;
	public ReadTestData() {
		File src=new File(".//src/test/java/com/automationExercise/testData/testData.properties");
		
		try {
			FileInputStream file=new FileInputStream(src);
			pro=new Properties();
			pro.load(file);
		}
		catch(Exception e)
		{
			System.out.println("File not found "+e.getMessage());
		}
	}
	public String getTitle() {
		return pro.getProperty("Title");
	}
	public String getName() {
		return pro.getProperty("Name");
	}
	public String getPassword() {
		return pro.getProperty("Password");
	}
	public String getDoBDay() {
		return pro.getProperty("DoB_Day");
	}
	public String getDobMonth() {
		return pro.getProperty("DoB_Month");
	}
	public String getDobYear() {
		return pro.getProperty("DoB_Year");
	}
	public String getLName() {
		return pro.getProperty("LName");
	}
	public String getCompany() {
		return pro.getProperty("Company");
	}
	public String getAddress1() {
		return pro.getProperty("Address1");
	}
	public String getAddress2() {
		return pro.getProperty("Address2");
	}
	public String getCountry() {
		return pro.getProperty("Country");
	}
	public String getState() {
		return pro.getProperty("State");
	}
	public String getCity() {
		return pro.getProperty("City");
	}
	public String getPin() {
		return pro.getProperty("Pin");
	}
	public String getMobile() {
		return pro.getProperty("Mobile");
	}
	public String getLoginId() {
		return pro.getProperty("LoginId");
	}
	public String getLoginPassword() {
		return pro.getProperty("LoginPassword");
	}
	public String getLoginName() {
		return pro.getProperty("LoginName");
	}
	public String getContactName() {
		return pro.getProperty("contactName");
	}
	public String getContactEmail() {
		return pro.getProperty("contactEmail");
	}
	public String getConatactSub() {
		return pro.getProperty("contactSub");
	}
	public String getContactMsg() {
		return pro.getProperty("contactMsg");
	}
	public String getContactFileUpload() {
		return pro.getProperty("contactFileUpload");
	}
	public String getSearchProduct() {
		return pro.getProperty("searchProduct");
	}
	public String getBrand1() {
		return pro.getProperty("brand1");
	}
	public String getBrand2() {
		return pro.getProperty("brand2");
	}

}
