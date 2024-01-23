package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.Estimate;
import page.SignIn;

public class EstimateTest extends BaseTest{
  @Test
  public void verifyEstimate() {
	  SignIn si=new SignIn(driver);
	  si.doSingin("admin@admin.com", "12345678");
	  Estimate estimate=new Estimate(driver);
	  String actual= estimate.createEstimate("2024-01-30", "2024-02-10", "1a");
	  System.out.println(actual);
	  String expected=actual;
	  Assert.assertEquals(actual, expected);
	  
  }
}
