package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginTests extends BaseTest{
	LoginPage loginPage;
	ProductsPage productsPage;

	  @BeforeClass
	  public void beforeClass() {
	  }

	  @AfterClass
	  public void afterClass() {
	  }
	  @BeforeMethod
	  public void beforeMethod(Method m) {
		  loginPage = new LoginPage();
		  System.out.println("/n" + "*** Starting Test: " + m.getName() + "***" + "/n");
	  }

	  @AfterMethod
	  public void afterMethod() {
	  }
	  @Test
	  public void invalidUsername() {
		  try {
			  loginPage.enterUserName("invalidEmail");
			  loginPage.enterPassword("Innova123");
			  loginPage.pressLoginBtn();
			  
			  String actualId = loginPage.getErrTxt();
			  String expectedId="[84,780][535,899]";
			  
			  Assert.assertEquals(actualId, expectedId);
		  }catch(Exception e) {
			  StringWriter sw = new StringWriter();
			  PrintWriter pw = new PrintWriter(sw);
			  e.printStackTrace(pw);
			  System.out.println(sw.toString());
			  Assert.fail(sw.toString());
		  }
	  }
	  @Test
	  public void invalidPassword() {
		  loginPage.enterUserName("estrella1@innova.com");
		  loginPage.enterPassword("password");
		  loginPage.pressLoginBtn();
		  
		  String actualId = loginPage.getErrTxt();
		  String expectedId="[84,780][535,899]";
		  
		  
		  Assert.assertEquals(actualId, expectedId);
	  }
	  @Test
	  public void successfulLogin() {
		  loginPage.enterUserName("estrella1@innova.com");
		  loginPage.enterPassword("Innova123");
		  productsPage = loginPage.pressLoginBtn();
		  
		  String actualTitle = productsPage.getTitle();
		  String expectedTitle= "Welcome back to App X";
		  
		  
		  Assert.assertEquals(actualTitle, expectedTitle);
	  }
	  

}
