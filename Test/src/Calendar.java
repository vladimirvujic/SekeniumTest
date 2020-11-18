import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		//click on the date field
		driver.findElement(By.id("DepartDate")).click();
		
		//select February		
		while (!driver.findElement(By.cssSelector("div[id='ui-datepicker-div'] span[class='ui-datepicker-month']")).getText().contains("February")) {
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("div[id='ui-datepicker-div'] a[class='nextMonth ']")).click();
		}
		
		//select day 14 
		List<WebElement> day14 = driver.findElements(By.cssSelector("td[data-handler='selectDay']"));
		int count = driver.findElements(By.cssSelector("td[data-handler='selectDay']")).size();
		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).getText();
			if (text.equalsIgnoreCase("14")) {
				driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).click();
				break;
			}
		}
		
		
		/*
		//click on the date field
		driver.findElement(By.id("travel_date")).click();
		
		//select January		
		while (!driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='datepicker-switch']")).getText().contains("January")) {
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='next']")).click();
		}
		
		//select day 7 
		List<WebElement> day7 = driver.findElements(By.cssSelector("day"));
		int count = driver.findElements(By.className("day")).size();
		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			if (text.equalsIgnoreCase("7")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
		*/
	}

}
