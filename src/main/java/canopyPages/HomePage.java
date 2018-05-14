package canopyPages;

import static core.PageFactory.Action.click;
import static core.PageFactory.Action.verifyElementPresent;
import static core.PageFactory.Action.waitForElement;
import static core.PageFactory.GlobalConstants.accountHoldingLocator;
import static core.PageFactory.GlobalConstants.dropdownMenuToLogout;
import static core.PageFactory.GlobalConstants.loginLink;
import static core.PageFactory.GlobalConstants.logutLocator;
import static core.PageFactory.GlobalConstants.reportsLocator;
import static core.PageFactory.GlobalConstants.reportsTemplatesDesignLocator;
import static core.PageFactory.GlobalConstants.userAccountsLocator;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

public class HomePage {

	public static void clickOnReportsLinkInNavBar(WebDriver driver) throws Exception {
		waitForElement(driver, reportsLocator);
		click(driver, reportsLocator);
	}

	public static void clickOnReportsTemplateDesign(WebDriver driver) throws Exception {
		waitForElement(driver, reportsTemplatesDesignLocator);
		click(driver, reportsTemplatesDesignLocator);
	}

	public static void logoutFromTheApplication(WebDriver driver) throws Exception {
		waitForElement(driver, dropdownMenuToLogout);
		click(driver, dropdownMenuToLogout);
		waitForElement(driver, logutLocator);
		click(driver, logutLocator);
		waitForElement(driver, loginLink);
		assertTrue("Logout not working", verifyElementPresent(driver, loginLink));
	}

	public static void clickOnUserAccountsLinkInNavBar(WebDriver driver) throws Exception {
		waitForElement(driver, userAccountsLocator);
		click(driver, userAccountsLocator);
	}

	public static void clickOnAccountHoldingLink(WebDriver driver) throws Exception {
		waitForElement(driver, accountHoldingLocator);
		click(driver, accountHoldingLocator);
	}

}
