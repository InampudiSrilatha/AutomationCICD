package Srilatha.SeleniumFrameworkDesign;

import java.util.List;

//import org.junit.Assert;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Srilatha.SeleniumFrameworkDesign.AbtractComponent.AbtractComponent;

public class orderPage extends AbtractComponent {

	@FindBy(css="tr td:nth-child(3)")
	List <WebElement> productNames;
	@FindBy(css=".totalRow button")
	 WebElement checkoutelement;
	WebDriver driver;
	public orderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public boolean orderDisplay(String ProductName)
	{
		boolean match=productNames.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	
}
