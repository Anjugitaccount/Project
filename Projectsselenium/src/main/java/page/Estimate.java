package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtility;
import utility.WaitUtility;

public class Estimate {
	@FindBy(xpath="//span[text()='Estimates']")
	WebElement estimate;
	@FindBy(xpath="//span[text()='Estimate List']")
	WebElement estimateList;
	@FindBy(xpath="//a[@title='Add estimate']")
	WebElement addEstimate;
	@FindBy(xpath="//input[@placeholder='Estimate date']")
	WebElement estimateDate;
	@FindBy(xpath="//input[@placeholder='Valid until']")
	WebElement validUntil;
	
	@FindBy(id="s2id_estimate_client_id")
	private WebElement clientDropdown;
	
	@FindBy(xpath="//input[@id='s2id_autogen9_search']")
	private WebElement clientSearch;
	
	@FindBy(xpath="//ul[@class='select2-results']//li[1]//div//span")
	private WebElement clientOption;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	@FindBy(xpath="//button[@class='close']")
	WebElement close;
	
	WaitUtility waitutility;
	ElementUtility elementutility;
	WebDriver driver;

	public Estimate(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitutility=new WaitUtility(driver);
		elementutility=new ElementUtility(driver);
	}
public String createEstimate(String date,String validDate,String searchClient) {
	estimate.click();
	waitutility.clickable(estimateList);
	estimateList.click();
	waitutility.clickable(addEstimate);
	addEstimate.click();
	elementutility.dateSelect(estimateDate, date);
	elementutility.dateSelect(validUntil, validDate);
	waitutility.clickable(clientDropdown);
	clientDropdown.click();
	clientSearch.sendKeys(searchClient);
	clientOption.click();
	submit.click();
	close.click();
	estimate.click();
	String actual=driver.findElement(By.xpath("//div[@id='page-container']//descendant::h1")).getText();
	return actual;
	
	}
}
