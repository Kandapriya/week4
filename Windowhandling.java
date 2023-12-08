package week4.Assignment;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ChromeDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(03));
       driver.get("http://leaftaps.com/opentaps/control/login");
       driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
       driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
       driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
   	    driver.findElement(By.linkText("CRM/SFA")).click();
   	    driver.findElement(By.linkText("Contacts")).click();
   	    driver.findElement(By.linkText("Merge Contacts")).click();
   	    driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
   	   Set<String> wh = driver.getWindowHandles();
   	    List<String> wh1=new ArrayList<String>(wh);
   	    driver.switchTo().window(wh1.get(1));
   	    driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
   	    driver.switchTo().window(wh1.get(0));
   	    driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
   	    Set<String> win = driver.getWindowHandles();
   	    List<String> win2=new ArrayList<String>(win);
   	    driver.switchTo().window(win2.get(1));
   	    driver.findElement(By.xpath("//a[text()='11876']")).click();
   	    driver.switchTo().window(win2.get(0));
   	    driver.findElement(By.xpath("//a[text()='Merge']")).click();
   	    Alert a1 = driver.switchTo().alert();
   	    a1.accept();
   	    String text = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_contacts']")).getText();
	    System.out.println(text);
		
   	    
	}

}
