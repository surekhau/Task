package canopyTests;

import static canopyPages.HomePage.clickOnAccountHoldingLink;
import static canopyPages.HomePage.clickOnUserAccountsLinkInNavBar;
import static canopyPages.HomePage.logoutFromTheApplication;
import static canopyPages.LoginPage.loginToTheApplication;
import static canopyPages.UserAccountsPage.clickOnApplyFiltersButton;
import static canopyPages.UserAccountsPage.fillTextInAccountDropdown;
import static canopyPages.UserAccountsPage.sumOfTheTotalValuesInContractTypeHeaders;
import static canopyPages.UserAccountsPage.takeCurrentValueUsd;
import static canopyPages.UserAccountsPage.validateTheTotalRestultInNetworthAndInTotalValueInHeaders;

import org.testng.annotations.Test;

import core.PageFactory.BaseTestCase;

public class TestUserAccountsPage extends BaseTestCase {

	@Test
	public void testCalculateTotalNetwork() throws Exception {
		loginToTheApplication(driver);
		clickOnUserAccountsLinkInNavBar(driver);
		clickOnAccountHoldingLink(driver);
		fillTextInAccountDropdown(driver);
		clickOnApplyFiltersButton(driver);
		double totalValueInNetWork = takeCurrentValueUsd(driver);
		double sumOfTotalValues = sumOfTheTotalValuesInContractTypeHeaders(driver);
		validateTheTotalRestultInNetworthAndInTotalValueInHeaders(driver, totalValueInNetWork, sumOfTotalValues);
		logoutFromTheApplication(driver);
	}

}
