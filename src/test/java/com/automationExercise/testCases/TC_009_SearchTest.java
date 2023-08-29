package com.automationExercise.testCases;

import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.AllProductsPage;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.pageObjects.SearchPage;
import com.automationExercise.utilities.ReadTestData;

public class TC_009_SearchTest extends BaseClass {
	ReadTestData tdata=new ReadTestData();
	public String searchPro=tdata.getSearchProduct();
	@Test(priority=0)
	public void verifySearch() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("SearchTest");
		home.clickProduct();
		AllProductsPage app=new AllProductsPage();
		app.verifyProPageNav("SearchTest");
		app.searchProduct(searchPro);
		SearchPage sp=new SearchPage();
		sp.searchResult("SearchTest");
	}

}
