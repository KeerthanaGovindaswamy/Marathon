package marathontestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	public ChromeDriver driver;
	
	@Parameters({"url","username","password"})
	@BeforeMethod(alwaysRun=true)
	public void loadURLandLogin(String url,String uname,String pwd) {
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
	    driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get(url);
	    driver.findElement(By.id("username")).sendKeys(uname);
	    driver.findElement(By.id("password")).sendKeys(pwd);
	    driver.findElement(By.id("Login")).click();
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void Logout() {
		driver.close();
		
	}
	

}
