package Demo.Maven;

import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_DemoOpenCart {
	
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void setup() {
		driver.get("https://demo.opencart.com/");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	@Test(priority=1)
	public void loginTest_Positive() throws InterruptedException {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("xyz@arman.com");
		driver.findElement(By.id("input-password")).sendKeys("1234");
		driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input")).click();

		
		Thread.sleep(5000);
		
		String Expected = "My Account";
		String Actual 	= driver.findElement(By.cssSelector("#content > h2:nth-child(1)")).getText();
		
		assertEquals(Actual, Expected);
	
	} 
	
	@Test(priority=2)
	public void secondTest() {
		System.out.println("This is the second test result");
	}
	
	@Test(priority=3)
	public void thirdTest() {
		System.out.println("This is the third test result");
	}
	
	@Test(priority=4)
	public void fourthTest() {
		System.out.println("This is the fourth test result");
	}
	
}
