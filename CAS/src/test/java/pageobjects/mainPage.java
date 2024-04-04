package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.baseclass;

public class mainPage extends baseclass
{
	
	public mainPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
  
  //news links
  @FindBy(xpath="//*[@id='vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf']/div/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div[2]")
  public WebElement newsno1;
  
  @FindBy(xpath="//*[@id='vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf']/div/div/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div[2]")
  public WebElement newsno2;
  
  @FindBy(xpath="//*[@id='vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf']/div/div/div/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]")
  public WebElement newsno3;
  
  @FindBy(xpath="//*[@id='vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf']/div/div/div/div[2]/div/div/div/div/div/div[4]/div/div/div/div[2]")
  public WebElement newsno4;
  
  @FindBy(xpath="//*[@id='vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf']/div/div/div/div[2]/div/div/div/div/div/div[5]/div/div/div/div[2]")
  public WebElement newsno5;
  
  //TipTop
  @FindBy(xpath="//*[@id='vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf']/div/div/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div/div[2]/div/a")
  public WebElement tiptop1;
  
  @FindBy(xpath="//*[@id='vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf']/div/div/div/div[2]/div/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/a")
  public WebElement tiptop2;
  
  @FindBy(xpath="//*[@id='vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf']/div/div/div/div[2]/div/div/div/div/div/div[3]/div/div[1]/div/div[2]/div/a")
  public WebElement tiptop3;
  
  @FindBy(xpath="//*[@id='vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf']/div/div/div/div[2]/div/div/div/div/div/div[4]/div/div[1]/div/div[2]/div/a")
  public WebElement tiptop4;
  @FindBy(xpath="//*[@id='vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf']/div/div/div/div[2]/div/div/div/div/div/div[5]/div/div[1]/div/div[2]/div/a")
  public WebElement tiptop5;
  
  //user info links
  @FindBy(xpath="//*[@id='O365_MainLink_MePhoto']/div/div/div/div/div[2]")
  public WebElement userInfoIcon;
  
  @FindBy(id="mectrl_currentAccount_primary")
  public WebElement userInfoName;
  
  @FindBy(id="mectrl_currentAccount_secondary")
  public WebElement userInfoMail;
  
  //displayed news link
  @FindBy(xpath="//*[@id='4f7e87d5-f184-4501-8008-0ee4b0a38fcf']")
  public WebElement newAll;
  
  //description links
  @FindBy(xpath="//*[@id='title_text']")
  public WebElement newstitle;
  @FindBy(xpath="//*[@id='vpc_WebPart.PageTitle.internal.cbe7b0a9-3504-44dd-a3a3-0e5cacd07788']/div/div[1]/div/div/div[2]/div/div/div/div[2]/div[1]")
  public WebElement authorname;
  @FindBy(xpath="//*[@id='spPageCanvasContent']/div/div/div/div/div/div[1]/div/div[1]/div[2]")
  public WebElement data;
  @FindBy(xpath="//*[@id='c6c4fb50-d4a7-4791-81f8-a4f069ac45f3']/div/div/div")
  public WebElement data2;
  
  //shareButton
  @FindBy(xpath="//*[@id='spCommandBar']/div/div/div/div/div/div[2]/div[1]/button")
  public WebElement shareicon;
//  
  @FindBy(xpath="//button[@name='Share page']/div/div/span")
  public WebElement sn1;
  @FindBy(xpath="//button[@name='Copy link to page']/div/div/span")
  public WebElement sn2;
  @FindBy(xpath="//*[text()='Send to email']")
  public WebElement sn3;
  
  //likeNviews
  public @FindBy(id="vpc_Page.CommentsWrapper.internal.2610b4b4-550c-4548-b431-aa3ab709c184")
	WebElement scroll;
  @FindBy(xpath="//*[@id='vpc_Page.CommentsWrapper.internal.2610b4b4-550c-4548-b431-aa3ab709c184']/div/div/aside/div/button/span/span/span")
  public List<WebElement> lNV;


  
  public @FindBy(xpath="//*[@id='vpc_WebPart.PageTitle.internal.cbe7b0a9-3504-44dd-a3a3-0e5cacd07788']/div/div[1]/div/div/div[2]/div/div/div")
  WebElement authoR;
  public @FindBy(xpath="//*[@id='LPCPseudoTabbableElement']/div[1]/section/div[1]/div/div[1]/h1")
  WebElement authorsName;
  public @FindBy(xpath="//*[@id='LPCPseudoTabbableElement']/div[1]/section/div[1]/div/div[2]")
  WebElement authorsRole;

}
