package Srilatha.SeleniumFrameworkDesign.AbtractComponent;

import java.time.Duration;
//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Srilatha.SeleniumFrameworkDesign.cartPage;

//import Srilatha.SeleniumFrameworkDesign.cartPage;

public class AbtractComponent {
	WebDriver driver;
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	
	public AbtractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public void waitElemntToAppear(By FindBy)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
}
	public void waitElementToDisappear(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public void waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public  cartPage goToCart()
	{
		cartHeader.click();
		cartPage cartpage = new cartPage(driver);
		return cartpage;
	}
	public  orderPage goToOrderPage()
	{
		orderHeader.click();
		orderPage orderpage = new orderPage(driver);
		return orderpage;
	}
	
}
