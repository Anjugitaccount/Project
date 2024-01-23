package test;


import org.testng.Assert;
import org.testng.annotations.Test;

import page.Client;
import page.Items;
import page.SignIn;

public class ItemsTest extends BaseTest{
	
  @Test(priority=1,groups= {"regression"})
  public void verifyItems () {
	  SignIn si=new SignIn(driver);
		 boolean retrnvalue= si.doSingin("admin@admin.com", "12345678");
		 Assert.assertTrue(retrnvalue);
	  Items item=new Items(driver);
	  String actual=item.addIteam("obsquraTest51","project","automation","10");
	  String expected="obsquraTest51";
	  Assert.assertEquals(actual,expected);
	  
  }
  @Test(priority=2,groups= {"regression"})
  public void verifySerch () {
	  SignIn si=new SignIn(driver);
		 boolean retrnvalue= si.doSingin("admin@admin.com", "12345678");
		 Assert.assertTrue(retrnvalue);
	  Items item=new Items(driver);
	  item.clickIteam();
	  String actual=item.searchIteam("obsquraTest51");
	  String expected="obsquraTest51";
	  Assert.assertEquals(actual,expected);
	  
  }
  @Test(priority=3,groups= {"regression"})
  public void verifyEditItems () {
	  SignIn si=new SignIn(driver);
	  boolean retrnvalue= si.doSingin("admin@admin.com", "12345678");
		 Assert.assertTrue(retrnvalue);
		  Items item=new Items(driver);
		  item.clickIteam();
		 String actual= item.editIteam("obsquraTest51","obsqura_Test61");
		 String expected="obsqura_Test61";
		 Assert.assertEquals(actual,expected);
  }
  @Test(priority=4,groups= {"regression"})
  public void verifyDeleteItems() {
	  SignIn si=new SignIn(driver);
	  boolean retrnvalue= si.doSingin("admin@admin.com", "12345678");
		 Assert.assertTrue(retrnvalue);
		 Items item=new Items(driver);
	  String actual=item.deleteIteam("obsqura_Test61");
	  String expected="No record found.";
	  Assert.assertEquals(actual,expected);
 }
}
