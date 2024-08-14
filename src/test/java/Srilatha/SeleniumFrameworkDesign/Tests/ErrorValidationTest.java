package Srilatha.SeleniumFrameworkDesign.Tests;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Srilatha.SeleniumFrameworkDesign.CheckoutPage;
import Srilatha.SeleniumFrameworkDesign.LandingPage;
import Srilatha.SeleniumFrameworkDesign.ProductCatalouge;
import Srilatha.SeleniumFrameworkDesign.cartPage;
import Srilatha.SeleniumFrameworkDesign.coformationPage;
import Srilatha.SeleniumFrameworkDesign.TestComponents.baseTest;


public class ErrorValidationTest extends baseTest{
	
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Srilatha.SeleniumFrameworkDesign.TestComponents.Retry.class)
	public void loginErrorValidation() throws IOException
	{
		// TODO Auto-generated method stub
		String ProductName="ZARA COAT 3";
		
		


page.loginApplication("srilatha.i@gmail.com", "Fjot&0234");
Assert.assertEquals("Incorrect email  password.", page.getErrorMessage());
	}

@Test
	public void productErrorValidation() throws IOException
	{
		// TODO Auto-generated method stub
		String ProductName="ZARA COAT 3";
		
//LandingPage page=launchApplication();

ProductCatalouge productccatalouge =page.loginApplication("srilatha.i@gmail.com", "Fjot&023");
List<WebElement> products =productccatalouge.getProductList();
productccatalouge.addToCart(ProductName);

cartPage cartpage=productccatalouge.goToCart();
boolean match =cartpage.productDisplay("ZARA COAT 3");
Assert.assertTrue(match);
























	}

}
