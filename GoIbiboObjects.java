package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Library.ApplicationCommonFunction;

public class GoIbiboObjects extends ApplicationCommonFunction {

	static WebDriver driver = getDriver();

	public GoIbiboObjects(WebDriver driver) {
		super(driver);
	}

	public static WebDriver getDriver() {
		return driver;

	}
	
	public static By hotelsOption = By.xpath("//a[text()='Hotels']");	
	public static By indiaRadioButton = By.xpath("//h4[text()='India']//preceding-sibling::input");
	public static By whereTextBox = By
			.xpath("//span[text()='Where']//following-sibling::div//input[contains(@id,'downshift')]");
	public static By checkInCalendarOption = By.xpath("//div[@data-testid='openCheckinCalendar']//h4");
	public static By searchIconWhere = By.xpath("//span[text()='Where']//following-sibling::div//*[name()='svg']");
	public static By whereToFromDate = By.xpath(
			"//span[text()='October 2021']//ancestor::div//li[@class='date_is_selectable_true']/span[@data-testid='date_12_9_2021']");
	public static By whereToToDate = By.xpath(
			"//span[text()='October 2021']//ancestor::div//li[@class='date_is_selectable_true']/span[@data-testid='date_15_9_2021']");
	public static By nightsText = By.xpath("//div[contains(text(),'Nights')]");
	public static By guestAndRoomBox = By.xpath("//input[contains(@class,'CitySearchInput')]");

	public static By guestsAndRooms(String choice) {
		return By.xpath("//span[text()='" + choice + "']//following-sibling::div//span[text()='+']");
	}
	
	public static By childDropDown = By.xpath("//ul[contains(@class,'ChildDropdownWrap')]");

	public static By childDropDownOption(int choice) {
		return By.xpath("(//span[contains(text(),'Age')])[" + choice
				+ "]//ancestor::span[contains(text(),'Child')]//following-sibling::div//span//*[name()='svg']");
	}

	public static By childDropDownAgeOption(int choice) {
		return By.xpath("//ul[contains(@class,'ChildDropdownWrap')]//li[text()='" + choice + "']");
	}

	public static By doneButton = By.xpath("//button[text()='Done']");
	public static By searchHotelsButton = By.xpath("//button[@data-testid='searchHotelBtn']");
	public static By sectionPage = By.xpath("//section[contains(@class,'RightSection')]");
	
	
	/*****************************/
	
	public static By madAdversFrame = By.xpath("//ins[@id='aswift_0_expand']//iframe[@id='aswift_0']");
	public static By madCrossCut = By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/*[name()='svg']");
	public static By htmlTutoLink = By.xpath("//a[text()='HTML Introduction']");
	

	/*****************************/
	
	public static By CheckBoxFirst(String value) {
		return By.xpath("//input[@id='"+value+"']//following-sibling::label");
	}
	public static By linkFlights = By.xpath("//a[text()='Flights']");
	
	/*****************************/

	public static By ohrmDropDown = By.xpath("//select[@id='searchSystemUser_userType']");
	public static By ohrmUname = By.xpath("//input[@id='txtUsername']");
	public static By ohrmPswd = By.xpath("//input[@id='txtPassword']");
	public static By ohrmLoginBtn = By.xpath("//input[@id='btnLogin']");
	public static By adminTab = By.xpath("//a[@id='menu_admin_viewAdminModule']");
	
	
	public static By listOfRecrdsESSinUserRole = By.xpath("//a[text()='User Role']//ancestor::thead//following-sibling::tbody//tr/td[text()='ESS']");
	
	public static By textBoxGoogle = By.xpath("//input[@class='gLFyf gsfi']");
	
	
}
