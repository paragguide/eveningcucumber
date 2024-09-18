package testcases;

import static core.Hook.productlinks;
import static core.Hook.productsearchbox;
import static core.Page.driver;
import static utility.Report.report;
import static utility.Report.test;
import static utility.ScreenShot.takeScreenShot;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearch 
{
	public boolean x = false;
	
	@Given("i am logged in")
	public void i_am_logged_in() 
	{
	   if(Login.login == true)
	   {
		   x = true;
	   }
	}
	@When("^i search for product (.*) in price (.*)")
	public void i_search_for_product_in_price(String prodname,int price) throws Exception 
	{
	    if(x == true)
	    {
	    	test = report.createTest("Product Search-"+prodname);
	  	  
	  	  productsearchbox.clear();
	  	  productsearchbox.sendKeys(prodname+" in range "+price);
	  	  Actions a = new Actions(driver);
	  	  a.sendKeys(Keys.ENTER).perform();
	  	  
	  	  // screenshot
	  	  takeScreenShot("ProductResult-"+prodname);
	  		
	  	  
	  	 int listofproduct = productlinks.size();
	  	   if(listofproduct <= 0)
	  	   {
	  		   test.log(Status.FAIL, MarkupHelper.createLabel("Product Not Found" ,ExtentColor.RED));
	  			Assert.fail("Product not found");
	  	   }
	  	   else
	  	   {
	  		   test.log(Status.PASS, MarkupHelper.createLabel("Total products founud for "+prodname+" : "+listofproduct ,ExtentColor.GREEN));
	  		  // addtokart();
	  	   }
	    }
	}
	@Then("i should get results")
	public void i_should_get_results() 
	{
		Iterator <WebElement> it =  productlinks.iterator();
		
		while(it.hasNext())
		//for(int i=1; i <= 3; i++)
		{
			WebElement link = it.next();
			test.log(Status.PASS, MarkupHelper.createLabel(link.getText() ,ExtentColor.GREEN));
			
		}
	 
	}
}
