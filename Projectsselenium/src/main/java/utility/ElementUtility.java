package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class ElementUtility {
	WebDriver driver;
	public ElementUtility(WebDriver driver) {
		this.driver=driver;
		
	}
	 public static String readPropertiesFile(String key) throws IOException {
	      FileInputStream fis = null;
	      Properties prop = null;
	      String fileName=Constant.propertiesPath;
	      String value=null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	     value=prop.getProperty(key);
	         } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	      return value;
	   }
	 
	 public void scroll(WebElement element) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();",  element);
	 }
	 public int getTableDataRowCount(List<WebElement> tableRowData ,String expectedValue)
		{
			int counter=0;
			for(int i=0;i<tableRowData.size();i++)
			{
				String value=tableRowData.get(i).getText();
				if(expectedValue.equalsIgnoreCase(value))
				{
					counter=i+1;
					break;
				}
			}
			return counter;
		}
	 //create methods for dropdown,radiobutton,checkbox,draganddrop
	 public void dateSelect(WebElement element,String dateValue) {

			JavascriptExecutor js=(JavascriptExecutor)driver;

			js.executeScript("arguments[0].setAttribute('value','"+dateValue+"');", element);

		}
}
