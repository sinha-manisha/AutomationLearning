package com.automationExercise.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.pageObjects.LoginPage;
import com.automationExercise.utilities.ReadTestData;
import com.automationExercise.utilities.XLUtils;

public class TC_003_InvalidLoginTest extends BaseClass{
	ReadTestData tdata=new ReadTestData();
	public String u_name=tdata.getLoginName();
	@Test(priority=0,dataProvider="LogInData")
	public void verifyInvalidLogin(String email,String pwd) throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("InvalidLoginTest");
		home.clickSignup();
		LoginPage lp=new LoginPage();
		lp.verifyLoginPage();
		lp.setValidLoginData(email, pwd,"InvalidLoginTest");
		Thread.sleep(2000);
		lp.verifyInvalidLoginMsg();
		lp.getHome();
	}
	@DataProvider(name="LogInData")
	public String[][] getData() throws IOException{
		String path=".//src/test/java/com/automationExercise/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int column=XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][]=new String [rownum][column];
		for(int r=1;r<=rownum;r++)
		{
			for(int c=0;c<column;c++)
			{
				logindata[r-1][c]=XLUtils.getCellData(path, "Sheet1", r, c);
			}
		}
		return logindata;
		
	}
}
