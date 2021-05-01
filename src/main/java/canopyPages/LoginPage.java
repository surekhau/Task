package canopyPages;

import static core.PageFactory.Action.click;
import static core.PageFactory.Action.sendKeys;
import static core.PageFactory.Action.verifyElementPresent;
import static core.PageFactory.Action.waitForElement;
import static core.PageFactory.GlobalConstants.loginButton;
import static core.PageFactory.GlobalConstants.password;
import static core.PageFactory.GlobalConstants.passwordTextbox;
import static core.PageFactory.GlobalConstants.userName;
import static core.PageFactory.GlobalConstants.userNameTextAfterLogin;
import static core.PageFactory.GlobalConstants.userNameTextbox;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

public class LoginPage {

	/**
	 * @author: SUREKHA
	 * @Desc: This function fill the username textbox
	 * @param driver
	 * @throws Exception
	 */

	public static void fillUserName(WebDriver driver) throws Exception {
		waitForElement(driver, userNameTextbox);
		sendKeys(driver, userNameTextbox, userName);
	}

	/**
	 * @author: SUREKHA
	 * @Desc: This function fill the password textbox
	 * @param driver
	 * @throws Exception
	 */

	public static void fillPassword(WebDriver driver) throws Exception {
		waitForElement(driver, passwordTextbox);
		sendKeys(driver, passwordTextbox, password);
		System.out.println("test");
	}

	/**
	 * @author: SUREKHA
	 * @Desc: This function clicks the login button
	 * @param driver
	 * @throws Exception
	 */

	public static void clickOnLoginButton(WebDriver driver) throws Exception {
		waitForElement(driver, loginButton);
		click(driver, loginButton);
	}

	/**
	 * @author: SUREKHA
	 * @Desc: This function fill the username textbox with some text
	 * @param driver
	 * @throws Exception
	 */
	public static void verifyUserNameAfterLogin(WebDriver driver) throws Exception {
		waitForElement(driver, userNameTextAfterLogin);
		assertTrue(userName + " is not logged in", verifyElementPresent(driver, userNameTextAfterLogin));
	}

	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to login to the application with username
	 *        and password
	 * @param driver
	 * @throws Exception
	 */
	public static void loginToTheApplication(WebDriver driver) throws Exception {
		fillUserName(driver); // fill username
		fillPassword(driver); // fill password
		clickOnLoginButton(driver); // click on login
		verifyUserNameAfterLogin(driver); // verify whether logged in or not
	}

}
