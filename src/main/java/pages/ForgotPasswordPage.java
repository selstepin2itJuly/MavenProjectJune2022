package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

	private WebDriver dr;
	public ForgotPasswordPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(css="input[value='Reset Password']")
	WebElement forgotMsg;
	
	public boolean isResetPassDisplayed()
	{
		boolean b = false;
		try
		{
			b = forgotMsg.isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
}
