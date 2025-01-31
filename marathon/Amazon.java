package marathon;
/*01) Launch Chrome  
02) Load https://www.amazon.in/
     add  implicitlyWait
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
03) Type "Bags for boys" in the Search box
04) Choose the 	 item in the result (bags for boys)
05) Print the total number of results (like 50000)
   example like this-----> 1-48 of over 50,000 results for "bags for boys"
06) Select the first 2 brands in the left menu
    (like American Tourister, Generic)
07) Choose New Arrivals (Sort)
08) Print the first resulting bag info (name, discounted price)
09) Get the page title and close the browser(driver.close())*/
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazon {

	public static void main(String[] args) throws Exception {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Type "Bags for boys" in the Search box
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags for Boys",Keys.ENTER);
		String total = driver.findElement(By.xpath("//span[contains(text(),'1-48 ')]")).getText();
		System.out.println("Total no.of results : " +total);
		driver.findElement(By.xpath("(//span[text()='Brands']/following::span[text()='Safari'])")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()='Brands']/following::span[text()='American Tourister'])")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("(//i[@class='a-icon a-icon-dropdown'])")).click();
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[text()='Newest Arrivals'])")).click();
		Thread.sleep(2000);
		//Print the first resulting bag info (name, discounted price)
		String brand = driver.findElement(By.xpath("(//h2[@class='a-size-mini s-line-clamp-1']/span[text()='Safari'])")).getText();
		System.out.println("The brand is :" +brand);
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])")).getText();
		System.out.println("The discount price is :" +price);
		Thread.sleep(1000);
		driver.close();
	}

}
