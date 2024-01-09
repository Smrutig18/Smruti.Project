package TestScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonData.CommonConstants;
import Library.BaseClass;
import PageObjects.GoIbiboObjects;

public class MyScript {

	WebDriver driver;

	@BeforeTest
	public void executeBeforeTest() throws Exception {
		driver = BaseClass.getDriver();
		GoIbiboObjects goIbiboObjects = new GoIbiboObjects(driver);
		goIbiboObjects.setupMethod();
		goIbiboObjects.navigateToTheURL(CommonConstants.URLValue);
	}

	@Test(priority = 1)
	public void executeTest() throws Exception {
		
		
		driver = BaseClass.getDriver();
		GoIbiboObjects goIbiboObjects = new GoIbiboObjects(driver);
		goIbiboObjects.enterData(GoIbiboObjects.ohrmUname, "admin");
		goIbiboObjects.enterData(GoIbiboObjects.ohrmPswd, "admin123");
		goIbiboObjects.clickElement(GoIbiboObjects.ohrmLoginBtn);
		goIbiboObjects.clickElement(GoIbiboObjects.waitExplicitly(GoIbiboObjects.adminTab,10));
		//goIbiboObjects.selectByValueMethod(GoIbiboObjects.ohrmDropDown, "2");
		//goIbiboObjects.selectByIndexMethod(GoIbiboObjects.ohrmDropDown, 1);
		goIbiboObjects.scrollTillBottom();
		int a = goIbiboObjects.countOfWebElements(GoIbiboObjects.listOfRecrdsESSinUserRole);
		if(a==2)
		{
			System.out.println("total count is "+ a);
		}
		else
		{
			System.out.println("total count is not expected , rather it is"+ a);
			goIbiboObjects.takeSnapShot("C:\\Temp\\");
		}
		goIbiboObjects.quitBrowser();
		
		
		
	}
	
	@Test(priority = 2)
	public void executeTest1() throws Exception {
		
		
		driver = BaseClass.getDriver();
		GoIbiboObjects goIbiboObjects = new GoIbiboObjects(driver);
		goIbiboObjects.enterData(GoIbiboObjects.ohrmUname, "admin");
		goIbiboObjects.enterData(GoIbiboObjects.ohrmPswd, "admin123");
		goIbiboObjects.clickElement(GoIbiboObjects.ohrmLoginBtn);
		goIbiboObjects.clickElement(GoIbiboObjects.adminTab);
		//goIbiboObjects.selectByValueMethod(GoIbiboObjects.ohrmDropDown, "2");
		//goIbiboObjects.selectByIndexMethod(GoIbiboObjects.ohrmDropDown, 1);
		goIbiboObjects.scrollTillBottom();
		int a = goIbiboObjects.countOfWebElements(GoIbiboObjects.listOfRecrdsESSinUserRole);
		if(a==2)
		{
			System.out.println("total count is "+ a);
		}
		else
		{
			System.out.println("total count is not expected , rather it is"+ a);
			goIbiboObjects.takeSnapShot("C:\\Temp\\");
		}
		
		
	}

	@AfterTest
	public void executeAfterTest() {
		driver = BaseClass.getDriver();
		GoIbiboObjects goIbiboObjects = new GoIbiboObjects(driver);
		goIbiboObjects.quitBrowser();
	}
}
