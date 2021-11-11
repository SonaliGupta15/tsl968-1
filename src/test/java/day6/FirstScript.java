package day6;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FirstScript {
	WebDriver driver;
	ExtentReports ex;

	@Test
	public void dropDownExample() {
		// To specify that I am working on Extent reports.
		ExtentReports ex = new ExtentReports();
		// To specify that I am working on html reports and to give file name.
		ex.attachReporter(new ExtentHtmlReporter("facebook.html"));
		ExtentTest tc1 = ex.createTest("dropDownExample");
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tc1.info("Setting implicit wait time");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		tc1.info("Opening Url");
		driver.get("https://www.facebook.com/");
		try {
			Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
			tc1.pass("Title verified & It is Passed");
		} catch (AssertionError E) {
			tc1.fail(E.getMessage()); // for failing Extent report
			Assert.fail(E.getMessage()); // for failing TestNG report
		}
		tc1.info("clicking on create New Account");
		driver.findElement(By.linkText("Create New Account")).click();
		tc1.info("Selecting Day of Birth");
		Select day = new Select(driver.findElement(By.name("birthday_day")));
		day.selectByVisibleText("15");
		tc1.info("Selecting Month of Birth");
		Select month = new Select(driver.findElement(By.name("birthday_month")));
		month.selectByVisibleText("Oct");
		tc1.info("Selecting Year of Birth");
		Select year = new Select(driver.findElement(By.name("birthday_year")));
		year.selectByVisibleText("1998");
		tc1.pass("Select from DropDown Completed");

	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		ex.flush(); // For writing report in actual memory
	}

}
