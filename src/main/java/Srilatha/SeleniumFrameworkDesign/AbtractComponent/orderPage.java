package Srilatha.SeleniumFrameworkDesign.AbtractComponent;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Srilatha.SeleniumFrameworkDesign.cartPage;

public class orderPage extends cartPage {


	@FindBy(css = "tr td:nth-child(3)")
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
