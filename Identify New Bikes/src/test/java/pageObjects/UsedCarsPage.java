package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;
import utilities.DataWriter;

public class UsedCarsPage extends BasePage{
	
	public Actions action;
	public String name;
	public List<String> texts = new ArrayList<String>();
	
	//Constructor
	public UsedCarsPage(WebDriver driver) {
		super(driver);
		action=new Actions(driver);
	}
	
	//Locators
		@FindBy(xpath = "//a[normalize-space()='Used Cars']")
		WebElement usedCar;
		
		@FindBy(xpath = "//span[contains(text(),'Chennai')]")
		WebElement clickChennai;
		
		@FindBy(xpath = "//*[text()='Popular Models']")
		WebElement popularModels;
	
		
		@FindBy(xpath = "//*[starts-with(@id,'mmvLi')]/label")
		List<WebElement> popularModelList;
		
		@FindBy(xpath = "//input[@name='bycarid']")
		List<WebElement> popularModelListCheckBox;
		
		@FindBy(xpath = "//div[contains(@class,'pl-30')]//a")
		List<WebElement> popularModelName;
		
		@FindBy(xpath = "//*[@id=\"thatsAllFolks\"]")
		WebElement scrollToEnd;
	
		
		
	//Action Methods
		//Hovering over usedCar section
	public void navigateToUsedCars() {
		action.moveToElement(usedCar).build().perform();
		BaseClass.waitMethod(clickChennai);
	}
	//Selecting Chennai as option
	public void navigateToChennai() {
		BaseClass.clickElement(clickChennai);
	}
	//Scrolling down to popularModel Section
	public void scrollToPopularModels() {
		BaseClass.scrollToElement(popularModels);
		BaseClass.waitMethod(popularModels);
	}
	//Checking the checkbox of every popular models and printing the names
	public void popularModelsList(){
		for(WebElement eachElement : popularModelListCheckBox ) {
			BaseClass.clickElement(eachElement);
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		BaseClass.scrolltoEnd(scrollToEnd);
		BaseClass.scrolltoEnd(scrollToEnd);
		jse.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 8);");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(popularModelName.size()); 
		for(WebElement eachElement : popularModelName) {
			name=eachElement.getText();
			System.out.println(name);
			texts.add(name);
		//for(WebElement element:popularModelList) {
			//name=element.getText();
			//System.out.println(name);
			//texts.add(name);
		//}
	}
	}
	//to store data in excel sheet
	public void displaypopularModelsList()
	{
		 List<String> headers = Arrays.asList("Name of the used cars");
		System.out.println(texts);
		try {
			DataWriter.putData(texts, 0, "UsedCars",headers);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
