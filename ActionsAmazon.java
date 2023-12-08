package week4.Assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import week4.day2.Action;

public class ActionsAmazon {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.get("https://www.amazon.in/");
    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
    driver.findElement(By.xpath("(//div[text()='oneplus 9 pro'])[1]")).click();
    String text = driver.findElement(By.xpath("//span[text()='31,489']")).getText();
    System.out.println("the price of the first product : "+text);
    Actions ac =new Actions(driver);
    ac.click(driver.findElement(By.xpath("//span[text()='2.8 out of 5 stars']/.."))).perform();
    String text2 = driver.findElement(By.xpath("(//span[text()='2.8 out of 5'])[2]")).getText();
    System.out.println("Customer Rating :"+text2);
    driver.findElement(By.xpath("//span[text()='(Refurbished) OnePlus 9 Pro 5G (Morning Mist, 8GB RAM, 128GB Storage)']")).click();
    Set<String> wh = driver.getWindowHandles();
    List<String> wh1=new ArrayList<String>(wh);
    driver.switchTo().window(wh1.get(1));
    ac.scrollToElement(driver.findElement(By.xpath("//h1[text()=' About this item ']"))).perform();
    File scr = driver.getScreenshotAs(OutputType.FILE);
    File des=new File("./snap/snap2.png");
    FileUtils.copyFile(scr, des);
    driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
    String text3 = driver.findElement(By.xpath("(//span[text()='₹31,489.00'])[5]")).getText();
    System.out.println("Cart SubTotal :"+text3);
    driver.close();
	}

}

