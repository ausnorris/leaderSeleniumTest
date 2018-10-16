package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class leaderTest {
	private WebDriver driver;	
	public String homePage = System.getProperty("homePage");
	public String titleText = System.getProperty("titleText");
	//public String homePage = "http://nota.demolab.com.au";
	//public String titleText = "VCDX Leaderboard";
	
	
  @Test
  public void homePageTest() {
	  	System.out.println("Testing Website: " + homePage);
		driver.get(homePage);  
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains(titleText)); 	
		driver.findElement(By.xpath("//li[3]")).click();
		//driver.findElement(By.xpath("//li[contains(text(),'None')]")).click();
		//driver.findElement(By.cssSelector("li.player.selected > span.name")).click();
	    Integer count = 1000;
	      while( count > 1 ) { 
	          count--;
	          //System.out.print("\n");
	          driver.findElement(By.cssSelector("button.inc")).click();

	      }
		
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  driver = new RemoteWebDriver(new URL("http://10.10.0.102:4444/wd/hub"), new DesiredCapabilities("firefox", "" , Platform.WINDOWS));
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  //System.out.println("closing web page: " + homePage);
	  driver.quit();
  }

}