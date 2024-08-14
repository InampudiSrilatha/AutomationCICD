package Srilatha.SeleniumFrameworkDesign.Tests;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.*;

import Srilatha.SeleniumFrameworkDesign.CheckoutPage;
import Srilatha.SeleniumFrameworkDesign.LandingPage;
import Srilatha.SeleniumFrameworkDesign.ProductCatalouge;
import Srilatha.SeleniumFrameworkDesign.cartPage;
import Srilatha.SeleniumFrameworkDesign.coformationPage;
import Srilatha.SeleniumFrameworkDesign.TestComponents.baseTest;


public class SubmitOrderTest extends baseTest{
	String ProductName="ZARA COAT 3";
	
  @Test(dataProvider="getData",groups= {"purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException
	{
		// TODO Auto-generated method stub
		
		
LandingPage page=launchApplication();

ProductCatalouge productccatalouge =page.loginApplication(input.get("email"),input.get("pwd"));
productccatalouge.getProductList();
productccatalouge.addToCart(input.get("productname"));

cartPage cartpage=productccatalouge.goToCart();
boolean match =cartpage.productDisplay(input.get("productname"));
Assert.assertTrue(match);

CheckoutPage checkoutpage=cartpage.checkOut();
checkoutpage.selectCountry("india");

coformationPage conformation=checkoutpage.submitOrder();
String conformationmsg=conformation.getConformationmsg();
Assert.assertTrue(conformationmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
}
  
  //@Test(dependsOnMethods={"submitOrder"})
 /* @Test(dependsOnMethods= {"submitOrder"})
  public void orderHistory()
  {
	  ProductCatalouge productccatalouge =page.loginApplication("srilatha.i@gmail.com", "Fjot&023");
	  orderPage orderpage= productccatalouge.goToOrderPage();
	 Assert.assertTrue(orderpage.orderDisplay(ProductName));
  } */
  
 
  
  @DataProvider
  
  public Object[][] getData() throws IOException
  {
	/*  HashMap<String,String> map = new HashMap<String,String>();
	  map.put("email", "srilatha.i@gmail.com");
	  map.put("pwd", "Fjot&023");
	  map.put("productname", "ZARA COAT 3");
	  
	  HashMap<String,String> map1 = new HashMap<String,String>();
	  map1.put("email", "sriraghava.m@gmail.com");
	  map1.put("pwd", "Fjot&023");
	  map1.put("productname", "ADIDAS ORIGINAL"); */
	List<HashMap<String,String>>  data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\SeleniumFrameworkDesign\\data\\PurchaseOrder.json"); 
  return new Object[][] {{data.get(0)},{data.get(1)}};
  }


  

}
