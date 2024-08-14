package Srilatha.SeleniumFrameworkDesign.StepDefination;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import Srilatha.SeleniumFrameworkDesign.CheckoutPage;
import Srilatha.SeleniumFrameworkDesign.LandingPage;
import Srilatha.SeleniumFrameworkDesign.ProductCatalouge;
import Srilatha.SeleniumFrameworkDesign.cartPage;
import Srilatha.SeleniumFrameworkDesign.coformationPage;
import Srilatha.SeleniumFrameworkDesign.TestComponents.baseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImpl extends baseTest{
	public LandingPage page;
	public ProductCatalouge productccatalouge;
	public coformationPage conformation;
	@Given("i have landed on the Ecommerce page")
	
	public void i_have_landed_on_the_Ecommerce_page() throws IOException
	{
		page =launchApplication();
	}
	
	@Given ("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_password(String username,String password)
	{
		 productccatalouge =page.loginApplication(username,password);
		
	}
	@When("^I add productname (.+) to the cart$")
	public void I_add_productname_to_the_cart(String productname) {
		productccatalouge.getProductList();
		productccatalouge.addToCart(productname);
	}

	@When("^Checkout(.+)$")
	public void Checkout(String productname)
	{
		cartPage cartpage=productccatalouge.goToCart();
		boolean match =cartpage.productDisplay(productname);
		Assert.assertTrue(match);
        CheckoutPage checkoutpage=cartpage.checkOut();
        
		checkoutpage.selectCountry("india");
		 conformation=checkoutpage.submitOrder();
	}
	@Then("{string} is displayed on the conformation page")
	
	public void message_displayed_on_the_conformation_page(String string)
	{
		String conformationmsg=conformation.getConformationmsg();
		Assert.assertTrue(conformationmsg.equalsIgnoreCase(string));
	}
	
	@Then("{string} error message is displayed")
	public void error_message_is_displayed(String errormsg)
	{
		Assert.assertEquals(errormsg, page.getErrorMessage());
	}
	
	
	
	
	
	
}
