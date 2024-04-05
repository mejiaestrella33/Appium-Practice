package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.qa.BaseTest;

import io.appium.java_client.pagefactory.AndroidFindBy;


public class LoginPage extends BaseTest {
	@AndroidFindBy (xpath = "//android.view.View[@resource-id=\"main-content\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText") private WebElement usernameTxtField;
	@AndroidFindBy (xpath = "//android.view.View[@resource-id=\"main-content\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText") private WebElement passwordTxtField;
	@AndroidFindBy (xpath = "//android.widget.Button[@text=\"Log in\"]") private WebElement loginBtn;
	@AndroidFindBy (xpath = "//android.view.View[@resource-id=\"main-content\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]") private WebElement errorTxt;

	
public LoginPage enterUserName(String username) {
	sendKeys(usernameTxtField, username);
	return this;
	
}
public LoginPage enterPassword(String password) {
	sendKeys(passwordTxtField, password);
	return this;
	
}
public ProductsPage pressLoginBtn() {
	click(loginBtn);
	return new ProductsPage();
	
}

public String getErrTxt() {
	return getAttribute(errorTxt,"bounds");
	
}
}