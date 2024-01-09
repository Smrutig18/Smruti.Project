package Library;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass {

	protected static WebDriver driver;

	public void setupMethod()  {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32_95\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public void navigateToTheURL(String URL) throws InterruptedException {
		driver.navigate().to(URL);
		Thread.sleep(7000);
	}

	
	public void quitBrowser() {
		driver.quit();

	}

	public void refreshPge() {
		driver.navigate().refresh();
	}

	public void closeBrowser() {
		driver.close();
	}

	public BaseClass(WebDriver driver) {
		this.driver = driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
