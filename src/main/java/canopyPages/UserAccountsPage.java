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

	public static void fillTextInAccountDropdown(WebDriver driver) throws Exception {
		waitTill(100);
		waitForElement(driver, accountDropdownLocatore);
		waitTill(3000);
		sendKeys(driver, accountDropdownLocatore, "acdc4ever");
		waitTill(7000);
		driver.findElement(accountValueLocator).sendKeys(Keys.ENTER);
	}

	public static void clickOnApplyFiltersButton(WebDriver driver) throws Exception {
		waitForElement(driver, applyFiltersButton);
		click(driver, applyFiltersButton);
	}

	public static double takeCurrentValueUsd(WebDriver driver) throws Exception {
		waitForElement(driver, currentValueUSDLocatoer);
		String currentVal = getText(driver, currentValueUSDLocatoer);
		currentVal = currentVal.replaceAll(",", "").trim();
		double currentValue = Double.parseDouble(currentVal);
		return currentValue;
	}

	public static double sumOfTheTotalValuesInContractTypeHeaders(WebDriver driver) throws Exception {
		double totalValue = 0;
		String headings[] = { "CASH", "EQUITIES", "BONDS", "FUNDS", "DERIVATIVES", "NON-MARK-TO-MARKET", "INSURANCE",
				"REAL-ESTATE", "OTHERS" };
		for (int i = 0; i < headings.length; i++) {
			if (verifyElementPresent(driver,
					By.xpath("//li[contains(@class,'highlight')]//span[contains(text(),'" + headings[i] + "')]"))) {
				click(driver,
						By.xpath("//li[contains(@class,'highlight')]//span[contains(text(),'" + headings[i] + "')]"));
				waitForElement(driver, By.xpath("//ul[contains(.,'CASH')]//td[contains(.,'Total')]"));
				String totVal = getText(driver, By.xpath("//ul[contains(.,'CASH')]//td[contains(.,'Total')]"));
				totVal = totVal.replaceAll("Total:", "").trim();
				totVal = totVal.replaceAll(",", "").trim();
				double totalVal = Double.parseDouble(totVal);
				totalValue = totalValue + totalVal;
			}
		}
		return totalValue;
	}

	public static void validateTheTotalRestultInNetworthAndInTotalValueInHeaders(WebDriver driver, double totVal,
			double sumOfTotalValues) throws Exception {
		assertTrue("Total in Networth value is not equal to sum of total values in headers",
				totVal == sumOfTotalValues);
	}

}
