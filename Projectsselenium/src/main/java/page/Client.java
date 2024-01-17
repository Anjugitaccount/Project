package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ElementUtility;
import utility.WaitUtility;

public class Client {
	@FindBy(xpath="//span[text()='Clients']")
	WebElement locateClient;
	@FindBy(xpath="//a[text()=' Add client']")
	WebElement addClient;
	@FindBy(xpath="//input[@placeholder='Company name']")
	WebElement companyName;
	@FindBy(xpath="//input[@placeholder='Phone']")
	WebElement phone;
	@FindBy(xpath="//input[@placeholder='Website']")
	WebElement website;
	@FindBy(xpath="//button[text()=' Save']")
	WebElement save;
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement search;
	@FindBy(xpath="//button[@class='close']")
	WebElement close;
	@FindBy(xpath="//table[@id='client-table']//tbody//tr[1]//td[2]//a")
	WebElement serchElement;
	@FindBy(xpath="//a[@class='edit']")
	WebElement edit;
	@FindBy(xpath="//button[text()=' Save']")
	WebElement editSave;
	@FindBy(xpath="//button[@class='close']")
	WebElement editClose;
	@FindBy(xpath="//a[@class='delete']")
	WebElement delete;
	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement deleteCnfrm;
	@FindBy(xpath="//button[@class='close']")
	WebElement deleteClose;
	@FindBy(xpath="//table[@id='client-table']//tbody//tr[1]//td[1]")
	WebElement noRecord;
	WaitUtility waitutility;
	ElementUtility elementutility;
	WebDriver driver;

	public Client(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitutility=new WaitUtility(driver);
		elementutility=new ElementUtility(driver);

	}
	public String addClient(String name,String phoneno,String site) {

		//to select client from menubar
		locateClient.click();
		//to click on the add client button
		addClient.click();
		//to input company name
		companyName.sendKeys(name);
		//to add phone
		//to scroll the popup window
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",  phone);
		phone.sendKeys(phoneno);
		//to enter website
		website.sendKeys(site);
		save.click();
		close.click();
		locateClient.click();

		String actual=searchClient(name);
		return actual;

	}
	public String editClient(String searchEle,String newName) {
		locateClient.click();
		search.sendKeys(searchEle);
		edit.click();
		companyName.clear();
		companyName.sendKeys(newName);
		editSave.click();
		editClose.click();
		locateClient.click();

		String actual=searchClient(newName);
		return actual;

	}
	public String deleteClient(String deleteEle) {

		locateClient.click();
		waitutility.visibility(search);
		search.sendKeys(deleteEle);
		waitutility.clickable(delete);
		delete.click();
		waitutility.clickable(deleteCnfrm);
		deleteCnfrm.click();
		waitutility.clickable(deleteClose);
		deleteClose.click();
		locateClient.click();
		waitutility.visibility(search);
		search.sendKeys(deleteEle);
		String actual=noRecord.getText();
		return actual;

	}
	public String searchClient(String searchname)
	{
		waitutility.clickable(search);
		search.sendKeys(searchname);

		By locator=By.xpath("//table[@id='client-table']//tbody//tr//td//a[contains(text(),'"+searchname+"')]");
		waitutility.visibility(locator);
		List<WebElement> clienttable=driver.findElements(By.xpath("//table[@id='client-table']//tbody//tr//td//a[contains(text(),'"+searchname+"')]"));
		waitutility.visibility(clienttable);
		int row=elementutility.getTableDataRowCount(clienttable, searchname);

		String actualmsg="";//local variable need to initialise
		if(row!=0) 
		{
			WebElement tableRow=driver.findElement(By.xpath("//table[@id='client-table']//tbody//tr["+row+"]//td[2]"));
			actualmsg=tableRow.getText();
			System.out.println("VerifySearch "  +actualmsg);
		}
		return actualmsg;
	}
	public void clickClient() {
		locateClient.click();
	}
}
