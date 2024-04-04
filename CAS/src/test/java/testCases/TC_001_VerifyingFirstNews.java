package testCases;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
//import java.awt.Desktop.Action;
//import java.net.HttpURLConnection;
//import java.net.URL;
import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.mainPage;
import testBase.baseclass;
import utilities.WriteExcelData;

public class TC_001_VerifyingFirstNews extends baseclass
{	
	private mainPage obj;
	private baseclass baseobj;
	public List<String> excelData = new ArrayList<String>();
	
	
	@BeforeClass
	public void pageSetup()
	{
		obj= new mainPage(driver);
		baseobj=new baseclass();
	}
	
	//capture the user information.
		@Test(priority=1)
		void UserInfo() throws InterruptedException
		{
		    logger.info("Starting the Test Case");
			Thread.sleep(8000);
			Actions act = new Actions(driver);
			WebElement ele = obj.userInfoIcon;
		    logger.info("Clicking on User Info Icon");
			act.moveToElement(ele).click().build().perform();
	       //Extract User details
	       String userName = obj.userInfoName.getText();
	       String userMailId = obj.userInfoMail.getText();
		   logger.info("Printing the Info to Console");
	     System.out.println("User Details : ");
	     System.out.println("Name of User : "+ userName);
	     System.out.println("Email ID of User : "+userMailId);
	     System.out.println("----------------------------------------------------------------");
	     System.out.println();
		    logger.info("Finishing the Test Case");
		}

	@Test(priority=2)
	public void isVisisble()
	{
		logger.info("Starting the Test Case");
		WebElement allNews = obj.newAll;
logger.info("Validating the News Displayed");
		Assert.assertEquals(true, allNews.isDisplayed());
		logger.info("Finishing the Test Case");
	}
	
	@Test(priority=3)
	void validateTitle() throws InterruptedException 
	{
		logger.info("Starting the Test Case");
		WebElement header1 = obj.tiptop1;
		  String h1= header1.getText();
		  Thread.sleep(500);
		  excelData.add(h1);
		  String t1 = header1.getAttribute("title");
		  logger.info("Validating the TipTop Displayed");
		  Assert.assertEquals(h1, t1);
		  logger.info("Finishing the Test Case");
	}
	
	@Test(priority=4)
	public void description() 
	{
		logger.info("Starting the Test Case");
		logger.info("Clicking on News");
		obj.newsno1.click();
	
		WebElement nt1 = obj.newstitle;
		String NewsTitle1 = nt1.getText();
		System.out.println("Title of News Number 1 :" + NewsTitle1);
		logger.info("Printing the Info to Console");
		
		WebElement nb1 = obj.authorname;
		String NewsBy1 = nb1.getText();
	    System.out.println("News Author :" + NewsBy1);
	    logger.info("Printing the Info to Console");
	    
	    WebElement nd1 = obj.data;
		String NewsDescription1 = nd1.getText();
		System.out.println("News Description :" + NewsDescription1);
		System.out.println("----------------------------------------------------------------");
		System.out.println();
		logger.info("Printing the Info to Console");
		logger.info("Finishing the Test Case");
		excelData.add(NewsBy1);
		excelData.add(NewsDescription1);
	}
	
	@Test(priority=5)
	void validateAuthor() throws InterruptedException, IOException
	{
		logger.info("Starting the Test Case");
		Actions act1 = new Actions(driver);
		WebElement i = obj.authoR;
		baseobj.captureScreen("firstNews");
		logger.info("Clicking on Associate Info Icon");
		act1.moveToElement(i).click().build().perform();
       String userN = obj.authorsName.getText();
       String userR = obj.authorsRole.getText();
       Thread.sleep(5000);
       logger.info("Printing the Info to Console");
     System.out.println("Associate Details : ");
     System.out.println("Name of Associate : "+ userN);
     System.out.println("Role of Associate : "+userR);
     System.out.println("----------------------------------------------------------------");
     System.out.println();
     logger.info("Finishing the Test Case");
	}
	
	@Test(priority=6)
	public void shareButton() throws InterruptedException
	{
		logger.info("Starting the Test Case");
		System.out.println("Options displayed in share button : ");
		logger.info("Clicking on Share Button");
		  if(obj.shareicon.isDisplayed())
			excelData.add("passed");
		  else
			excelData.add("failed");
		    obj.shareicon.click();
		    String sn1 = obj.sn1.getText();
		    logger.info("Printing the Info to Console");
		    System.out.println(sn1);
		    String sn2 = obj.sn2.getText();
		    System.out.println(sn2);
		    String sn3 =obj.sn3.getText();
		    System.out.println(sn3);
		    System.out.println("----------------------------------------------------------------");
	        System.out.println();
	        logger.info("Finishing the Test Case");
	  
	}
	
	
	@Test(priority=7)
	public void likesNviews() throws InterruptedException
	{
		
		logger.info("Starting the Test Case");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",obj.scroll);
        Thread.sleep(3000);
	    List<WebElement> s = obj.lNV;
	    logger.info("Validating the Views & Likes");
	    System.out.println("Likes and Views : ");
	    logger.info("Printing the Info to Console");
	    for(int j=0; j<s.size(); j++) {
	    	excelData.add(s.get(j).getText().split(" ")[0]);
	    	System.out.println(s.get(j).getText());
	    }
	    System.out.println("----------------------------------------------------------------");
            System.out.println();
            logger.info("Finishing the Test Case");
	}
	

	@Test(priority=8)
	public void validateLinks() {
		logger.info("Starting the Test Case");
		 int validLinks = 0;
	     int brokenLinks = 0;
		  List<WebElement> links1 = driver.findElements(By.tagName("a"));
		  System.out.println("Total number of links:"+links1.size());
		  logger.info("Validating the Links");
	      for (WebElement link : links1) {
	          String url = link.getAttribute("href");

	          try {
	        	  HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                  conn.setRequestMethod("HEAD");
                  conn.connect();
                  int respCode = conn.getResponseCode();

                  if (respCode >= 400) {
                      brokenLinks++;
                  } else {
                      validLinks++;
                  }
	          } catch (Exception e) {
                  brokenLinks++;
	          }
	}
	      System.out.println("Valid links & Broken links : ");
	      System.out.println("Total valid links: " + validLinks);
          System.out.println("Total broken links: " + brokenLinks);
          System.out.println("==============================================================================================");
          System.out.println();
          driver.navigate().back();
          logger.info("Finishing the Test Case");
          if(links1.size()>0)
		  {
			  excelData.add("passed");
		  }
		  else
		  {
			  excelData.add("failed");
		  }
	}
	@Test(priority = 10)
	public void writeExcelData() throws IOException
	{
		WriteExcelData.writeData(excelData, 1);
	}
	
	
}
