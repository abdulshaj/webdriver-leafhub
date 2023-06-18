package com.learnerhub.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectHooks;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class DashboardPage extends ProjectHooks{
	
	public DashboardPage verifyHomePage() {
		verifyDisplayed(locateElement(Locators.LINK_TEXT, " Dashboard"));
		reportStep("Dashboard appeared", "pass");
		return this;
	}
	
	public UserRegistrationPage clickRegister() {
		click(locateElement(Locators.XPATH, " //a[@href='/leaf/dashboard/registration']"));
		reportStep("Registration Link is clicked", "pass");
		return new UserRegistrationPage();
	}
	
	public LoginPage clickLogout() {
		click(locateElement(Locators.XPATH, "//a[@href='/leaf/dashboard/logout']"));
		reportStep("Logout Link is clicked", "pass");
		return new LoginPage();
	}

	public DashboardPage verifySideBar() {
		//verifyDisplayed(locateElement(Locators.LINK_TEXT, " Dashboard"));
		List<WebElement> listofelements =locateElements(Locators.XPATH, "//*[@class='sidebar-nav']/li/a[starts-with(@href,'/leaf/')]");

		Assert.assertEquals(listofelements.size(),5);
		reportStep("Left Panel Links", "pass");
		return this;
	}

	
}
