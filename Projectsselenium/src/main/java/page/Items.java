package page;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtility;
import utility.WaitUtility;

public class Items {
	@FindBy(xpath="//span[text()=\"Items\"]")
	WebElement locateItems;
	@FindBy(xpath="//a[text()=' Add item']")
	WebElement addItems;
	@FindBy(xpath="//input[@placeholder='Title']")
	WebElement title;
	@FindBy(xpath="//textarea[@placeholder='Description']")
	WebElement description;
	@FindBy(xpath="//input[@placeholder='Unit type (Ex: hours, pc, etc.)']")
	WebElement unitType;
	@FindBy(xpath="//input[@placeholder='Rate']")
	WebElement rate;
	@FindBy(xpath="//button[text()=' Save']")
	WebElement save;
	@FindBy(xpath="//button[@class='close']")
	WebElement close;
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement search;
	@FindBy(xpath="//table[@id='item-table']//tbody//tr[1]//td[1]")
	WebElement searchElement;
	@FindBy(xpath="//a[@title='Edit item']")
	WebElement edit;
	@FindBy(xpath="//button[text()=' Save']")
	WebElement editSave;
	@FindBy(xpath="//button[@class='close']")
	WebElement editClose;
	@FindBy(xpath="//a[@class='delete']")
	WebElement delete;
	
	@FindBy(xpath="//table[@id='item-table']//tr[1]//td[1]")
	WebElement noRecord;
	
	WaitUtility waitutility;
	ElementUtility elementutility;
	WebDriver driver;
	
	public Items(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		waitutility=new WaitUtility(driver);
		elementutility=new ElementUtility(driver);
	}
	public String addIteam(String titleof,String descriptionof,String unit,String itemRate) {
		locateItems.click();
		addItems.click();
		title.sendKeys(titleof);
		description.sendKeys(descriptionof);
		unitType.sendKeys(unit);
		rate.sendKeys(itemRate);
		save.click();
		close.click();
		locateItems.click();
		
		String actual=searchIteam(titleof);
		return actual;
		
	/*	boolean value=locateItems.isDisplayed();
		search.sendKeys(titleof);
		return value;*/
			}
	
	public String editIteam(String searchEle,String newTitle) {
		
		  
		locateItems.click();
		waitutility.visibility(search);
		search.sendKeys(searchEle);
		edit.click();
		title.clear();
		title.sendKeys(newTitle);
		editSave.click();
		editClose.click();
		locateItems.click();
		
		
		String actual=searchIteam(newTitle);
		return actual;
		
	}
	public String deleteIteam(String deleteEle) {
		locateItems.click();
		
		
		search.sendKeys(deleteEle);
	
		delete.click();
		locateItems.click();
	
		search.sendKeys(deleteEle);
		String actual=noRecord.getText();
		return actual;
		
	}
	public String searchIteam(String searchname)
	{
		waitutility.clickable(search);
		search.sendKeys(searchname);

		By locator=By.xpath("//table[@id='item-table']//tbody//tr//td[contains(text(),'"+searchname+"')]");
		waitutility.visibility(locator);
		List<WebElement> itemtable=driver.findElements(By.xpath("//table[@id='item-table']//tbody//tr//td[contains(text(),'"+searchname+"')]"));
		waitutility.visibility(itemtable);
	int row=elementutility.getTableDataRowCount(itemtable, searchname);

		String actualmsg="";//local variable need to initialise
		if(row!=0) 
		{
			WebElement tableRow=driver.findElement(By.xpath("//table[@id='item-table']//tbody//tr["+row+"]//td[1]"));
			actualmsg=tableRow.getText();
			System.out.println("VerifySearch "  +actualmsg);
		}
		return actualmsg;
	}
	public void clickIteam() {
		locateItems.click();
	}

}
