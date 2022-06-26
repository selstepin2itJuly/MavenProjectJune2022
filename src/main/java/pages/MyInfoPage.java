package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {

	private WebDriver dr;
	public MyInfoPage(WebDriver driver) 
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(css="#menu_pim_viewMyDetails")
	WebElement myInfo;
	
	@FindBy(xpath="//ul[@id='sidenav']/li/a")
	List<WebElement> sideMenu;
	
	public void clickOnMyInfo()
	{
		myInfo.click();
	}
	
	public boolean isMyInfoDisplayed()
	{
		boolean b = false;
		try {
			b = myInfo.isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
	
	public List<String> getMyInfoSideMenuItems()
	{
		List<String> temp = new ArrayList<String>();
		for(WebElement ele:sideMenu)
		{
			temp.add(ele.getText().trim());
		}
		return temp;
	}

	public int getMyInfoSideMenuItemsCount()
	{
		return sideMenu.size();
	}
}
