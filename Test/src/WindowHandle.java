import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/accounts/emailsignup/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//click Terms;		
		driver.findElement(By.linkText("Terms")).click();
		
		
		//before clicking
		System.out.println("--- Before swithing ---");
		System.out.println(driver.getTitle());
		Set<String> set = driver.getWindowHandles();
		Iterator <String> itr = set.iterator();
		String parentID = itr.next();
		String childID = itr.next();
		driver.switchTo().window(childID);
		//Thread.sleep(3000);
		
		
		//after switching
		System.out.println("--- After switching ---");
		System.out.println(driver.getTitle());
		driver.close();
		
		//back to the parent link
		System.out.println("--- Back to parent link ---");
		driver.switchTo().window(parentID);
		System.out.println(driver.getTitle());		
		//Thread.sleep(3000);
		
		//total links in this area
		System.out.println("--------------------");
		WebElement tab = driver.findElement(By.cssSelector("p[class=' ZGwn1']"));
		System.out.println("Total links in this area: " + tab.findElements(By.tagName("a")).size());
		
		//click on Terms, Data Policy and Cookies Policy
		for (int i = 0; i < tab.findElements(By.tagName("a")).size(); i++) {
			String clickOnTheLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			tab.findElements(By.tagName("a")).get(i).sendKeys(clickOnTheLink);
			//Thread.sleep(3000);
		}
		
		//open all tabs and get title
		Set<String> links = driver.getWindowHandles();
		Iterator<String> iterLinks = links.iterator();
		while (iterLinks.hasNext()) {
			driver.switchTo().window(iterLinks.next());
			System.out.println(driver.getTitle());
		}
	}

}
