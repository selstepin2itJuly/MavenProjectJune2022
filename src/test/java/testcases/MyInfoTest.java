package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class MyInfoTest {
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
	private MyInfoPage mp;
  @Test(priority=1,description="Get Side Menu Items on My Info Tab")
  public void getMyInfoSideMenuItems_005() throws IOException, InterruptedException {
	  lp.loginToApplication(TestBase.prop.getProperty("user"), TestBase.prop.getProperty("pass"));
	  TestUtility.attachScreenshot();
	  Assert.assertEquals(dp.isWelcomeDisplayed(), true);
	  mp.clickOnMyInfo();
	  TestUtility.attachScreenshot();
	  Assert.assertEquals(mp.isMyInfoDisplayed(), true);
	  List<String> act = mp.getMyInfoSideMenuItems();
	  List<String> exp = new ArrayList<String>();
	  exp.add("Personal Details");
	  exp.add("Contact Details");
	  exp.add("Emergency Contacts");
	  exp.add("Dependents");
	  exp.add("Immigration");
	  exp.add("Job");
	  exp.add("Salary");
	  exp.add("Tax Exemptions");
	  exp.add("Report-to");
	  exp.add("Qualifications");
	  exp.add("Memberships");
	  Reporter.log("Actual:"+act+"-->"+"Expected:"+exp);
	  Assert.assertEquals(act, exp);
	  
  }
  @Test(priority=2, description="Get count of Items in side menu of My Info")
  public void getMyInfoSideMenuItemsCount_007() throws IOException, InterruptedException {
	  lp.loginToApplication(TestBase.prop.getProperty("user"), TestBase.prop.getProperty("pass"));
	  TestUtility.attachScreenshot();
	  Assert.assertEquals(dp.isWelcomeDisplayed(), true);
	  mp.clickOnMyInfo();
	  TestUtility.attachScreenshot();
	  Assert.assertEquals(mp.isMyInfoDisplayed(), true);
	  int act = mp.getMyInfoSideMenuItemsCount();
	  Reporter.log("Actual:"+act+"-->"+"Expected:"+11);
	  Assert.assertEquals(act, 11);
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  dr = TestBase.getInstance();
	  lp = new LoginPage(dr);
	  dp = new DashboardPage(dr);
	  mp = new MyInfoPage(dr);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  dr.quit();
  }

}
