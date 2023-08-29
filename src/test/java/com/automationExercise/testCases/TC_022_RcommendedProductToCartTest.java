package com.automationExercise.testCases;

import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.CartPage;
import com.automationExercise.pageObjects.HomePage;

public class TC_022_RcommendedProductToCartTest extends BaseClass{
	@Test
	public void verifyTC_RcommendedProductToCart()
	{
		HomePage home=new HomePage();
		home.verifyHomePage("RcommendedProductToCartTest");
		home.verifyRecomTxt("RcommendedProductToCartTest");
		String pro1=home.addRecommProd();
		CartPage cp= new CartPage();
		cp.verifyRecomItemToCart(pro1,"RcommendedProductToCartTest");
	}
	
}
