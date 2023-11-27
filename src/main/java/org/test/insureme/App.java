package org.test.insureme;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * Hello world!
 *
 */  
public class App 
{
    private static Object srcFile;
	private static Object destFile;

	public static void main( String[] args ) throws IOException
    {
    	System.out.println("script Started");
   //initializing the web driver
    	//System.setProperty("webdriver.chrome.driver ","C:\\Users\\vedprakash\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
    	WebDriverManager.chromedriver().setup();
    	//setting properties
    	ChromeOptions chromeOptions= new ChromeOptions();
    	chromeOptions.addArguments("--headless");
		
    	//open url
    	System.out.println("Driver Opening the url in browser ");
    	WebDriver driver =new ChromeDriver(chromeOptions);
    	driver.get("http://13.208.211.210:8084/contact.html");
    	//involve implicit waits to load the page
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	System.out.println("Enter Details");
    	//enter details
    	//inputName
    	driver.findElement(By.id("inputName")).sendKeys("ved");
    	//inputNumber
    	driver.findElement(By.id("inputNumber")).sendKeys("9999999999");
    	//inputMail
    	driver.findElement(By.id("inputMail")).sendKeys("ved@xyz.com");
    	//input message
    	driver.findElement(By.id("inputMessage")).sendKeys("Hii,I am interrested in insurance");
    	driver.findElement(By.id("my-button")).click();
    	
    	String response = driver.findElement(By.id("response")).getText();
    	System.out.println("saving Details");
    	System.out.println("Test case Execution Completed");
    	
    	TakesScreenshot srcShot = ((TakesScreenshot)driver);
    	File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
    	
    	File destFile = new File("/var/lib/jenkins/workspace/insure-me-test-scripts/test-reports.jpg");
       
    	FileUtils.copyFile(srcFile, destFile);
    	
    	driver.quit();
    }
    
}

