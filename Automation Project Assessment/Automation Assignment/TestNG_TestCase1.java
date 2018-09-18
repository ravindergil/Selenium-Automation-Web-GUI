package AssignmentTasks;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TestNG_TestCase1 {
	
	public WebDriver driver;
	public String driverLocation = "C:\\Users\\IBM_ADMIN\\Desktop\\Drivers\\chromedriver.exe";
 
  @BeforeTest
  public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", driverLocation);
		driver = new ChromeDriver();
		driver.navigate().to("http://www.phptravels.net");
		driver.manage().window().maximize();
		System.out.println("Browser launched");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	
  @Test
  public void MainCode() throws InterruptedException {
	  
	  	Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[3]/div/div/div[2]/ul/ul/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[3]/div/div/div[2]/ul/ul/li[1]/ul/li[2]/a")).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.name("firstname")).sendKeys("ABCD");
		driver.findElement(By.name("lastname")).sendKeys("XYZ");
		driver.findElement(By.name("phone")).sendKeys("9182736450");
		driver.findElement(By.name("email")).sendKeys("abcd_xyz@eg0hi.com");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		driver.findElement(By.name("confirmpassword")).sendKeys("Test@123");
		driver.findElement(By.xpath("html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();
		System.out.println("Sign-Up Successfully");
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/nav[1]/div/div/div/ul/li[2]/a")).click(); //Click Hotels tab
		
		// Modify Search
		// Filter Code - Search For 3 Star Hotel
		driver.findElement(By.xpath("html/body/div[4]/div[3]/div/div/div[4]/div/a")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='rating']/div[5]/div")));
		driver.findElement(By.xpath("//div[@class='rating']/div[5]/div")).click();
		driver.findElement(By.id("searchform")).click();
		System.out.println("Data Filered according to 3 starts Rating");
				
		// Click Modify Option
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-xs btn-block']")).click(); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[4]/div[5]/div[1]/div/form/div[1]/div/div[2]/a/span[1]")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[11]/div/input")));
						
		// Enter Destination
		driver.findElement(By.xpath("html/body/div[11]/div/input")).sendKeys("Singapore");        
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[11]/ul/li/ul/li/div/span")));
		driver.findElement(By.xpath("html/body/div[11]/ul/li/ul/li/div/span")).click();
				
		// Enter Check In Date
		Thread.sleep(2000);																		
		driver.findElement(By.name("checkin")).click();
		System.out.println("Check In button clicked");										// Enter Check In Date
		WebElement WE = driver.findElement(By.xpath("html/body/div[8]/div[1]/table/thead/tr[1]/th[2]"));
		System.out.println(WE.getText());
		String name = "February 2018";
		
		if(WE.getText().equals(name)) {
			System.out.println("Match Found");
			driver.findElement(By.xpath("html/body/div[8]/div[1]/table/tbody//td[text()='23']")).click();
		}else {
			System.out.println(WE.getText() + " is not matched So clicking on next button");
			driver.findElement(By.className("next")).click();
		}
		if(WE.getText().equals(name)) {
			System.out.println("Match Found");
			driver.findElement(By.xpath("html/body/div[8]/div[1]/table/tbody//td[text()='23']")).click();
		}else {
			System.out.println(WE.getText() + " is not matched So clicking on next button");
			driver.findElement(By.className("next")).click();
		}
		if(WE.getText().equals(name)) {
			System.out.println("Match Found");
			driver.findElement(By.xpath("html/body/div[8]/div[1]/table/tbody//td[text()='23']")).click();
		}else {
			System.out.println(WE.getText() + " is not matched So clicking on next button");
			driver.findElement(By.className("next")).click();
		}
		
		// Enter Check Out Date
		System.out.println("Checking Out");														
		String name1 = "March 2018";
		driver.findElement(By.xpath("html/body/div[9]/div[1]/table/thead/tr[1]/th[3]")).click();
		WebElement WE1 = driver.findElement(By.xpath("html/body/div[9]/div[1]/table/thead/tr[1]/th[2]"));
		
		if(WE1.getText().equals(name1)) {
			System.out.println("Match Found : " + WE1.getText());
			driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody//td[text()='2']")).click();
		}else {
			System.out.println(WE.getText() + " is not matched So clicking on next button");
			driver.findElement(By.xpath("html/body/div[9]/div[1]/table/thead/tr[1]/th[3]")).click();
		}
		
		// Count travelers
		driver.findElement(By.name("travellers")).click();
		WebDriverWait wait11 = new WebDriverWait(driver, 5);
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.name("adults")));
		WebElement WE3 = driver.findElement(By.name("adults"));
		Select sel1 = new Select(WE3);
		sel1.selectByValue("2");
		
		WebElement WE4 = driver.findElement(By.name("child"));
		Select sel2 = new Select(WE4);
		sel2.selectByValue("3");
		
		WebElement WE5 = driver.findElement(By.name("infant"));
		Select sel3 = new Select(WE5);
		sel3.selectByValue("1");
		driver.findElement(By.id("sumPassenger")).click();
		
		System.out.println("No of Travellers entered");
		
		//Click Search Button <<--->>
		Thread.sleep(2000);
		WebElement WE6 = driver.findElement(By.xpath("//button[@type='submit']/i"));
		Actions action = new Actions(driver);
		action.moveToElement(WE6).build().perform();
		WE6.click();
		
		System.out.println("Search Based on Selected criteria is completed");
			
		// Select Hotel and Check Out
		driver.findElement(By.xpath("html/body/div[4]/div[7]/div[2]/div/table/tbody/tr[1]/td/div[2]/div/h4/a/b")).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement WE7 = driver.findElement(By.xpath("html/body/div[5]/section/div/table/tbody/tr[2]/td/div[2]/div/div[5]/div[3]/button"));
		action.moveToElement(WE7).build().perform();
		Thread.sleep(2000);
		WE7.click();
		System.out.println("Book Now clicked");
		
		//Confirm This Booking
		Thread.sleep(5000);
		WebElement WE8 = driver.findElement(By.xpath("html/body/div[4]/div[2]/div[1]/div/div/div[4]/button"));
		action.moveToElement(WE8).build().perform();
		Thread.sleep(2000);
		WE8.click();
		
		System.out.println("Invoice Created");	
		
		//pay on arrival
		driver.findElement(By.xpath("html/body/div[4]/div[1]/div/div[3]/center/button[1]")).click();
		driver.switchTo().alert().accept();
  }
	  
	
  @AfterTest
  public void afterTest() {
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	  driver.close();
	  System.out.println("BrowserClosed");
  }

}
