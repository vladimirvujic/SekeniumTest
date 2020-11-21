import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//click Nested frames
		driver.findElement(By.linkText("Nested Frames")).click();
		
		//get total numbers of frames
		List<WebElement> frameCount = driver.findElements(By.tagName("frame"));
		System.out.println("Total number of frames is: " + frameCount.size());
		
		//get the frame 1
		driver.switchTo().frame("frame-top");
		
		//get the right text of frame 1
		driver.switchTo().frame("frame-right");
		System.out.println("--- Right frame text is: " + driver.findElement(By.tagName("body")).getText());
		
		//switch to default content
		driver.switchTo().defaultContent();
		
		//switch to frame 2
		driver.switchTo().frame("frame-bottom");
		
		//get the text from bottom frame
		System.out.println("--- Bottom frame text is: " + driver.findElement(By.tagName("body")).getText());
		
	}

}
