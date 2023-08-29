package com.automationExercise.utilities;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automationExcercise.base.BaseClass;

import io.qameta.allure.Attachment;

public class AllureReport extends BaseClass implements ITestListener{

	@Override
	public void onTestSuccess(ITestResult result) {
		String path=null;
		// TODO Auto-generated method stub
		//System.out.println("Printing :::"+result.getName());
		//saveScreenshot(result.getName(),driver);
		//System.out.println("After !!!!"+result.getInstanceName());
		if(result.getName().equals("verifyScrollWithoutArrowKey"))
		{
			 path=".//ScreenShots/ScrollWithoutArrowKeyTest";
		}
		else if(result.getName().equals("verifyScrollUsingArrowKey"))
		{
			path=".//ScreenShots/ScrollUsingArrowKeyTest";
		}
		else if(result.getName().equals("verifyDownloadPurchaseInvoice"))
		{
			path=".//ScreenShots/DownloadPurchaseInvoiceTest";
		}
			File folder=new File(path);
			File[] files=new File(folder.getPath()).listFiles();
			for(File file:files)
			{
				String fname=file.getName();
				try {
					saveScreenshotPNG(path+"/"+fname);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
	}
	
	@Attachment(value="Saved Screenshot",type="image/png")
	public static byte[] saveScreenshotPNG(String path) throws IOException {
//	    File file = new File(path);
	    BufferedImage bImage = ImageIO.read(new File(path));
	      ByteArrayOutputStream bos = new ByteArrayOutputStream();
	      ImageIO.write(bImage, "png", bos );
	      byte [] data = bos.toByteArray();
	     // System.out.println("File ==="+path);
	      return data;
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Failed.......");
		saveScreenshot(result.getName(),driver);
	}
	
	@Attachment(value = "Screenshot of {0}", type = "image/png")
    public byte[] saveScreenshot(String name, WebDriver driver) {
        return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
 
   
 

}

