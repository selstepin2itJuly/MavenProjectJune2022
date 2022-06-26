package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class LoginTest {
  
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
	private ForgotPasswordPage fp;
	
	
	@Test(priority=1,description="Successful login to app")
	public void LoginSuccess_001() throws IOException, InterruptedException 
	{
		lp.loginToApplication(TestBase.prop.getProperty("user"), TestBase.prop.getProperty("pass"));
		boolean act = dp.isWelcomeDisplayed();
		TestUtility.attachScreenshot();
		Reporter.log("Actual:"+act+"--->"+"Expected: true");
		Assert.assertEquals(act, true);
	}
	
	@Test(priority=0,description="Unsuccessful Login")
	public void LoginUnSuccessful_002() throws IOException, InterruptedException 
	{
		lp.loginToApplication(TestBase.prop.getProperty("user"), TestBase.prop.getProperty("incorrectpass"));
		boolean act = lp.isErrorMsgDisplayed();
		TestUtility.attachScreenshot();
		Reporter.log("Actual:"+act+"--->"+"Expected: true");
		Assert.assertEquals(act, true);
		String actString = lp.getErrorMsg();
		Reporter.log("Actual:"+actString+"--->"+"Expected: Invalid credentials");
		Assert.assertEquals(actString, "Invalid credentials");
		
	}
	/*
	 * TestCase ignored
	 */
	@Test(priority=2,description="Forgot Password", enabled=false)
	public void ForgotPassword_003() throws IOException, InterruptedException 
	{
		//lp.loginToApplication(TestBase.prop.getProperty("user"), TestBase.prop.getProperty("incorrectpass"));
		lp.clickOnForgotPass();
		boolean act = fp.isResetPassDisplayed();
		TestUtility.attachScreenshot();
		Reporter.log("Actual:"+act+"--->"+"Expected: true");
		Assert.assertEquals(act, true);
	}
  
	@BeforeMethod
	public void beforeMethod() throws IOException {
		dr=TestBase.getInstance();
		lp = new LoginPage(dr);
		dp= new DashboardPage(dr);
		fp = new ForgotPasswordPage(dr);
	}

	@AfterMethod
	public void afterMethod() {
		dr.quit();
	}

}
