package testcases;

import static utility.Report.report;
import static utility.Report.test;

import org.junit.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends Hook
{
	public static boolean usrid = false;
	public static boolean x = false;
	public static boolean login = false;
	
	   // user validation..
	@Given("I open browser {string} with url {string} and init report {string} with testname {string}")
	public void i_open_browser_with_url_and_init_report_with_testname(String browser, String url, String reportname, String testname) throws Exception 
	{
		beforeTest(browser,url,reportname,testname);
		test = report.createTest("user validation");
	}
	
	@Given("click signin link")
	public void click_signin_link() 
	{
	    signin.click();
	}
	@When("i enter valid userid {string}")
	public void i_enter_valid_userid(String usern) 
	{
	    uid.sendKeys(usern);
	}
	@When("click continue button")
	public void click_continue_button() 
	{
	    ctnbtn.click();
	}
	@Then("I error should not come")
	public void i_error_should_not_come() 
	{
	    try {
	    	err1.getText();
	    	test.log(Status.FAIL, MarkupHelper.createLabel("uid is valid but error message coming" ,ExtentColor.RED));
			Assert.fail("uid is valid but error message coming");
	        }
	    catch(Exception e)
	    {
	    	System.out.println("in catch "+e.getMessage());
	    	//e.printStackTrace();
	    	usrid = true;
	    	System.out.println("usrid "+usrid);
	    	test.log(Status.PASS, MarkupHelper.createLabel("uid is valid" ,ExtentColor.GREEN));
	    	
	    }
	}
        // password validation..
	
	@Given("userid is valid")
	public void userid_is_valid() 
	{
		System.out.println(usrid);
		
	    if(usrid == true)
	    {
	    	System.out.println("AAAA......................");
	    	x = true;
	    }
	}
	@When("now enter valid password {string}")
	public void now_enter_valid_password(String psd) 
	{
	    if(x == true)
	    {
	    	System.out.println("BBBB......................");
	    	pwd.sendKeys(psd);
	    	submit.click();
	    }
	}
	@Then("i should login")
	public void i_should_login() 
	{
		try {
			  err2.getText();
			  test.log(Status.FAIL, MarkupHelper.createLabel("pwdd is valid but error message coming" ,ExtentColor.RED));
				Assert.fail("pwdd is valid but error message coming");
			     }
			     catch(Exception e)
			     {
			    	 test.log(Status.PASS, MarkupHelper.createLabel("pwdd is valid" ,ExtentColor.GREEN));
						login = true; 
			     }
	}
	
	@Then("close browser")
	public void close_browser()
	{
		afterTest(); 
	}
}
