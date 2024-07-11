package testpkg;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import pagepkg.RedwolfPage;
import utilitiespkg.ExcelUtilities;

public class RedwolfTest {

	WebDriver driver;
	RedwolfPage redwolfPage;
	ExtentSparkReporter reporter;
	ExtentTest test;
	ExtentReports extent;
	String baseUrl="https://www.redwolf.in";
	
	
	@BeforeTest
	public void beftest(){
		reporter=new ExtentSparkReporter("reports/redwolfReport.html");
		reporter.config().setDocumentTitle("Automationreport");
		reporter.config().setReportName("functional test");
		reporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("OS", "windows10");
		extent.setSystemInfo("Tester_name", "Gopika");
		extent.setSystemInfo("Browser Name", "Chrome");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
	}
		
	
	
	@BeforeMethod
	public void setup() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		redwolfPage = new RedwolfPage(driver);

	}
	
	//testing wether the logo is redirecting to the home page 
	@Test()
	public void logo() {
		test=extent.createTest("Logo test");
		redwolfPage.logo();
	}
	
	//testing the registration of a new user
	@Test()
	public void registerTest() {
		test=extent.createTest("RegistrationTest");
		redwolfPage.register();
	}
	
	//testing the login of the exisiting user using data driven method
	@Test(enabled=false)
	public void loginTestUsingDataDriven() throws InterruptedException, IOException {
		test=extent.createTest("Login using data driven method ");
		List<String[]> loginDataList = ExcelUtilities.getLoginData();

        for (String[] loginData : loginDataList) {
            String email = loginData[0];
            String password = loginData[1];
            redwolfPage.loginusingDataDriven(email, password);
            Thread.sleep(5000);
        }
	}
	
	//login without data driven 
	@Test()
	public void loginTest() {
		test=extent.createTest("LoginUsingEmailandPass");
		redwolfPage.login();
	}
	
	//testing the search 
	@Test()
	public void searchTest() {
		test=extent.createTest("SearchTest");
		redwolfPage.search();
	}
	
	//testing the dropdown of home page
	@Test()
	public void homepageDropdownTest() {
		test=extent.createTest("HomepageDropdownTest");
		redwolfPage.homePageDropdown();
	}
	
	//testing the add to cart function
	@Test(dependsOnMethods = {"loginTest"})
	public void addtocartTest() {
		test=extent.createTest("AddtocartTest");
		redwolfPage.addtocart();
	}
	
	//testing the checkout function
	@Test(dependsOnMethods = {"addtocartTest"})
	public void checkout() {
		test=extent.createTest("CheckoutTest");
		redwolfPage.checkout();
	}
	
	//testing wishlist
	@Test(dependsOnMethods = {"loginTest"})
	public void wishlistTest() {
		test=extent.createTest("AddingtoWishlistTest");
		redwolfPage.wishlist();
	}
	
	//testing wether the product can be removed from the wishlist
	@Test(dependsOnMethods = {"wishlistTest"})
	public void removeProductFromWishlistTest() {
		test=extent.createTest("RemovefromWishlisttest");
		redwolfPage.removePrdocuFromWishlist();
	}
	
	//logout
	@Test(dependsOnMethods = {"loginTest"})
	public void logoutTest() {
		test=extent.createTest("LogoutTest");
		redwolfPage.logout();
	}
	
	@AfterTest
	public void teardown() {
		if(driver!=null) {
			driver.close();
		}
	}
	
	@AfterMethod
	public void browserclose(ITestResult result) throws IOException{

	if(result.getStatus()==ITestResult.FAILURE){
		test.log(Status.FAIL, "test case failed is"+result.getName());
		test.log(Status.FAIL, "test case failed is"+result.getThrowable());
		String screenshotpath=RedwolfTest.screenshotMethod(driver,result.getName());
		test.addScreenCaptureFromPath(screenshotpath);
		
	}else if(result.getStatus()==ITestResult.SKIP){
		test.log(Status.SKIP, "test case skipped is"+result.getName());
	}
	else if(result.getStatus()==ITestResult.SUCCESS){
		test.log(Status.PASS, "test case Passed is"+result.getName());
	}
	 
}
	
	public static String screenshotMethod(WebDriver driver,String screenshotname) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination="screenshots/"+screenshotname +".png";
		File finaldestination=new File(destination);
		FileHandler.copy(src, finaldestination);
		FileHandler.copy(src, new File(destination));
		return destination;
	}
}
