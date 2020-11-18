import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Alert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//radio example
		driver.findElement(By.cssSelector("input[value='radio2']")).click();
		
		//type some countries
		driver.findElement(By.id("autocomplete")).sendKeys("bar");
		Thread.sleep(3000);
		List<WebElement> countryList = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
		for (WebElement element : countryList) {
			if (element.getText().equalsIgnoreCase("Barbados")) {
				element.click();
				break;
			}
		}
		
		//dropdown - select option 3
		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByVisibleText("Option3");
		
		//checkbox - select option 1 and print value from check box 1
		driver.findElement(By.id("checkBoxOption1")).click();
		String option1 = driver.findElement(By.cssSelector("label[for='bmw']")).getText();
		System.out.println("Value is: " + option1);
		
		//Switch To Alert Example
		driver.findElement(By.id("name")).sendKeys(option1);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id='alertbtn']")).click();	
		System.out.println("Alert value is: " + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

}
