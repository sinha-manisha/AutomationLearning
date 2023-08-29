package com.automationExercise.testCases;

import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.CategoryPage;
import com.automationExercise.pageObjects.HomePage;

public class TC_018_CategoryProductsTest extends BaseClass{
	@Test
	public void verifyCategoryProducts() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("CategoryProductsTest");
		home.verifyCatgoryTxt("CategoryProductsTest");
		home.clickWomenCategory();
		home.clickWomenDress();
		Thread.sleep(2000);
		CategoryPage cat=new CategoryPage();
		cat.verifyCategoryPage("CategoryProductsTest");
		cat.verifyWomenCategTxt();
		cat.verifyMenCategNav("CategoryProductsTest");
	}
}
