package Srilatha.SeleniumFrameworkDesign.TestComponents;

import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Srilatha.SeleniumFrameworkDesign.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class baseTest {

	public WebDriver driver;
	public LandingPage page;
	public WebDriver intializeDriver() throws IOException
	{
		//properties class
		
		Properties props= new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\SeleniumFrameworkDesign\\resources\\GlobalData.properties");
		props.load(fis);
		String browserName= props.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	public List<HashMap<String,String>> getJsonDataToMap(String Filepath) throws IOException
	{
		//read json to string
		String jsonContent=FileUtils.readFileToString(new File(Filepath),StandardCharsets.UTF_8);
	//string to HashMap Jackson Databind
		
		ObjectMapper mapper=new ObjectMapper();
		
		List<HashMap<String,String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>()
		{
		});	
		{
			
	return data;
		
	}
		
		}
	 public String getScreenshot(String testcasename,WebDriver driver) throws IOException
	  {
		  TakesScreenshot ts=  (TakesScreenshot)driver;
		 File source= ts.getScreenshotAs(OutputType.FILE);
		 File file=new File(System.getProperty("user.dir")+"//reports//" + testcasename +".png");
		  FileUtils.copyFile(source, file);
		  return System.getProperty("user.dir")+"//reports//" + testcasename +".png";
		  
	  }
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	{
		driver=intializeDriver();	
		 page=new LandingPage(driver);
		page.goTo();
		return page;
	}
	
	/*@AfterMethod(alwaysRun=true)
	
	public void tearDown()
	{
		driver.close();
	} */
}
