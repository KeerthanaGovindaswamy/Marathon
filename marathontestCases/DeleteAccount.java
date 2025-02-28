package marathontestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeleteAccount extends BaseClass  {

	//@Test(dependsOnMethods={"editAccount"})	
	@Test
    public void deleteAccount() throws InterruptedException {
		
		
    //  driver.findElement(By.className("slds-icon- waffle")).click();
		Thread.sleep(1000);
    			WebDriverWait waitObj = new WebDriverWait(driver,Duration.ofSeconds(20));
    			WebElement toffle =  driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
    	        waitObj.until(ExpectedConditions.visibilityOf(toffle)) ;
    	        toffle.click();

        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a")).click();
        WebElement accountsTab = driver.findElement(By.xpath("//a[@title='Accounts']"));
        driver.executeScript("arguments[0].click()",accountsTab);
        driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Gokul"+ Keys.ENTER);
        Thread.sleep(2000);
        String noOfItems = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
        //6 items • 
        //NumberFormatException: For input string: "50+"
        
        String[] s = noOfItems.split(" ");
        System.out.println(s[0]);
        int countBeforeDelete = Integer.parseInt(s[0]);
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).click();
        driver.findElement(By.xpath("//a[@title='Delete']")).click();
        driver.findElement(By.xpath("//button[@title='Delete']")).click();
        Thread.sleep(2000);
       noOfItems = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
       s = noOfItems.split(" ");
       int countAfterDelete = Integer.parseInt(s[0]);

       Assert.assertTrue(countBeforeDelete==(countAfterDelete+1),"Verify the account has deleted");

    }


}

