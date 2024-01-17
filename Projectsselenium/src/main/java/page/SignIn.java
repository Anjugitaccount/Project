package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn {
WebDriver driver;
	public SignIn(WebDriver driver) {
		this.driver=driver;
	}
	public boolean doSingin(String username,String password) {
		WebElement emailusername=driver.findElement(By.id("email"));
		emailusername.sendKeys(username);
		WebElement passwordsignin=driver.findElement(By.id("password"));
		passwordsignin.sendKeys(password);
		WebElement submitButton=driver.findElement(By.xpath("//button[text()=\"Sign in\"]"));
		submitButton.click();
		WebElement dashboard=driver.findElement(By.xpath("//span[text()=\"Dashboard\"]"));
		boolean returnValue=dashboard.isDisplayed();
		return returnValue;
	}
}
