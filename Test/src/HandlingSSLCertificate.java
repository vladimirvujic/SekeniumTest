import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandlingSSLCertificate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//desired capabilities - general chrome profile
				DesiredCapabilities ch = DesiredCapabilities.chrome();
				//ch.acceptInsecureCerts();
				ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				
				//SSl certificate belong to my local chrome browser 
				ChromeOptions c = new ChromeOptions();
				c.merge(ch);
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
				WebDriver driver = new ChromeDriver(c);
				driver.get("https://expired.badssl.com/");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.manage().window().maximize();
	}

}
