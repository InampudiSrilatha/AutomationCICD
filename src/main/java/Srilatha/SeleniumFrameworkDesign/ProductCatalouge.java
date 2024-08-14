package Srilatha.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;

//import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;

import Srilatha.SeleniumFrameworkDesign.AbtractComponent.AbtractComponent;

public class ProductCatalouge extends AbtractComponent{
	WebDriver driver;
	
	public ProductCatalouge(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".mb-3")
	List <WebElement> products;
	By ProductsBy=By.cssSelector(".mb-3");
	By addtocart=By.cssSelector(".card-body button:last-of-type");
	By toastmsg=(By.cssSelector("#toast-container"));
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	public List<WebElement> getProductList()
	{
		waitElemntToAppear(ProductsBy);
		return products;
	}
	
	public WebElement getProductByName(String ProductName)
	{
		WebElement prod=getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		return prod;
	}
	public void addToCart(String ProductName)
	{
		WebElement prod=getProductByName(ProductName);
		prod.findElement(addtocart).click();
		waitElemntToAppear(toastmsg);
		waitElementToDisappear(spinner);
	}
	}
	


