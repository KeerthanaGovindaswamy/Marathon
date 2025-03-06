package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

/*Testcase:2 Ordering mobile
==========================
Note: If you have your own Servicenow Credentials you can use it .


URL:https://dev186929.service-now.com/
User name: admin
Password: 2AqjN!lC2!Vy


1. Launch ServiceNow application
2. Login with valid credentials username as admin and password 
3. Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
4. Click on  mobiles
5. Select Apple iphone13pro
6. Choose yes option in lost or broken iPhone
7. Enter phonenumber as 99 in original phonenumber field
8. Select Unlimited from the dropdown in Monthly data allowance
9. Update color field to SierraBlue and storage field to 512GB
10. Click on Order now option
11. Verify order is placed and copy the request number
12.Take a Snapshot of order placed page  
*/
public class ServiceNow {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Launch browser and load url
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev186929.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//enter username and password
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("2AqjN!lC2!Vy");
		driver.findElement(By.id("sysverb_login")).click();
		
		//Click-All 
		//it is inside the shadow root
		//need to create object for shadow class
		Shadow shadowObj = new Shadow(driver);
		shadowObj.setImplicitWait(10);
		shadowObj.findElementByXPath("//div[text()='All']").click();
		//Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
		//setTimeout(function(){debugger},5000)
		shadowObj.findElementByXPath("//span[text()='Service Catalog']").click();
		//Click on  mobiles
		//inside frame--->shift the focus to frame from driver
		WebElement frameElement = shadowObj.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frameElement);
		driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
		//Select Apple iphone13pro
		driver.findElement(By.xpath("(//a[@class='service_catalog']/following::h2)[1]")).click();
		Thread.sleep(1000);
		//Choose yes option in lost or broken iPhone
		driver.findElement(By.xpath("//span[@class='input-group-radio']//label[text()='Yes']")).click();
		//Enter phonenumber as 99 in original phonenumber field
		driver.findElement(By.xpath("//input[@class='cat_item_option sc-content-pad form-control']")).sendKeys("99");
		
		//Select Unlimited from the dropdown in Monthly data 
		WebElement mdaDD = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select options = new Select(mdaDD);
		options.selectByVisibleText("Unlimited [add $4.00]");
		//Update color field to SierraBlue and storage field to 512GB
		driver.findElement(By.xpath("//label[text()='Sierra Blue']")).click();
		driver.findElement(By.xpath("//label[text()='512 GB [add $300.00]']")).click();
		//Click on Order now option
		driver.findElement(By.id("oi_order_now_button")).click();
		//Verify order is placed and copy the request number
		String text = driver.findElement(By.xpath("//div[@class='notification notification-success']/span[2]")).getText();
		if(text.contains("submitted")) {
			System.out.println("order is placed successfully :" + text);
			String requestNumber = driver.findElement(By.xpath("(//dl//dd)[2]/a/b")).getText();
			System.out.println("Request Number: " + requestNumber);
		}else {
			System.out.println("Order not placed");
		}
		//Take a Snapshot of order placed page  
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/ServiceNowOrderPage.png");
		FileUtils.copyFile(source, dest);
		driver.switchTo().defaultContent();
		driver.close();
	}

}
