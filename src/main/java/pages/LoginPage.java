package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver dr;
	public LoginPage(WebDriver driver) 
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(name="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	//@FindBys({@FindBy(name="Submit"),@FindBy(id="btnLogin")})
	@FindBy(name="Submit")
	WebElement loginButton;
	
	@FindBy(css="span[id='spanMessage']")
	WebElement errorMsg;
	
	@FindBy(linkText="Forgot your password?")
	WebElement forgotPass;
	
	public void loginToApplication(String user, String pass)
	{
		username.clear();
		username.sendKeys(user);
		password.clear();
		password.sendKeys(pass);
		loginButton.click();
	}
	
	public boolean isErrorMsgDisplayed()
	{
		boolean b = false;
		try {
			b = errorMsg.isDisplayed();
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		return b;
	}
	
	public String getErrorMsg()
	{
		return errorMsg.getText().trim();
	}
	
	public void clickOnForgotPass()
	{
		forgotPass.click();
	}
	
}
