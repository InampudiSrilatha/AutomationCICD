package Srilatha.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;

import Srilatha.SeleniumFrameworkDesign.AbtractComponent.AbtractComponent;

public class CheckoutPage extends AbtractComponent{
WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
	@FindBy(css=".action__submit")
	WebElement submit;
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	@FindBy(css = ".ta-item:nth-last-child(1)")
	private WebElement selectindia;
	By testresults =(By.cssSelector(".ta-results"));
	
	public void selectCountry(String countryName)
	{
		Actions a =new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitElemntToAppear(testresults);
		
		
		selectindia.click();
	}
	public coformationPage submitOrder()
	{
		submit.click();
		return new coformationPage(driver);
	}
}
