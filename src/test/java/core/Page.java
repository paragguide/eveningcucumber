package core;

import static utility.Report.generateReport;
import static utility.Report.report;
import static utility.Report.test;
import static utility.ScreenShot.takeScreenShot;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Page 
{
	public static WebDriver driver = null;
	
	public void beforeTest(String browser,String url,String reportname,String testname) throws Exception 
	  {
		  			  // report init
			  generateReport(reportname,testname);
			  
			  // browser init..
			  
			  if(browser.equalsIgnoreCase("chrome"))
				{
					driver = new ChromeDriver();
				}
				else if(browser.equalsIgnoreCase("edge"))
				{
					driver = new EdgeDriver();
				}
				else if(browser.equalsIgnoreCase("firefox"))
				{
					driver = new FirefoxDriver();
				}
				else
				{
					System.err.println("error  in inpugt..");
				}
				driver.get(url);
				
				PageFactory.initElements(driver, this); // compulsory to init driver in PageFactory to read external xpath
				
				// add comment in report..
				test.log(Status.PASS, MarkupHelper.createLabel("Browser "+browser+" url "+url+" opens.." ,ExtentColor.GREEN));
				
				// screen shot..
				takeScreenShot("openBrowser");
				
				// implicit wait.. common timeout for all element
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				driver.manage().window().maximize(); // full screen
			  
		  
	  }

	  
	  public static void afterTest() 
	  {
		  driver.quit();  // close browser session
		  
		  report.flush(); // close report
	  }


}
