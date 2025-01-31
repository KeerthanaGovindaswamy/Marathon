package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BookTicketPVR {

	public static void main(String[] args) throws Exception {
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//span[@class='cities-placed'])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='cities-overlay cities-active'])[6]/following-sibling::span")).click();
		//Select Your Cinema
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Cinema']")).click();
		driver.findElement(By.xpath("(//div[@class='p-dropdown-trigger'])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='INOX The Marina Mall, OMR, Chennai']")).click();
		//Select Your Date as Tomorrow
		Thread.sleep(5000);
		driver.findElement(By.xpath("//ul[@class='p-dropdown-items']/li[3]")).click();
		//Select Your Movie
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//ul[@class='p-dropdown-items']/li[2])")).click();
		//Select Your Show Time
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//ul[@class='p-dropdown-items']/li[4])")).click();
		//click on book
		Thread.sleep(5000);
		driver.findElement(By.xpath("((//span[@class='p-button-label p-c'])[5])")).click();
		//click on accept
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		//select available seat
		WebElement selectSeat = driver.findElement(By.xpath("((//div[@class='seat-flow-custom-scroll']/tr[@class='seats-row'])[4]//span[@id='CL.CLUB|J:20'])"));
		boolean check = selectSeat.isEnabled();
		//System.out.println(check);
		if(check == true) {
			selectSeat.click();
			System.out.println("Seat selected");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		String seatInfo = driver.findElement(By.xpath("//div[@class='ticket-value']")).getText();
		System.out.println("Seat info : " + seatInfo);
		String grandTotal = driver.findElement(By.xpath("//div[@class='grand-tota col-md-3']/h6[1]")).getText();
		System.out.println("Grand Total : " + grandTotal);
		//click proceed button
		driver.findElement(By.xpath("//div[@class='register-btn col-md-3']/button")).click();
		Thread.sleep(2000);
		//close popup
		driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]")).click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println("title of the page is : " + title);
		driver.close();
	
		
		

	}

}
