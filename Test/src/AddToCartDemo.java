import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AddToCartDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.maxi.rs/online/Pakovana-hrana-i-osnovne-namirnice/c/08");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/main/header/div/div[2]/div/div[3]/div/button[2]")).click();

		// shopping list that be should added to the cart
		String item = "Vital";
		// Thread.sleep(3000);

		List<WebElement> product = driver.findElements(By.cssSelector("p[class='ellipsis']"));
		for (int i = 0; i < product.size(); i++) {
			String name = product.get(i).getText();
			if (name.contains(item)) {
				// click add to cart
				driver.findElements(By.cssSelector("div[class='js-basket-adder-btns basket-adder-btns-holder']")).get(i)
						.click();
				break;
			}

		}
		// move mouse over the cart
		WebElement cart = driver.findElement(By.cssSelector("li[data-total-display-mode='TOTAL']"));
		Actions move = new Actions(driver);
		move.moveToElement(cart).build().perform();

	}

}
