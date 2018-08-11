package week8.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeMethods implements WdMethods{
	RemoteWebDriver driver ;
	int i = 1;
	public void startApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\\\Drivers\\\\chromedriver.exe");
				 driver = new ChromeDriver();			
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckoriver.exe");
				 driver = new FirefoxDriver();		
			}
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("The Browser "+browser+" is Launched Successfully");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("WebDriverException has occured");
			throw new RuntimeException();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Exception has occured");
			throw new RuntimeException();
		}
		
		
		finally
		{
			takeSnap();
         }
		
	}

	public WebElement locateElement(String locator, String locValue) {
		switch (locator) {
		case "id": 	  return driver.findElementById(locValue);
		case "name": 	  return driver.findElementByName(locValue);
		case "class": return driver.findElementByClassName(locValue);
		case "xpath": return driver.findElementByXPath(locValue);
		case "linktext": return driver.findElementByLinkText(locValue);
		//case "name": return driver.findElementByName(locValue);
		}
		return null;
	}
	
	public WebElement locateElement(String locValue) {
		return driver.findElementById(locValue);
		
		
		
		
		
	}
		

	public void type(WebElement ele, String data) throws NullPointerException,NoSuchElementException{
		try {
			ele.sendKeys(data);
			System.out.println("The Data "+ data +" is Entered Successfully");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("WebDriverException has occured");
			throw new RuntimeException();

		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Exception has occured");
			throw new RuntimeException();
		}

		
		takeSnap();
	}

	public void click(WebElement ele) {
	ele.click();
	System.out.println("The Element "+ ele +" is clicked Successfully");
	takeSnap();		
	}
	
	
	public void clickWithOutSnap(WebElement ele) {
		ele.click();
		System.out.println("The Element "+ ele +" is clicked Successfully");
		}
	
	
    //For Accessing the next ICON
	public void keytap() {
		
		
	}
	
	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		String message="";
		try {
			message=ele.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		System.out.println(message);
		takeSnap();
		return message;
	}
	//WebDriverWait
	public void waitUntilVisibility(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
			
	}
	public void waitUntilSelectable(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
			
	}
	
	public void mouseOverClick(WebElement ele1 , WebElement ele2) {
	Actions builder = new Actions(driver);
	builder.moveToElement(ele1).pause(3000).click(ele2).build().perform();
		
	}
	
	
	public String getAttribute(WebElement ele,String attrName) {
		// TODO Auto-generated method stub
		String message=ele.getAttribute(attrName);	
		
		System.out.println(message);
		takeSnap();
		return message;
	}
	


	public void selectDropDownUsingText(WebElement ele, String value) {
		// TODO Auto-generated method stub
		Select dropDown1=new Select(ele);
		dropDown1.selectByVisibleText(value);;
		System.out.println("The source method" + value +"is selected Successfully");
		takeSnap();
		
	}
	
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		//Marketing Region
		Select dropDown2=new Select(ele);
		dropDown2.selectByIndex(index);
		System.out.println("The  Marketing Region index value "+ index +"is selected Successfully");
		takeSnap();
		
		
	}
	public void selectDropDownUsingValue(WebElement ele, String j) {
		// TODO Auto-generated method stub
		//Industry
		Select dropDown3=new Select(ele);
		dropDown3.selectByValue(j);
		System.out.println("The  Industry value "+ j +"is selected Successfully");
		takeSnap();
		
		
	}
	public void selectDropDownUsingValue4(WebElement ele, String minVal) {
		// TODO Auto-generated method stub
		//Industry
		Select dropDown3=new Select(ele);
		dropDown3.selectByValue(minVal);
		System.out.println("The  Minimum price value  "+  minVal  +"is selected Successfully");
		takeSnap();
		
		
	}
	public void selectDropDownUsingValue5(WebElement ele, String maxVal) {
		// TODO Auto-generated method stub
		//Industry
		Select dropDown3=new Select(ele);
		dropDown3.selectByValue(maxVal);
		System.out.println("The  Miximum price value  "+  maxVal  +"is selected Successfully");
		takeSnap();
		
		
	}


	public void selectDropDownUsingText1(WebElement ele, String value) {
		// TODO Auto-generated method stub
		Select dropDown4=new Select(ele);
		dropDown4.selectByVisibleText(value);;
		System.out.println("The Ownership method" + value +"is selected Successfully");
		takeSnap();
		    
	}
	public void selectDropDownUsingValue1(WebElement ele, String value) {
		// TODO Auto-generated method stub
			Select dropDown=new Select(ele);
		    dropDown.selectByValue(value);
		    System.out.println("The  Country value "+ value +"is selected Successfully");
		    takeSnap();
		    
	}
	public void selectDropDownUsingText2(WebElement ele, String value) {
		// TODO Auto-generated method stub
		Select dropDown6=new Select(ele);
		dropDown6.selectByVisibleText(value);;
		System.out.println("The State/Province" + value +"is selected Successfully");
		takeSnap();
		    
	}

		    
	public boolean verifyTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		boolean bReturn=false;
		if(driver.getTitle().equals(expectedTitle)) {
		System.out.println("The Title is Matched successfully");
		bReturn=true;
		takeSnap();
		}
		else
		{
		System.out.println("The Title is NOT Matched");
		takeSnap();
		}
		return bReturn;
		
	}


	public void verifyExactText(WebElement ele, String expectedText) {
		
		if(ele.getText().equals(expectedText))
		{
		System.out.println("The expectedText is Matched successfully");	
		}
		else
		{
			System.out.println("The expectedText is NOT Matched");				
		}
		
		
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		if(ele.getText().contains(expectedText))
		{
		System.out.println("The expectedText is Matched successfully");	
		}
		else
		{
		System.out.println("The expectedText is NOT Matched");				
		}
		takeSnap();
		
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		if(ele.getAttribute(attribute).equals(value))
		{
		System.out.println("The attrubuteValue is Matched successfully");	
		}
		else
		{
			System.out.println("The attributeValue is NOT Matched");				
		}
		takeSnap();
		
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		if(ele.getAttribute(attribute).contains(value))
		{
		System.out.println("The attrubuteValue is Matched successfully");	
		}
		else
		{
		System.out.println("The attrubuteValue is NOT Matched");	
		}
		
	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub
		if(ele.isSelected()==true) 
		{
			
			System.out.println("The element is selected successfully");
		}
		else 
		{
			System.out.println("The element is NOT selected successfully");
			
		}
		takeSnap();
		
	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		if(ele.isDisplayed()==true) 
		{
			
			System.out.println("The element is displayed successfully");
		}
		else 
		{
			System.out.println("The element is NOT displayed successfully");
			
		}
		takeSnap();
	}

	public void switchToWindow(int index) {
		// TODO Auto-generated method stub
		
		try {
			Set<String> allWindows=driver.getWindowHandles();
			List<String> listOfWindows = new ArrayList<String>();
			listOfWindows.addAll(allWindows);
			driver.switchTo().window(listOfWindows.get(index));
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("NoSuchWindow Exception has occured");
		}
		
		takeSnap();		
	}
	
