package Srilatha.SeleniumFrameworkDesign;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Srilatha.SeleniumFrameworkDesign.AbtractComponent.AbtractComponent;

public class coformationPage extends AbtractComponent{
WebDriver driver;
	public coformationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".hero-primary")
	WebElement conformation;
	public String getConformationmsg() {
		 return conformation.getText();
}
}
