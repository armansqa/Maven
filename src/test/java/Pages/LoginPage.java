package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-email")
	WebElement Login_email;
	
	@FindBy(id = "input-password")
	WebElement Login_pass;
	
	@FindBy(css = "#content > div > div:nth-child(2) > div > form > input")
	WebElement LoginSubmitButton;
	
	@FindBy(xpath = "//*[@id=\"account-login\"]/div[1]")
	WebElement errorMessageForFailedLogin;
	
	public void fullLogin() {
		Login_email.sendKeys("");
		Login_pass.sendKeys("");
		LoginSubmitButton.click();
	}
	
	public void provideEmail(String email) {
		Login_email.sendKeys(email);
	}
	
	public void providePassword(String pass) {
		Login_pass.sendKeys(pass);
	}
	
	public void clickSubmitButton() {
		LoginSubmitButton.click();
	}
	
	public String verifyFailedLogin() {
		errorMessageForFailedLogin.getText();
		return errorMessageForFailedLogin.getText();
	}
}
