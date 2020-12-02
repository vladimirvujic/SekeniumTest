import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum = 0;
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.sofascore.com/tournament/football/spain/laliga/8");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
				
		//get parent table
		WebElement table = driver.findElement(By.cssSelector("div[class='styles__StandingsTableMaybeTabs-sc-1b1fqqh-11 hDVNHB']"));
		int rowCount = table.findElements(By.cssSelector("div[class='Tabs__Content-vifb7j-1 jppjfQ']")).size();
		System.out.println("Number of rows is: " +rowCount);
		
		//get child table
		int countChild = table.findElements(By.cssSelector("div[class='Cell-decync-0 styles__Cell-sc-1b1fqqh-0 LOVhJ'] div:nth-child(4)")).size();
		System.out.println("Child is: " +countChild);
		
		//get all Win column numbers 
		for (int i = 1; i < countChild; i++) {
			String value = table.findElements(By.cssSelector("div[class='Cell-decync-0 styles__Cell-sc-1b1fqqh-0 LOVhJ'] div:nth-child(4)")).get(i).getText();
			int valueInteger = Integer.parseInt(value);//Converting String into integer	
			sum = sum + valueInteger;	
		}
		
		//Printing value of WINs
		System.out.println("Total value is: " +sum);//206
		
		if (sum == 206) {
			System.out.println("--- Count matches ---");
		} else {
			System.out.println("--- Count fail ---");
		}
	}

}
