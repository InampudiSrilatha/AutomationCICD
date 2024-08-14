package Srilatha.SeleniumFrameworkDesign.Tests;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import Srilatha.SeleniumFrameworkDesign.LandingPage;

public class StandaloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.manage().window().maximize();
driver.get("https://rahulshettyacademy.com/client/");
driver.findElement(By.id("userEmail")).sendKeys("srilatha.i@gmail.com");
driver.findElement(By.id("userPassword")).sendKeys("Fjot&023");
driver.findElement(By.id("login")).click();
LandingPage page =new LandingPage(driver);
List <WebElement> products =driver.findElements(By.cssSelector(".mb-3"));
WebElement prod=products.stream().filter(product->
product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
List<WebElement> cartproducts =driver.findElements(By.cssSelector(".cartSection h3"));
boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase("ZARA COAT 3"));
Assert.assertTrue(match);
driver.findElement(By.cssSelector(".totalRow button")).click();

Actions a =new Actions(driver);
a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
driver.findElement(By.cssSelector(".ta-item:nth-last-child(1)")).click();
driver.findElement(By.cssSelector(".action__submit")).click();
String cofirmmessage=driver.findElement(By.cssSelector("hero-primary")).getText();
Assert.assertEquals(cofirmmessage, " Thankyou for the order. ");
Assert.assertTrue(cofirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
driver.close();


















	}

}
