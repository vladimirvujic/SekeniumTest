import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://nova.rs/");
		
		//total link number on the page
		int total = driver.findElements(By.tagName("a")).size();
		System.out.println("Total link numbers on the page: " + total);
		
		//total header links
		WebElement header = driver.findElement(By.cssSelector("div[class='header-nav']"));
		System.out.println("Total header links: " + header.findElements(By.tagName("a")).size());
		
		//total footer links		
		WebElement footer = driver.findElement(By.cssSelector("footer[class='footer-container']"));
		System.out.println("Total header links: " + footer.findElements(By.tagName("a")).size());
		
		//total follow us links
		WebElement follow = driver.findElement(By.id("menu-social-icons-footer"));
		System.out.println("Number of follow us links are: " + follow.findElements(By.tagName("a")).size());
		
		//click on each link and check if page is opening
		for (int i = 0; i < follow.findElements(By.tagName("a")).size(); i++) {
			String clickOnTheLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			follow.findElements(By.tagName("a")).get(i).sendKeys(clickOnTheLink);
			Thread.sleep(3000);
		}
		
		//open all tabs and get title
		Set <String> set = driver.getWindowHandles();
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			driver.switchTo().window(iter.next());
			System.out.println(driver.getTitle());
			
		}
	}
}
