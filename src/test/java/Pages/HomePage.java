package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "My Account")
	WebElement MyAccountButton;
	
	@FindBy(linkText = "Login")
	WebElement LoginButton;
	
	public void Click_login_from_MyAccount() {
		MyAccountButton.click();
		LoginButton.click();
	}
}
