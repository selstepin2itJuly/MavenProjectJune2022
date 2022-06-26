package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class DashboardTest {
 
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
  @Test(priority=1,description="Get Quick Launch Items on Dashboard")
  public void getDashboardQuickLaunchItems_004() throws IOException, InterruptedException {
	  //boolean b = dp.isWelcomeDisplayed();
	  dp.clickOnDashboardTab();
	  TestUtility.attachScreenshot();
	  Assert.assertEquals(dp.isWelcomeDisplayed(), true);
	 // boolean c = dp.isDashboardDisplayed();
	  Assert.assertEquals(dp.isDashboardDisplayed(), true);
	 // boolean c = dp.isDashboardDisplayed();
	  Assert.assertEquals(dp.isQuickLaunchDisplayed(), true);
	  List<String> act = dp.getQuickLaunchItems();
	  List<String> exp = new ArrayList<String>();
	  exp.add("Assign Leave");
	  exp.add("Leave List");
	  exp.add("Timesheets");
	  exp.add("Apply Leave");
	  exp.add("My Leave");
	  exp.add("My Timesheet");
	  Reporter.log("Actual:"+act+"-->"+"Expected:"+exp);
	  Assert.assertEquals(act, exp);
	  
  }
  @Test(priority=2,description="Get Quick Launch count on Dashboard")
  public void getDashboardQuickLaunchItemsCount_006() throws IOException, InterruptedException {
	  //boolean b = dp.isWelcomeDisplayed();
	  dp.clickOnDashboardTab();
	  TestUtility.attachScreenshot();
	  Assert.assertEquals(dp.isWelcomeDisplayed(), true);
	 // boolean c = dp.isDashboardDisplayed();
	  Assert.assertEquals(dp.isDashboardDisplayed(), true);
	 // boolean c = dp.isDashboardDisplayed();
	  Assert.assertEquals(dp.isQuickLaunchDisplayed(), true);
	  int act = dp.getQuickLaunchCount();
	  Reporter.log("Actual:"+act+"-->"+"Expected:"+6);
	  Assert.assertEquals(act, 6);
	  
  }
  
  
  
  @BeforeClass
  public void beforeClass() throws IOException {
	  dr = TestBase.getInstance();
	  lp = new LoginPage(dr);
	  lp.loginToApplication(TestBase.prop.getProperty("user"), TestBase.prop.getProperty("pass"));
	  dp = new DashboardPage(dr);
	  
  }

  
  @AfterClass
  public void afterClass() {
	  dr.quit();
  }

}
