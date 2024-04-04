package testCases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.mainPage;
import testBase.baseclass;
import utilities.WriteExcelData;

public class TC_005_VerifyingFifthNews extends baseclass
{	
	private mainPage obj;
	private baseclass baseobj;

	
	
	@BeforeClass
	public void pageSetup()
	{
		obj= new mainPage(driver);
		baseobj=new baseclass();
	}
	
	//capture the user information.
		@Test(priority=2)
		void UserInfo() throws InterruptedException
		{
			logger.info("Starting the Test Case");
			Thread.sleep(8000);
			Actions act2 = new Actions(driver);
			WebElement ele2 = obj.userInfoIcon;
			logger.info("Clicking on USer Info Icon");
			act2.moveToElement(ele2).click().build().perform();
	       //Extract User details
	       String userName = obj.userInfoName.getText();
	       String userMailId = obj.userInfoMail.getText();
	       logger.info("Printing the Info To Console");
	     System.out.println("User Details : ");
	     System.out.println("Name of User : "+ userName);
	     System.out.println("Email ID of User : "+userMailId);
	     System.out.println("----------------------------------------------------------------");
	     System.out.println();
	     logger.info("Finishing the Test Case");
		}

	@Test(priority=3)
	public void isVisisble()
	{
		logger.info("Starting the Test Case");
		WebElement allNews = obj.newAll;
		 logger.info("Validating the News");
		Assert.assertEquals(true, allNews.isDisplayed());
		logger.info("Finishing the Test Case");
	}
	
	@Test(priority=3)
	void validateTitle() throws InterruptedException 
	{
		logger.info("Starting the Test Case");
		WebElement header2 = obj.tiptop5;
		  String h2= header2.getText();
		  Thread.sleep(500);
		  String t2 = header2.getAttribute("title");
		  logger.info("Validating the TipTop");
		  Assert.assertEquals(h2, t2);
		  logger.info("Finishing the Test Case");
	}
	
	@Test(priority=4)
	public void description() throws InterruptedException 
	{
		logger.info("Starting the Test Case");
		obj.newsno5.click();
	
		logger.info("Clicking on News");
		Thread.sleep(3000);
		WebElement nt1 = obj.newstitle;
		String NewsTitle1 = nt1.getText();
		logger.info("Printing the Info To Console");
		System.out.println("Title of News Number 5 :" + NewsTitle1);
        WebElement nd1 = obj.data2;
		String NewsDescription1 = nd1.getText();
		System.out.println("News Description :" + NewsDescription1);
		System.out.println("----------------------------------------------------------------");
		System.out.println();
		logger.info("Finishing the Test Case");
	}
	
	@Test(priority=5)
	public void shareButton() throws InterruptedException, IOException
	{
		logger.info("Starting the Test Case");
		System.out.println("Options displayed in share button : ");
		logger.info("Clicking on Share Button");
		baseobj.captureScreen("fifthNews");
	    obj.shareicon.click();
	    String sn1 = obj.sn1.getText();
	    logger.info("Printing the Info To Console");
	    System.out.println(sn1);
	    String sn2 = obj.sn2.getText();
	    System.out.println(sn2);
	    String sn3 =obj.sn3.getText();
	    System.out.println(sn3);
	    System.out.println("----------------------------------------------------------------");
        System.out.println();
        logger.info("Finishing the Test Case");
	}
	
	
	@Test(priority=6)
	public void likesNviews() throws InterruptedException
	{
		logger.info("Starting the Test Case");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",obj.scroll);
        Thread.sleep(5000);
	    List<WebElement> s = obj.lNV;
	    logger.info("Validating the Views & Likes");
	    System.out.println("Likes and Views : ");
	    for(int j=0; j<s.size(); j++) {
	    	System.out.println(s.get(j).getText());
	    }
	    System.out.println("----------------------------------------------------------------");
            System.out.println();
            logger.info("Finishing the Test Case");
	}
	

	@Test(priority=7)
	public void validateLinks() {
		logger.info("Starting the Test Case");
		  List<WebElement> links1 = driver.findElements(By.tagName("a"));
		  logger.info("Validating the Links");
		  System.out.println("Total number of links:"+links1.size());
          System.out.println("==============================================================================================");
			driver.navigate().back();
			logger.info("Finishing the Test Case");
	}
}