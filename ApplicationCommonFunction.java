package Library;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import PageObjects.GoIbiboObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApplicationCommonFunction extends BaseClass {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public ApplicationCommonFunction(WebDriver driver) {
		super(driver);
	}

	public void clickElement(By element) throws InterruptedException {
		driver.findElement(element).click();
		Thread.sleep(2000);
	}

	public void enterData(By element, String data) throws InterruptedException {
		driver.findElement(element).clear();
		Thread.sleep(1500);
		driver.findElement(element).sendKeys(data);
		Thread.sleep(2000);
	}

	public void enterKeysOption() throws InterruptedException {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
	}

	public void compareTextValue(By element, String expectedText, String actualText) {
		actualText = driver.findElement(element).getText();
		if (actualText.contains(expectedText)) {
			System.out.println("actual value matches expected value");
		} else {
			System.out.println("actual value does not match expected value");
		}
	}

	public void checkIfEnabled(By element) throws InterruptedException {
		if (driver.findElement(element).isEnabled()) {
			System.out.println("The element is enabled");
		} else {
			System.out.println("The element should be enabled but isn't");
		}
		Thread.sleep(1500);
	}

	public void checkIfDisplayed(By element) throws Exception {
		if (driver.findElement(element).isDisplayed()) {
			Assert.assertEquals(true, true);
		} else {
			// Assert.assertEquals(false, true);
			SoftAssert asserts = new SoftAssert();
			asserts.assertEquals(false, true);
			takeSnapShot("C:\\Temp\\testDigvijay.jpg");
		}
		Thread.sleep(1500);

	}

	public boolean checkIfselected(By element) throws InterruptedException {
		if (driver.findElement(element).isSelected()) {
			Thread.sleep(2000);
			return true;
		} else {
			Thread.sleep(2000);
			return false;

		}
	}

	public void rightClickElement(By element) throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement webEl = driver.findElement(element);
		action.contextClick(webEl).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();

		Thread.sleep(2000);
	}

	public void selectByValueMethod(By element, String value) throws InterruptedException {
		WebElement webElement = driver.findElement(element);
		Select select = new Select(webElement);
		// select.selectByValue(value);
		select.selectByVisibleText(value);
		Thread.sleep(3000);
	}

	public void selectByIndexMethod(By element, int value) throws InterruptedException {
		WebElement webElement = driver.findElement(element);
		Select select = new Select(webElement);
		select.selectByIndex(value);
		Thread.sleep(3000);
	}

	/*****************************/

	public void swithcToFrame(By element) throws InterruptedException {
		WebElement webEl = driver.findElement(element);
		driver.switchTo().frame(webEl);
		Thread.sleep(2000);

	}

	public void switchToDefaultCont() throws InterruptedException {
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

	}

	public static List<WebElement> recordsInAColumn(By beElement) {
		return driver.findElements(beElement);
	}

	public void scrollTillBottom() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This will scroll the web page till end.
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
	}

	public int countOfWebElements(By element) {

		int count = recordsInAColumn(element).size();
		return count;
	}

	public void takeSnapShot(String fileWithPath) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		File DestFile = new File(fileWithPath + dateFormat.format(timestamp) + ".jpg");
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
	
	
	public static By waitExplicitly(By locator,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return locator;
	}
	
	

public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   

   String[][] tabArray = null;

   try {

	   FileInputStream ExcelFile = new FileInputStream(FilePath);

	   // Access the required test data sheet

	   ExcelWBook = new XSSFWorkbook(ExcelFile);

	   ExcelWSheet = ExcelWBook.getSheet(SheetName);

	   int startRow = 1;

	   int startCol = 1;

	   int ci,cj;

	   int totalRows = ExcelWSheet.getLastRowNum();

	   // you can write a function as well to get Column count

	   int totalCols = 2;

	   tabArray=new String[totalRows][totalCols];

	   ci=0;

	   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

		  cj=0;

		   for (int j=startCol;j<=totalCols;j++, cj++){

			   tabArray[ci][cj]=getCellData(i,j);

			   System.out.println(tabArray[ci][cj]);  

				}

			}

		}

	catch (FileNotFoundException e){

		System.out.println("Could not read the Excel sheet");

		e.printStackTrace();

		}

	catch (IOException e){

		System.out.println("Could not read the Excel sheet");

		e.printStackTrace();

		}

	return(tabArray);

	}

public static String getCellData(int RowNum, int ColNum) throws Exception {

	try{
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		CellType dataType = Cell.getCellType();
		int other = 3;
		if  (dataType.equals(other)) {
			return "";
		}else{
			String CellData = Cell.getStringCellValue();
			return CellData;
		}
	}catch (Exception e){
		System.out.println(e.getMessage());
		throw (e);
		}
	
	
}

public void executeMyLogic(String keyWord1, String keyWord2,String keyWord3,String keyWord4) throws InterruptedException
{
	enterData(GoIbiboObjects.textBoxGoogle, keyWord1+" "+keyWord2+" "+keyWord3+" "+keyWord4);
}
	

}
