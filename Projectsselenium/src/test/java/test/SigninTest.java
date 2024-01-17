package test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Constant.Constant;
import page.SignIn;
import utility.ExcelRead;

public class SigninTest extends BaseTest {
  @Test(dataProvider="dp",groups= {"smoke","regression"})
  public void verifyLogin(String UserName,String Password) {
	  SignIn si=new SignIn(driver);
	 boolean retrnvalue= si.doSingin(UserName, Password);
	 Assert.assertTrue(retrnvalue);
	  
  }
  @DataProvider
  public Object[][] dp() throws InvalidFormatException, IOException {
		 Object [][] data=ExcelRead.getDataFromExcel(Constant.excelPath, 
					"Sheet1");
		 return data;
		 
	  }
}
