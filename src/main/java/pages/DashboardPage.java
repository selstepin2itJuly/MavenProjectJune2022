package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	private WebDriver dr;
	public DashboardPage(WebDriver driver) 
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//a[@id='welcome']")
	WebElement welcome;
	
	@FindBy(css="#menu_dashboard_index")
	WebElement dashboardTab;
	
	@FindBy(xpath="//legend[text()='Quick Launch']")
	WebElement quickLaunch;
	
	@FindBy(className="quickLinkText")
	List<WebElement> quickLaunchItems;
	
	public boolean isWelcomeDisplayed()
	{
		boolean b= false;
		try
		{
			b=welcome.isDisplayed();
		}catch(Exception e)
		{}
		return b;
	}
	
	public boolean isDashboardDisplayed()
	{
		boolean b= false;
		try
		{
			b=dashboardTab.isDisplayed();
		}catch(Exception e)
		{}
		return b;
	}
	
	public void clickOnDashboardTab() 
	{
		dashboardTab.click();
	}
	
	public boolean isQuickLaunchDisplayed()
	{
		boolean b= false;
		try
		{
			b=quickLaunch.isDisplayed();
		}catch(Exception e)
		{}
		return b;
	}
	
	public List<String> getQuickLaunchItems()
	{
		List<String> temp = new ArrayList<String>();
		for(WebElement e:quickLaunchItems) 
		{
			temp.add(e.getText().trim());
		}
		return temp;
	}
	
	public int getQuickLaunchCount()
	{
		return quickLaunchItems.size();
	}
	
}
