package week4.Assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertassginment {
	private static org.openqa.selenium.Alert alert;

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://buythevalue.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@class='grid-image']")).click();
		driver.findElement(By.xpath("//input[@id='wk_zipcode']")).sendKeys("628501");
		driver.findElement(By.xpath("//input[@class='btn']")).click();
		driver.findElement(By.xpath("//button[@id='product-add-to-cart']")).click();
		driver.findElement(By.xpath("(//a[text()='View Cart'])[2]")).click();
		driver.findElement(By.xpath("//input[@id='checkout']")).click();
		Alert a2 = driver.switchTo().alert();
	    a2.accept();
	   
	}

}
