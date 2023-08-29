package com.automationExercise.testCases;

import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.CartPage;
import com.automationExercise.pageObjects.CheckoutPage;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.pageObjects.LoginPage;
import com.automationExercise.pageObjects.OrderConfirmationPage;
import com.automationExercise.pageObjects.PaymentPage;
import com.automationExercise.utilities.ReadTestData;

public class TC_016_LoginBeforeCheckoutTest extends BaseClass{
ReadTestData tdata=new ReadTestData();
	
	public String loginId=tdata.getLoginId();
	public String loginPassword=tdata.getLoginPassword();
	public String u_name=tdata.getLoginName();
	public String u_title=tdata.getTitle();
	public String u_password=tdata.getPassword();

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
	public void verifyLoginBeforeCheckout() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("LoginBeforeCheckoutTest");
		home.clickSignup();
		LoginPage lp=new LoginPage();
		lp.verifyLoginPage();
		lp.setValidLoginData(loginId, loginPassword,"LoginBeforeCheckoutTest");
		home.verifyLoginMsg(u_name,"LoginBeforeCheckoutTest");
		String[] arr= home.addProductsToCart();
		home.clickCart();
		String item1=arr[0];
		String item2=arr[1];
		CartPage cp=new CartPage();
		cp.verifyCartPage("LoginBeforeCheckoutTest");
		cp.getCheckout();
		CheckoutPage chkP=new CheckoutPage();
		//chkP.verifyAddress(u_title, u_name, u_lname, u_company, u_address1, u_address2, u_city, u_state, u_pin, u_country, u_mobile);
		chkP.verifyOrder(item1, item2,"LoginBeforeCheckoutTest");
		chkP.setPlaceOrderData();
		PaymentPage pp=new PaymentPage();
		pp.setPaymentData("Manisha", "123456789","123", "11", "2025","LoginBeforeCheckoutTest","Payment_details");
		OrderConfirmationPage ocp=new OrderConfirmationPage();
		ocp.oderConfirmMsg("LoginBeforeCheckoutTest");
		//ocp.deleteAcc();
		//home.verifyDeleteAccount();
	}

}
