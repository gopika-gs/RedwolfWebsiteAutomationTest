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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
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
	
	
	@BeforeClass
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

        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        redwolfPage = new RedwolfPage(driver);
	}
		
	
	@Test(priority=3)
	public void logo() {
		test=extent.createTest("Logo test");
		redwolfPage.logo();
		test.log(Status.PASS, "Logo test passed.");
	}
	
	@Test(priority = 1)
	public void registerTest() {
		test=extent.createTest("RegistrationTest");
		redwolfPage.register();
		test.log(Status.PASS, "Registration test passed.");
	}
	
	@Test(priority = 2)
	public void loginTestUsingDataDriven() throws InterruptedException, IOException {
		test=extent.createTest("Login using data driven method ");
		List<String[]> loginDataList = ExcelUtilities.getLoginData();

        for (String[] loginData : loginDataList) {
            String email = loginData[0];
            String password = loginData[1];
            redwolfPage.loginusingDataDriven(email, password);
            Thread.sleep(5000);
        }
        test.log(Status.PASS, "Login using data driven method passed.");
        driver.navigate().to(baseUrl); 
	}
	
//	@Test()
//	public void loginTest() {
//		test=extent.createTest("LoginUsingEmailandPass");
//		redwolfPage.login();
//		test.log(Status.PASS, "Login test passed.");
//	}
	
	@Test(priority = 4)
	public void searchTest() {
		test=extent.createTest("SearchTest");
		redwolfPage.search();
		test.log(Status.PASS, "Search test passed.");
	}
	
	@Test(priority = 5)
	public void homepageDropdownTest() {
		test=extent.createTest("HomepageDropdownTest");
		redwolfPage.homePageDropdown();
		test.log(Status.PASS, "Homepage dropdown test passed.");
	}
	
	@Test(priority = 6,dependsOnMethods = {"loginTestUsingDataDriven"})
	public void addtocartTest() {
		test=extent.createTest("AddtocartTest");
		redwolfPage.addtocart();
		test.log(Status.PASS, "Add to cart test passed.");
	}
	
	@Test(priority = 7,dependsOnMethods = {"addtocartTest"})
	public void checkout() {
		test=extent.createTest("CheckoutTest");
		redwolfPage.checkout();
		driver.navigate().to(baseUrl); 
		test.log(Status.PASS, "Checkout test passed.");
	}
	
	@Test(priority = 8,dependsOnMethods = {"loginTestUsingDataDriven"})
	public void wishlistTest() {
		test=extent.createTest("AddingtoWishlistTest");
		redwolfPage.wishlist();
		test.log(Status.PASS, "Wishlist test passed.");
	}
	
	@Test(priority = 9,dependsOnMethods = {"wishlistTest"})
	public void removeProductFromWishlistTest() {
		test=extent.createTest("RemovefromWishlisttest");
		redwolfPage.removePrdocuFromWishlist();
		test.log(Status.PASS, "Remove product from wishlist test passed.");
		driver.navigate().to(baseUrl); 
	}
	
	@Test(priority = 10,dependsOnMethods = {"loginTestUsingDataDriven"})
	public void logoutTest() {
		test=extent.createTest("LogoutTest");
		redwolfPage.logout();
		test.log(Status.PASS, "Logout test passed.");
	}
	
	@AfterSuite
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
		 extent.flush();
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
