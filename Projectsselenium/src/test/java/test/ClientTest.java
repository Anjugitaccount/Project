package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.Client;
import page.SignIn;
import utility.FakerUtility;


public class ClientTest extends BaseTest{
  @Test(priority=1,groups={"smoke"})
  public void verifyAddClient() {
	  SignIn si=new SignIn(driver);
		 boolean retrnvalue= si.doSingin("admin@admin.com", "12345678");
		 Assert.assertTrue(retrnvalue);
	  Client client=new Client(driver);
		 String actual= client.addClient("obsqura_Test18",FakerUtility.phoneNumber(),"http://newobsqura.com/");
		 Assert.assertEquals(actual,"obsqura_Test18");
		
  }
  @Test(priority=2,groups={"smoke"})
  public void verifySerch() {
	  SignIn si=new SignIn(driver);
		 boolean retrnvalue= si.doSingin("admin@admin.com", "12345678");
		 Assert.assertTrue(retrnvalue);
	  Client client=new Client(driver);
	  client.clickClient();
		 String actual= client.searchClient("obsqura_Test18");
		 Assert.assertEquals(actual,"obsqura_Test18");
		
  }
  
  @Test(priority=3,groups={"smoke"},retryAnalyzer = generaltests.Retry.class)
  public void verifyEditClient() {
	  SignIn si=new SignIn(driver);
	  boolean retrnvalue= si.doSingin("admin@admin.com", "12345678");
		 Assert.assertTrue(retrnvalue);
	  Client client=new Client(driver);
		 String actual= client.editClient("obsqura_Test18","obsqura_Test19");
		 String expected="obsqura_Test19";
		 Assert.assertEquals(actual,expected);
  }
  
  @Test(priority=4,groups={"smoke"})
  public void verifyDeleteClient() {
	  SignIn si=new SignIn(driver);
	  boolean retrnvalue= si.doSingin("admin@admin.com", "12345678");
		 Assert.assertTrue(retrnvalue);
	  Client client=new Client(driver);
	  String actual=client.deleteClient("obsqura_Test19");
	  String expected="No record found.";
	  Assert.assertEquals(actual,expected);
 }
}
