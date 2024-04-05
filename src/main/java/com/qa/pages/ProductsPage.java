package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.qa.BaseTest;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductsPage extends BaseTest {
	public ProductsPage(){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy (xpath = "//android.view.View[@resource-id=\\\"alert-1-hdr\\\"]") private WebElement welcomeBackTxt;

	public String getTitle() {
		return getAttribute(welcomeBackTxt, "text");
		
	}
}