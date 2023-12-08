package week4.Assignment;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MAS");
		driver.findElement(By.xpath("//div[text()='Mgr Chennai Ctr']")).click();
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MDU");
		driver.findElement(By.xpath("//div[text()='Madurai Jn']")).click();
		driver.findElement(By.id("chkSelectDateOnly")).click();
		List<WebElement> col = driver.findElements(By.xpath("//div[@id='divTrainsList']/table/tbody/tr/td[2]"));
		for (int i = 0; i < col.size(); i++) {
			String coltext = col.get(i).getText();
			System.out.println(coltext);
			}
		//- Verify if there are any duplicate train names in the web table.
		Set<WebElement> dup=new LinkedHashSet<WebElement>(col);
		if (col.size()==dup.size()) {
			System.out.println("No Duplicate");
			
		}else {
			System.out.println(" Duplicate present");
		}
		
			
		}
		
		
			
		}

	


