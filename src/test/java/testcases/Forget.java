package testcases;

import static utility.Report.report;
import static utility.Report.test;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Forget extends Hook
{
	@Given("launch {string} with url {string} and init report {string} testname {string}")
	public void launch_with_url_and_init_report_testname(String browser, String url, String reportname, String testname) throws Exception {
		beforeTest(browser,url,reportname,testname);
		test = report.createTest("forget validation");
	}
	@Given("clickon signin button")
	public void clickon_signin_button() 
	{
	   signin.click();
	}
	@When("i click on help link and forget link")
	public void i_click_on_help_link_and_forget_link() 
	{
	    help.click();
	    forgetlink.click();
	}
	@When("enter mobile number")
	public void enter_mobile_number() 
	{
	   uid.sendKeys("9999999");
	}
	@Then("send OTP")
	public void send_otp() 
	{
	    
	}


}
