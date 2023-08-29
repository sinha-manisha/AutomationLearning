package com.automationExercise.testCases;

import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.AllProductsPage;
import com.automationExercise.pageObjects.CartPage;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.pageObjects.LoginPage;
import com.automationExercise.pageObjects.SearchPage;
import com.automationExercise.utilities.ReadTestData;

public class TC_020_SearchProductNVerifyCartAfterLoginTest extends BaseClass{
	ReadTestData tdata=new ReadTestData();
	public String searchPro=tdata.getSearchProduct();
	public String loginId=tdata.getLoginId();
	public String loginPassword=tdata.getLoginPassword();
	public String u_name=tdata.getLoginName();
	@Test
	public void verifySearchProductNVerifyCartAfterLogin() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("SearchProductNVerifyCartAfterLoginTest");
		home.clickProduct();
		AllProductsPage app=new AllProductsPage();
		app.verifyProPageNav("SearchProductNVerifyCartAfterLoginTest");
		app.searchProduct(searchPro);
		SearchPage sp=new SearchPage();
		sp.searchResult("SearchProductNVerifyCartAfterLoginTest");
		int items=sp.AddAllToCart();
		sp.getCart();
		CartPage cp= new CartPage();
		cp.verifyItemsInCart(items, "SearchProductNVerifyCartAfterLoginTest");
		cp.getSignUp();
		LoginPage lp= new LoginPage();
		lp.verifyLoginPage();
		lp.setValidLoginData(loginId, loginPassword,"SearchProductNVerifyCartAfterLoginTest");
		home.verifyLoginMsg(u_name,"SearchProductNVerifyCartAfterLoginTest");
		home.clickCart();
		cp.verifyItemsInCart(items,"SearchProductNVerifyCartAfterLoginTest" );
	}

}