//	public void switchToWindow1(int index) {
//		// TODO Auto-generated method stub
//		
//		
//     Set<String> allWinHandles = driver.getWindowHandles();
//		
//		List<String> listOfWin= new ArrayList<String>();
//		listOfWin.addAll(allWinHandles);
//		driver.switchTo().window(listOfWin.get(1));
//		driver.manage().window().maximize();
//		System.out.println("From Lead Page url:" + driver.getCurrentUrl());
//		System.out.println("From Lead Page Title:" + driver.getTitle());
//				
//		takeSnap();		
//	}
//	public void switchToWindow2(int index) {
//		// TODO Auto-generated method stub
//		
//		
//     Set<String> allWinHandles = driver.getWindowHandles();
//		
//		List<String> listOfWin= new ArrayList<String>();
//		listOfWin.addAll(allWinHandles);
//		driver.switchTo().window(listOfWin.get(1));
//		driver.manage().window().maximize();
//		System.out.println("From Lead Page url:" + driver.getCurrentUrl());
//		System.out.println("From Lead Page Title:" + driver.getTitle());
//				
//		takeSnap();		
//	}

	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().frame(ele);
		} catch (NoSuchFrameException e) {
			// TODO Auto-generated catch block
			System.err.println("No Frame execption has occured");
		}
			
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
		} 	catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert Exception has Occured");
		}
         catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("No Alert Exception has Occured");
		}
	}
	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
		} 
		catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert Exception has Occured");
		}
         catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("No Alert Exception has Occured");
		}
		
		
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		 Alert alertObj=driver.switchTo().alert();		 
		 String text=alertObj.getText();
		 System.out.println(text);
		return null;
	}
	
	public void clear(WebElement ele) {
	ele.clear();
	System.out.println("The Element "+ele+" is cleared successfully");
	takeSnap();	
	}
	
	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/img"+i+".png");
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;
	}
	

	public void closeBrowser() {
		// TODO Auto-generated method stub
		driver.close();
		
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		driver.quit();
	}
	public void closeCurrentWindow(String parentTitle) {
		String title = driver.getTitle();
	try {	
		Set<String> allWinHandles = driver.getWindowHandles();
		List<String> lisfOfWin= new ArrayList<String>();		
		lisfOfWin.addAll(allWinHandles);		
		for(i=0;i<lisfOfWin.size();i++) {
			
			if(driver.getTitle().equals(title)) {
				driver.close();
				break;
			}
						
		}
		allWinHandles = driver.getWindowHandles();
		 lisfOfWin= new ArrayList<String>();		
		lisfOfWin.addAll(allWinHandles);
		driver.switchTo().window(lisfOfWin.get(0));
		
	}catch(IndexOutOfBoundsException e) {
		System.err.println("Index out of bound exception");
		
			}
	catch(Exception e) {
		e.printStackTrace();
	}
	}

}

