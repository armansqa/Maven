package Demo.Maven;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import Pages.HomePage;
import Pages.LoginPage;



public class pageFactory_Tests {
	
	WebDriver driver = new ChromeDriver();
	
	HomePage homePage = new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);
	
	@BeforeTest
	public void setup() {
		driver.get("https://demo.opencart.com/");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void login_Positive() {
		homePage.Click_login_from_MyAccount();
		loginPage.provideEmail("valid@valid.valid");
		loginPage.providePassword("valid");
		loginPage.clickSubmitButton();
	}
	
	@Test
	public void login_Negative() {
		homePage.Click_login_from_MyAccount();
		loginPage.provideEmail("invalid@valid.valid");
		loginPage.providePassword("invalid");
		loginPage.clickSubmitButton();
		assertEquals(loginPage.verifyFailedLogin(), "Warning: No match for E-Mail Address and/or Password.");
	}
}
