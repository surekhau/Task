package canopyPages;

import static core.PageFactory.Action.click;
import static core.PageFactory.Action.getText;
import static core.PageFactory.Action.sendKeys;
import static core.PageFactory.Action.verifyElementPresent;
import static core.PageFactory.Action.waitForElement;
import static core.PageFactory.Action.waitTill;
import static core.PageFactory.GlobalConstants.accountDropdownLocatore;
import static core.PageFactory.GlobalConstants.accountValueLocator;
import static core.PageFactory.GlobalConstants.applyFiltersButton;
import static core.PageFactory.GlobalConstants.currentValueUSDLocatoer;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class UserAccountsPage {

	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to fill user in account dropdown
	 * @param driver
	 * @throws Exception
	 */
	public static void fillTextInAccountDropdown(WebDriver driver) throws Exception {
		waitTill(100);
		waitForElement(driver, accountDropdownLocatore);
		waitTill(3000);
		sendKeys(driver, accountDropdownLocatore, "acdc4ever");
		waitTill(7000);
		driver.findElement(accountValueLocator).sendKeys(Keys.ENTER);
	}

	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to click on apply filters button
	 * @param driver
	 * @throws Exception
	 */
	public static void clickOnApplyFiltersButton(WebDriver driver) throws Exception {
		waitForElement(driver, applyFiltersButton);
		click(driver, applyFiltersButton);
	}

	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to take current value in used in network as
	 *        of date and return the value
	 * @param driver
	 * @throws Exception
	 */
	public static double takeCurrentValueUsd(WebDriver driver) throws Exception {
		waitForElement(driver, currentValueUSDLocatoer);
		// taking current value used as string value
		String currentVal = getText(driver, currentValueUSDLocatoer);
		// replace all commans(,)
		currentVal = currentVal.replaceAll(",", "").trim();
		// parsing string value as double
		double currentValue = Double.parseDouble(currentVal);
		return currentValue;
	}

	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to total value in each header and add all
	 *        the values and return the value
	 * @param driver
	 * @throws Exception
	 */
	public static double sumOfTheTotalValuesInContractTypeHeaders(WebDriver driver) throws Exception {
		double totalValue = 0;
		String headings[] = { "CASH", "EQUITIES", "BONDS", "FUNDS", "DERIVATIVES", "NON-MARK-TO-MARKET", "INSURANCE",
				"REAL-ESTATE", "OTHERS" };
		for (int i = 0; i < headings.length; i++) {
			if (verifyElementPresent(driver,
					By.xpath("//li[contains(@class,'highlight')]//span[contains(text(),'" + headings[i] + "')]"))) {
				// click on the blue color header
				click(driver,
						By.xpath("//li[contains(@class,'highlight')]//span[contains(text(),'" + headings[i] + "')]"));
				waitForElement(driver, By.xpath("//ul[contains(.,'CASH')]//td[contains(.,'Total')]"));
				// take total value
				String totVal = getText(driver, By.xpath("//ul[contains(.,'CASH')]//td[contains(.,'Total')]"));
				// replace Total:
				totVal = totVal.replaceAll("Total:", "").trim();
				// replace all commas(,)
				totVal = totVal.replaceAll(",", "").trim();
				// parse value as double
				double totalVal = Double.parseDouble(totVal);
				totalValue = totalValue + totalVal;// adding values
			}
		}
		return totalValue;
	}

	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to validate the total value in networth and
	 *        total values in headers
	 * @param driver
	 * @throws Exception
	 */
	public static void validateTheTotalRestultInNetworthAndInTotalValueInHeaders(WebDriver driver, double totVal,
			double sumOfTotalValues) throws Exception {
		assertTrue("Total in Networth value is not equal to sum of total values in headers",
				totVal == sumOfTotalValues);
	}

}
