package Srilatha.SeleniumFrameworkDesign;

import java.util.List;

//import org.junit.Assert;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Srilatha.SeleniumFrameworkDesign.AbtractComponent.AbtractComponent;

public class cartPage extends AbtractComponent {

	@FindBy(css=".cartSection h3")
	List <WebElement> productTitiles;
	@FindBy(css=".totalRow button")
	 WebElement checkoutelement;
	WebDriver driver;
	public cartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public boolean productDisplay(String ProductName)
	{
		boolean match=productTitiles.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	public CheckoutPage checkOut()
	{
		checkoutelement.click();
		return new CheckoutPage(driver);
	}
}
