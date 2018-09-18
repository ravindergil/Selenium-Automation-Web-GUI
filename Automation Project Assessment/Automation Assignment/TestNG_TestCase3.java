package AssignmentTasks;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class TestNG_TestCase3 {
	
	public WebDriver driver;
	public String driverLocation = "C:\\Users\\IBM_ADMIN\\Desktop\\Drivers\\chromedriver.exe";
	
  @BeforeTest
  public void LaunchBrowser() {
	  System.setProperty("webdriver.chrome.driver", driverLocation);
		driver = new ChromeDriver();
		driver.navigate().to("http://demo.zurmo.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Browser Launced Successfully");
  }
	
  @Test(priority=0)
  public void MainCode() throws InterruptedException {
	  	driver.findElement(By.id("LoginForm_username")).sendKeys("super");
		driver.findElement(By.id("LoginForm_password")).sendKeys("super");
		driver.findElement(By.className("z-label")).click();
		System.out.println("Sign In Successful");
		
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("unexpected alert not present");
		}
		
		WebElement WE = driver.findElement(By.xpath("html/body/header/div/div[2]/ul[3]/li/a/span"));
		Actions action = new Actions(driver);
		action.moveToElement(WE).build().perform();
		driver.findElement(By.xpath("html/body/header/div/div[2]/ul[3]/li/ul/li[1]/a/span")).click();
		
		driver.findElement(By.id("Account_name")).sendKeys("Testing");
		driver.findElement(By.id("Account_officePhone")).sendKeys("98712356047");
		WebElement WE2 = driver.findElement(By.id("Account_industry_value"));
		
		Select select = new Select(WE2);
		select.selectByValue("Energy");
			
		driver.findElement(By.id("Account_officeFax")).sendKeys("020-2837391");
		driver.findElement(By.id("Account_employees")).sendKeys("120");
		driver.findElement(By.id("Account_annualRevenue")).sendKeys("62729901.00");
		
		WebElement WE3 = driver.findElement(By.id("Account_type_value"));
		Select select1 = new Select(WE3);
		select1.selectByVisibleText("Vendor");
		
		driver.findElement(By.name("Account[website]")).sendKeys("www.abcd.com");
		driver.findElement(By.name("Account[billingAddress][street1]")).sendKeys("Amanora Town");
		driver.findElement(By.name("Account[billingAddress][city]")).sendKeys("Pune");
		driver.findElement(By.name("Account[billingAddress][state]")).sendKeys("Maharshtra");
		driver.findElement(By.name("Account[billingAddress][postalCode]")).sendKeys("412038");
		driver.findElement(By.name("Account[billingAddress][country]")).sendKeys("India");
		driver.findElement(By.name("Account[shippingAddress][street1]")).sendKeys("Andheri East");
		driver.findElement(By.name("Account[shippingAddress][street2]")).sendKeys("NA");
		driver.findElement(By.name("Account[shippingAddress][city]")).sendKeys("Mumbai");
		driver.findElement(By.name("Account[shippingAddress][state]")).sendKeys("Maharashtra"); 
		driver.findElement(By.name("Account[shippingAddress][postalCode]")).sendKeys("471638"); 
		driver.findElement(By.name("Account[shippingAddress][country]")).sendKeys("India"); 
		driver.findElement(By.name("Account[description]")).sendKeys("This an demo description message for demo customer with demo data"); 
		
		driver.findElement(By.className("z-label")).click();
		System.out.println("Form Saved Successfully");
  }
 
 
  @Test(priority=1, enabled=true)
  public void EditInfo() throws InterruptedException {
	  
	   	driver.findElement(By.xpath("html/body/section/nav/div[1]/ul/li[3]/a/span")).click();
		System.out.println("Click on Accounts");
		driver.findElement(By.id("AccountsSearchForm_anyMixedAttributes")).sendKeys("testing");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("html/body/section/div[1]/div[3]/div/div[2]/table/tbody/tr/td[3]/a")).click();
		Thread.sleep(5000);
		
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("unexpected alert not present");
		}
		
		Actions action = new Actions(driver);
		WebElement WE = driver.findElement(By.xpath("html/body/section/div[1]/div[2]/div[2]/div/ul[1]/li[1]/div[1]/div/div/div/ul/li/a/span"));
		action.moveToElement(WE).build().perform();
		driver.findElement(By.xpath("html/body/section/div[1]/div[2]/div[2]/div/ul[1]/li[1]/div[1]/div/div/div/ul/li/ul/li[1]/a")).click();
		
		driver.findElement(By.id("Account_officePhone")).clear();
		driver.findElement(By.id("Account_officePhone")).sendKeys("0123456789");
		driver.findElement(By.className("z-label")).click();
		
		System.out.println("Form Modified Successfully");
  }
  
  @Test(priority=2, enabled=true)
  public void DeleteInfo() {
	  Actions action = new Actions(driver);
	  WebElement WE = driver.findElement(By.xpath("html/body/section/div[1]/div[2]/div[2]/div/ul[1]/li[1]/div[1]/div/div/div/ul/li/a/span"));
	  action.moveToElement(WE).build().perform();
	  driver.findElement(By.xpath("//li[@class='last']/a//span[text()='Delete']")).click();
	  driver.switchTo().alert().accept();
	  System.out.println("Entry Deleted Successfully");
  }

  
  @AfterTest
  public void afterTest() {
	  driver.findElement(By.xpath("html/body/header/div/div[2]/ul[2]/li/a")).click();
	  driver.findElement(By.xpath("html/body/header/div/div[2]/ul[2]/li/ul/li[4]/a")).click();
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	  driver.close();
	  System.out.println("BrowserClosed");
  }

}
