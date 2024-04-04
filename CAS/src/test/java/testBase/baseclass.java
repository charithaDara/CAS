package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j

public class baseclass 
{
//  public String url="https://be.cognizant.com";
  public static WebDriver driver;
  public Logger logger;
  static Properties p= new Properties();
    
  @Parameters({"browser"})
  @BeforeClass
  public void setup(String br)
  {
	  try {
			FileReader file = new FileReader(".//src/test/resources/config.properties");
			
			p.load(file);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	
	  logger=LogManager.getLogger(this.getClass());
	  if(br.equalsIgnoreCase("chrome")) {
		  driver=new ChromeDriver();
		  
	  }
	  else if(br.equalsIgnoreCase("edge")) {
		  driver=new EdgeDriver();
		  
	  }
	  //ActionsToPerform.setDriver(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	  driver.manage().deleteAllCookies();
  }
  
  
//Navigate to Be. Cognizant 
	@Test(priority=0)
	public void Launch() 
	{
	    logger.info("Launching the Browser");
//	    driver.get(url);
		driver.get(p.getProperty("appurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
  @AfterClass
  public void teardown()
  {
	    logger.info("Closing the Browser");
	  driver.quit();
  }
  
  public  String captureScreen(String tname) throws IOException {
	  
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;

	}
}
