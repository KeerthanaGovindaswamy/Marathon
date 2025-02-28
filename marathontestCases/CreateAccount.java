package marathontestCases;


	import java.time.Duration;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



	public class CreateAccount extends BaseClass{

		@Test
	    public void createAccount() throws InterruptedException {
	        Thread.sleep(1000);
	     //   driver.findElement(By.className("slds-icon- waffle")).click();
			WebDriverWait waitObj = new WebDriverWait(driver,Duration.ofSeconds(10));
			WebElement toffle =  driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
	        waitObj.until(ExpectedConditions.visibilityOf(toffle)) ;
	        toffle.click();
	        driver.findElement(By.xpath("//button[text()='View All']")).click();
	        driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a")).click();
	        WebElement accountsTab = driver.findElement(By.xpath("//a[@title='Accounts']"));
	        driver.executeScript("arguments[0].click();", accountsTab);
	        driver.findElement(By.xpath("//a[@title='New']")).click();
	        String accountName = "Gokul";
	        driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys(accountName);
	        WebElement ownershipDD = driver.findElement(By.xpath("//button[@aria-label='Ownership']"));
	        driver.executeScript("arguments[0].click()",ownershipDD);
	        driver.findElement(By.xpath("//span[text()='Public']")).click();
	        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	        String toastMessage = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
	        System.out.println(toastMessage);
	        Assert.assertTrue(toastMessage.contains(accountName),"Verify the Account name");
	      //setTimeout(function(){debugger},5000)
	    }

	}

