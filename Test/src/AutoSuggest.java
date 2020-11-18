import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutoSuggest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String path = "C:\\Selenium\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com");
		driver.manage().window().maximize();

		//from city
		driver.findElement(By.id("FromTag")).sendKeys("fran");
		Thread.sleep(5000);
		List<WebElement> cityList = driver.findElements(By.cssSelector("li[class='list'] a"));
		for (WebElement element : cityList) {
			if (element.getText().equalsIgnoreCase("Frankfurt, DE - Frankfurt (FRA)")) {
				element.click();
				break;
			}
		}
		Thread.sleep(3000);
		
		//to city
		driver.findElement(By.id("ToTag")).sendKeys("hong");
		Thread.sleep(5000);
		List<WebElement> cityListToTag = driver.findElements(By.cssSelector("li[class='list'] a"));
		for (WebElement elementTo : cityListToTag) {
			if (elementTo.getText().equalsIgnoreCase("Hong Kong, CN - Hong Kong (HKG)")) {
				elementTo.click();
				break;
			}
		}
		Thread.sleep(3000);
		
		// click to select number of Adults
		Select adults = new Select(driver.findElement(By.id("Adults")));
		Thread.sleep(2000);
		adults.selectByVisibleText("5");

		// click to select number of children
		Thread.sleep(2000);
		Select children = new Select(driver.findElement(By.id("Childrens")));
		Thread.sleep(2000);
		children.selectByVisibleText("3");

		// select the date
		Thread.sleep(2000);
		driver.findElement(By.id("DepartDate")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[@id='ui-datepicker-div'] //a[@class='ui-state-default ui-state-highlight ui-state-active ']")).click();

		// click more options
		Thread.sleep(2000);
		driver.findElement(By.id("MoreOptionsDiv")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("indi");
		Thread.sleep(5000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='list'] a"));
		for (WebElement element : options) {
			if (element.getText().equalsIgnoreCase("IndiGo (6E)")) {
				element.click();
				break;
			}
		}

		// click Search button and get error message
		/*
		 * Thread.sleep(2000);
		driver.findElement(By.id("SearchBtn")).click();
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
		*/
	}

}
