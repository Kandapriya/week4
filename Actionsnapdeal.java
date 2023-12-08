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

import io.cucumber.java.en_old.Ac;

public class Actionsnapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		driver.findElement(By.xpath("(//span[@class='catText'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		String text = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("the count of sports shoes :"+text);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
		String text2 = driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).getText();
		System.out.println(text2);
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("(//img[@class='product-image wooble'])[4]"))).perform();
		driver.findElement(By.xpath("(//input[@class='input-filter'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@class='input-filter'])[1]")).sendKeys("500");
		driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).sendKeys("700");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		//Actions ac2 =new Actions(driver); 
		WebElement scroll = driver.findElement(By.xpath("//p[text()='Combit Navy Training Shoes']"));
		ac.moveToElement(scroll).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='Color_s-White%20%26%20Blue']")).click();
		String text3 = driver.findElement(By.xpath("(//div[@class='filters'])[1]")).getText();
		System.out.println(text3);
		//11. Mouse hover on the first resulting "Training Shoes".
		Thread.sleep(3000);
		WebElement mo = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
		ac.moveToElement(mo).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='clearfix row-disc'])[1]")).click();
		Thread.sleep(3000);
		//Set<String> wh = driver.getWindowHandles();
		//List<String> wh1=new ArrayList<String>(wh);
		//driver.switchTo().window(wh1.get(1));
		//Thread.sleep(3000);
		String text4 = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']")).getText();
		System.out.println("the cost and the discount percentage: "+text4);
		Thread.sleep(3000);
		File scr=driver.getScreenshotAs(OutputType.FILE);
		File des=new File("./snap/snap3.png");
		FileUtils.copyFile(scr, des);
		
		Thread.sleep(3000);
		driver.close();
		

	}

}
