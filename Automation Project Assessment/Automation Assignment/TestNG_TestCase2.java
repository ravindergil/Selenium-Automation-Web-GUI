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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TestNG_TestCase2 {
	
	public WebDriver driver;
	public String driverLocation = "C:\\Users\\IBM_ADMIN\\Desktop\\Drivers\\chromedriver.exe";
 
  @BeforeTest
  public void LaunchBrowser() {
		  System.setProperty("webdriver.chrome.driver", driverLocation);
			driver = new ChromeDriver();
			driver.navigate().to("http://automationpractice.com/index.php?");
			driver.manage().window().maximize();
			System.out.println("Browser launched");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	
  @Test
  public void MainCode() {
		driver.findElement(By.className("login")).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("ravindergill196@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Test@123");
		driver.findElement(By.id("SubmitLogin")).click();
		System.out.println("Log IN successful");
		
		WebElement WE = driver.findElement(By.xpath("html/body/div[1]/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(WE).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[1]/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[1]/a")));
		driver.findElement(By.xpath("html/body/div[1]/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[1]/a")).click();
		System.out.println("Casual Dresses Selected");
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li/div/div[1]/div/a[1]/img")).click();
		System.out.println("Printed Dress Selected");
		
		//Counting Frames To Switch to frame
		driver.switchTo().frame(0);
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_to_cart")));
		driver.findElement(By.id("add_to_cart")).click();
		System.out.println("Add to Cart Selected");
		driver.switchTo().defaultContent();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement WE1 = driver.findElement(By.xpath("html/body/div[1]/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
		System.out.println(WE1.isEnabled());
		WE1.click();
		System.out.println("Proceed to checkout - 1 Clicked <Summary Page>");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span")));
		WebElement WE2 = driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span"));
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", WE2);
		WE2.click();
		System.out.println("Proceed to checkout - 2 Clicked <Sign In Page>");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[2]/div/div[3]/div/form/p/button")));
		WebElement WE3 = driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[3]/div/form/p/button"));
		WE3.click();
		System.out.println("Proceed to checkout - 3 Clicked <Address page>");
		
		//Check Box Code Here
		driver.findElement(By.id("cgv")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button")));
		WebElement WE4 = driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button"));
		WE4.click();
		System.out.println("Proceed to checkout - 4 Clicked <Shipping Page>");
		
		driver.findElement(By.className("cheque")).click();
		System.out.println("Pay by check - Clicked");
		
	//	WebElement WE5 = driver.findElement(By.className("box cheque-box"));
	//	WE5.getText();
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[3]/div/form/p/button")).click();
		System.out.println("Order Confirmed");
		
		driver.findElement(By.className("logout")).click();
  }
	
	
  @AfterTest
  public void afterTest() {
	  driver.close();
	  System.out.println("BrowserClosed");
  }

}
