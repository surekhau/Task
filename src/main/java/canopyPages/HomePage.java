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

	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to click on reports link in navigation bar
	 * @param driver
	 * @throws Exception
	 */
	public static void clickOnReportsLinkInNavBar(WebDriver driver) throws Exception {
		waitForElement(driver, reportsLocator);
		click(driver, reportsLocator);
	}

	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to click report template design sub menu
	 *        under reports link in nav bar
	 * @param driver
	 * @throws Exception
	 */
	public static void clickOnReportsTemplateDesign(WebDriver driver) throws Exception {
		waitForElement(driver, reportsTemplatesDesignLocator);
		click(driver, reportsTemplatesDesignLocator);
	}

	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to logout from the application
	 * @param driver
	 * @throws Exception
	 */
	public static void logoutFromTheApplication(WebDriver driver) throws Exception {
		waitForElement(driver, dropdownMenuToLogout);
		click(driver, dropdownMenuToLogout); // click on dropdown after login
		waitForElement(driver, logutLocator);
		click(driver, logutLocator); // click logout in dropdown menu
		waitForElement(driver, loginLink);
		// verifying account is logged out or not
		assertTrue("Logout not working", verifyElementPresent(driver, loginLink));
	}

	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to click on user account link in nav bar
	 * @param driver
	 * @throws Exception
	 */
	public static void clickOnUserAccountsLinkInNavBar(WebDriver driver) throws Exception {
		waitForElement(driver, userAccountsLocator);
		click(driver, userAccountsLocator);
	}

	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to click on account holdings link under user
	 *        account link in nav bar
	 * @param driver
	 * @throws Exception
	 */
	public static void clickOnAccountHoldingLink(WebDriver driver) throws Exception {
		waitForElement(driver, accountHoldingLocator);
		click(driver, accountHoldingLocator);
	}

}
