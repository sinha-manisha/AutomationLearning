package com.automationExercise.testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.CartPage;
import com.automationExercise.pageObjects.CheckoutPage;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.pageObjects.OrderConfirmationPage;
import com.automationExercise.pageObjects.PaymentPage;
import com.automationExercise.pageObjects.RegisterPage;
import com.automationExercise.utilities.AllureReport;
import com.automationExercise.utilities.ReadTestData;
@Listeners({AllureReport.class})
public class TC_024_DownloadPurchaseInvoiceTest extends BaseClass {
	ReadTestData tdata=new ReadTestData();
	public String u_title=tdata.getTitle();
	public String u_name=tdata.getName();
	public String u_password=tdata.getPassword();
	public String u_dob_day=tdata.getDoBDay();
	public String u_dob_month=tdata.getDobMonth();
	public String u_dob_year=tdata.getDobYear();
	public String u_lname=tdata.getLName();
	public String u_company=tdata.getCompany();
	public String u_address1=tdata.getAddress1();
	public String u_address2=tdata.getAddress2();
	public String u_country=tdata.getCountry();
	public String u_state=tdata.getState();
	public String u_city=tdata.getCity();
	public String u_pin=tdata.getPin();
	public String u_mobile=tdata.getMobile();
	@Test
	public void verifyDownloadPurchaseInvoice() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("DownloadPurchaseInvoiceTest");
		String[] arr=home.addProductsToCart();
		home.clickCart();
		CartPage cp= new CartPage();
		cp.verifyCartPage("DownloadPurchaseInvoiceTest");
		cp.getCheckout();
		CheckoutPage chk=new CheckoutPage();
		chk.clickSignUp();
		RegisterPage reg=new RegisterPage();
		//reg.verifySignUpPage("DownloadPurchaseInvoiceTest");
		reg.setNameEmail(u_name,"DownloadPurchaseInvoiceTest");
		//reg.verifySignUpText();
		reg.setSignUpData(u_title, u_password, u_dob_day, u_dob_month,
				u_dob_year, u_name, u_lname, u_company, u_address1, u_address2,
				u_country, u_state, u_city, u_pin, u_mobile,"DownloadPurchaseInvoiceTest");
		reg.verifyAccountCreation("DownloadPurchaseInvoiceTest");
		home.verifyLoginMsg(u_name,"DownloadPurchaseInvoiceTest");
		home.clickCart();
		cp.getCheckout();
		
		chk.verifyAddress(u_title, u_name, u_lname, u_company, u_address1, u_address2,
				u_city, u_state, u_pin, u_country, u_pin,"DownloadPurchaseInvoiceTest");
		chk.verifyOrder(arr[0], arr[1], "DownloadPurchaseInvoiceTest");
		chk.setPlaceOrderData();
		PaymentPage pp=new PaymentPage();
		pp.setPaymentData(u_name,"56565656","333","09","2025","DownloadPurchaseInvoiceTest","Payment_details");
		OrderConfirmationPage ocp=new OrderConfirmationPage();
		ocp.oderConfirmMsg("DownloadPurchaseInvoiceTest");
		ocp.downloadInvoice();
		ocp.verifyFileDownload();
		ocp.clickContinue();
		home.deleteAcc();
		home.verifyDeleteAccount();
		
	}

}
