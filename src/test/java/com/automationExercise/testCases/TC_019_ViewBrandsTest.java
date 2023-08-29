package com.automationExercise.testCases;

import org.testng.annotations.Test;

import com.automationExcercise.base.BaseClass;
import com.automationExercise.pageObjects.AllProductsPage;
import com.automationExercise.pageObjects.BrandsPage;
import com.automationExercise.pageObjects.HomePage;
import com.automationExercise.utilities.ReadTestData;

public class TC_019_ViewBrandsTest extends BaseClass{
	ReadTestData tdata =new ReadTestData();
	public String brand1=tdata.getBrand1();
	public String brand2=tdata.getBrand2();
	@Test

	public void verifyViewBrands() throws InterruptedException {
		HomePage home=new HomePage();
		home.verifyHomePage("ViewBrandsTest");
		home.clickProduct();
		AllProductsPage app=new AllProductsPage();
		app.verifyBrands("ViewBrandsTest");
		app.clickBrandOne();
		BrandsPage bp=new BrandsPage();
		bp.verifyBrandNav("ViewBrandsTest", brand1);
		bp.getAnotherBrand();
		bp.verifyBrandNav("ViewBrandsTest", brand2);
	}

}
