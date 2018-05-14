package core.PageFactory;

import static core.PageFactory.GlobalConstants.CHROMEpATH;
import static core.PageFactory.GlobalConstants.baseUrl;

import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import junit.framework.TestCase;

public class BaseTestCase extends TestCase {
	public static WebDriver driver;

	@Rule
	public TestName testName = new TestName();

	@Override
	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", CHROMEpATH);
		Thread.sleep(1000);
		driver = new ChromeDriver();
		System.out.println(baseUrl);
		driver.get(baseUrl);
	}

	@Override
	@AfterClass
	public void tearDown() throws Exception {
		System.out.println("END : " + this.getClass().getSimpleName());
		System.out.println("End : " + testName.getMethodName());
		System.out.println("---------------ENDED BROWSER----------------------");
		driver.quit();
	}

}
