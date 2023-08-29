package com.automationExercise.utilities;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener{

	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest logger;
	@Override
	public void onTestSuccess(ITestResult result) {
		String path=null;
		logger=extent.createTest(result.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		if(result.getName().equals("verifyHomePage"))
			 path=".//ScreenShots/HomeTest";
		else if(result.getName().equals("verifyRegisterPage"))
			path=".//ScreenShots/RegisterUserTest";
		else if(result.getName().equals("verifyLogin"))
			path=".//ScreenShots/LoginTest";
		File folder=new File(path);
		File[] allfiles=new File(folder.getPath()).listFiles();
		for(File file:allfiles)
		{
			String fileName=file.getName();
			File imgPath=new File(path+"/"+fileName);
			//System.out.println("File name id::"+path+"/"+fileName);
			String absolutePath = imgPath.getAbsolutePath();
			logger.addScreenCaptureFromPath(absolutePath);
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		String timeStamp=LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss"));
		String repname="Test-Report-"+timeStamp+".html";
		extent = new ExtentReports();
		spark=new ExtentSparkReporter(".//extent-report/"+repname);
		
		extent.attachReporter(spark);

		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "Testing QA");
		extent.setSystemInfo("user", "Manisha");
		
		spark.config().setDocumentTitle("Automation Exercise Test Project");
		spark.config().setReportName("Functional Test Report");
		spark.config().setTheme(Theme.DARK);
		
	}
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	

}
