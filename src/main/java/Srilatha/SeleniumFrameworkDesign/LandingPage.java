package Srilatha.SeleniumFrameworkDesign;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Srilatha.SeleniumFrameworkDesign.AbtractComponent.AbtractComponent;

public class LandingPage extends AbtractComponent {
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement Useremail= driver.findElement(By.id("userEmail"));
	//page factory
	@FindBy(id="userEmail")
	WebElement Useremail;
	@FindBy(id="userPassword")
	WebElement password;
	@FindBy(id="login")
	WebElement submit;
	@FindBy(css="[class*='flyInOut']")
	WebElement ErrorMsg;
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(ErrorMsg);
		return ErrorMsg.getText();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public ProductCatalouge loginApplication(String email,String pwd)
	{
		Useremail.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
		ProductCatalouge productccatalouge = new ProductCatalouge(driver);
		return productccatalouge;
	}


}
