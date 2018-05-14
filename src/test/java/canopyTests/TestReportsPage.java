package canopyTests;

import static canopyPages.HomePage.clickOnReportsLinkInNavBar;
import static canopyPages.HomePage.clickOnReportsTemplateDesign;
import static canopyPages.HomePage.logoutFromTheApplication;
import static canopyPages.LoginPage.loginToTheApplication;
import static canopyPages.ReportsPage.addReportTemplate;
import static canopyPages.ReportsPage.changeTemplateNameAndClickOnSaveButton;
import static canopyPages.ReportsPage.changeTheStatusToReadyToAssignAndClickOnSaveButton;
import static canopyPages.ReportsPage.clickOnCreateButtonInReportsTemplatesDesign;
import static canopyPages.ReportsPage.clickOnTheCopyTemplateIcon;
import static canopyPages.ReportsPage.clickOnTheEditTemplateIcon;
import static canopyPages.ReportsPage.deleteReportTemplateAndVerifyTheTemplatesNoLongerPresentInTable;
import static canopyPages.ReportsPage.fillNameTextboxInFiltersOfTableRDT;
import static canopyPages.ReportsPage.verifySearchResultsWithName;
import static canopyPages.ReportsPage.verifyTheStatusChangeInRTD;
import static core.PageFactory.Action.uniqueDateAndTime;

import org.testng.annotations.Test;

import core.PageFactory.BaseTestCase;

public class TestReportsPage extends BaseTestCase {
	String name;
	String name1;

	@Test(priority = 0)
	public void testCreateReportTemplate() throws Exception {
		this.name = "SurekhaTestTemplate" + uniqueDateAndTime();
		String styleTemplate = "BaseTemplateDL";
		loginToTheApplication(driver);
		clickOnReportsLinkInNavBar(driver);
		clickOnReportsTemplateDesign(driver);
		clickOnCreateButtonInReportsTemplatesDesign(driver);
		addReportTemplate(driver, this.name, styleTemplate);
		fillNameTextboxInFiltersOfTableRDT(driver, this.name);
		verifySearchResultsWithName(driver, this.name);
		logoutFromTheApplication(driver);
	}

	@Test(priority = 1)
	public void testEditReportTemplate() throws Exception {
		loginToTheApplication(driver);
		clickOnReportsLinkInNavBar(driver);
		clickOnReportsTemplateDesign(driver);
		fillNameTextboxInFiltersOfTableRDT(driver, this.name);
		clickOnTheEditTemplateIcon(driver);
		changeTheStatusToReadyToAssignAndClickOnSaveButton(driver);
		verifyTheStatusChangeInRTD(driver, this.name);
		logoutFromTheApplication(driver);
	}

	@Test(priority = 2)
	public void testCopyReportTemplate() throws Exception {
		this.name1 = "SurekhaTemp" + uniqueDateAndTime();
		loginToTheApplication(driver);
		clickOnReportsLinkInNavBar(driver);
		clickOnReportsTemplateDesign(driver);
		fillNameTextboxInFiltersOfTableRDT(driver, this.name);
		clickOnTheCopyTemplateIcon(driver);
		changeTemplateNameAndClickOnSaveButton(driver, this.name1);
		fillNameTextboxInFiltersOfTableRDT(driver, this.name1);
		verifySearchResultsWithName(driver, this.name1);
		logoutFromTheApplication(driver);
	}

	@Test(priority = 3)
	public void testDeleteReportTemplate() throws Exception {
		loginToTheApplication(driver);
		clickOnReportsLinkInNavBar(driver);
		clickOnReportsTemplateDesign(driver);
		deleteReportTemplateAndVerifyTheTemplatesNoLongerPresentInTable(driver, this.name);
		deleteReportTemplateAndVerifyTheTemplatesNoLongerPresentInTable(driver, this.name1);
		logoutFromTheApplication(driver);
	}

}
