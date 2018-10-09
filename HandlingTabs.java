import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingTabs {
	

	WebDriver driver;
	
	public void OpenBrowser() {
		driver = new FirefoxDriver();
		driver.get("http://demo.automationtesting.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Window Opened");
		driver.findElement(By.id("btn2")).click();
		System.out.println("Skip Button Clicked");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul/li[4]/a")));
		act.build().perform();
		WebDriverWait WEWait = new WebDriverWait(driver, 10);
		WEWait.until(ExpectedConditions.elementToBeClickable
				(By.xpath("/html/body/header/nav/div/div[2]/ul/li[4]/ul/li[2]/a")));
		
		driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul/li[4]/ul/li[2]/a")).click();	
		System.out.println("Go to New Tab");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/a/button")).click();
		System.out.println("Click to open new tab");
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    System.out.println(tabs.size());
	    driver.switchTo().window(tabs.get(1));
	    
	    System.out.println(driver.getCurrentUrl());
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.findElement(By.xpath("/html/body/div[5]/header/div/div/div[2]/ul/li[3]/a")).click();
	    
	    driver.switchTo().window(tabs.get(0));
	    driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/a/button")).click();
	    
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\IBM_ADMIN\\Desktop\\Edit\\geckodriver\\geckodriver.exe");	
		TestTwo TT = new TestTwo();
		TT.OpenBrowser();
	}
}
