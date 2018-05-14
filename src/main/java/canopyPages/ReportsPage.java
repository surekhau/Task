package canopyPages;

import static core.PageFactory.Action.clear;
import static core.PageFactory.Action.click;
import static core.PageFactory.Action.hitEnter;
import static core.PageFactory.Action.sendKeys;
import static core.PageFactory.Action.verifyElementPresent;
import static core.PageFactory.Action.waitForElement;
import static core.PageFactory.Action.waitTill;
import static core.PageFactory.GlobalConstants.baseTemplateDLLocatoer;
import static core.PageFactory.GlobalConstants.clickOnOkButtonInModelWindow;
import static core.PageFactory.GlobalConstants.copyTemplateIconLocator;
import static core.PageFactory.GlobalConstants.createButtonInRTD;
import static core.PageFactory.GlobalConstants.editTemplateIconLocator;
import static core.PageFactory.GlobalConstants.nameSearchBoxInRTDTable;
import static core.PageFactory.GlobalConstants.repotNameLocator;
import static core.PageFactory.GlobalConstants.saveButtonInRTD;
import static core.PageFactory.GlobalConstants.statusDropdownLocator;
import static core.PageFactory.GlobalConstants.styleTemplateLocator;
import static core.PageFactory.GlobalConstants.valueInStatusDropdown;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReportsPage {

	public static void clickOnCreateButtonInReportsTemplatesDesign(WebDriver driver) throws Exception {
		waitForElement(driver, createButtonInRTD);
		click(driver, createButtonInRTD);
	}

	public static void clickOnSaveButtonInRTD(WebDriver driver) throws Exception {
		waitForElement(driver, saveButtonInRTD);
		click(driver, saveButtonInRTD);
	}

	public static void addReportTemplate(WebDriver driver, String name, String styleTemplate) throws Exception {
		waitForElement(driver, repotNameLocator);
		sendKeys(driver, repotNameLocator, name);
		waitForElement(driver, styleTemplateLocator);
		click(driver, styleTemplateLocator);
		waitForElement(driver, baseTemplateDLLocatoer);
		click(driver, baseTemplateDLLocatoer);
		waitTill(1000);
		clickOnSaveButtonInRTD(driver);
	}

	public static void fillNameTextboxInFiltersOfTableRDT(WebDriver driver, String name) throws Exception {
		waitForElement(driver, nameSearchBoxInRTDTable);
		clear(driver, nameSearchBoxInRTDTable);
		sendKeys(driver, nameSearchBoxInRTDTable, name);
		hitEnter(driver, nameSearchBoxInRTDTable);
	}

	public static void verifySearchResultsWithName(WebDriver driver, String name) throws Exception {
		waitForElement(driver,
				By.xpath("//tbody[contains(.,'My Templates: yes')]//td[@role='gridcell' and text()='" + name + "']"));
		assertTrue("Created template " + name + " is not present in table", verifyElementPresent(driver,
				By.xpath("//tbody[contains(.,'My Templates: yes')]//td[@role='gridcell' and text()='" + name + "']")));
	}

	public static void clickOnTheEditTemplateIcon(WebDriver driver) throws Exception {
		waitForElement(driver, editTemplateIconLocator);
		click(driver, editTemplateIconLocator);
	}

	public static void changeTheStatusToReadyToAssignAndClickOnSaveButton(WebDriver driver) throws Exception {
		waitForElement(driver, statusDropdownLocator);
		click(driver, statusDropdownLocator);
		waitTill(1000);
		waitForElement(driver, valueInStatusDropdown);
		click(driver, valueInStatusDropdown);
		clickOnSaveButtonInRTD(driver);
	}

	public static void verifyTheStatusChangeInRTD(WebDriver driver, String name) throws Exception {
		waitForElement(driver, By.xpath("//tr[contains(.,'" + name + "') and contains(.,'Ready To Assign')]"));
		assertTrue("Status is not changed to Ready to Assign", verifyElementPresent(driver,
				By.xpath("//tr[contains(.,'" + name + "') and contains(.,'Ready To Assign')]")));
	}

	public static void clickOnTheCopyTemplateIcon(WebDriver driver) throws Exception {
		waitForElement(driver, copyTemplateIconLocator);
		click(driver, copyTemplateIconLocator);
	}

	public static void changeTemplateNameAndClickOnSaveButton(WebDriver driver, String name) throws Exception {
		waitForElement(driver, repotNameLocator);
		clear(driver, repotNameLocator);
		waitTill(1000);
		sendKeys(driver, repotNameLocator, name);
		click(driver, By.xpath("//div[@class='modal-body']"));
		waitForElement(driver, saveButtonInRTD);
		click(driver, saveButtonInRTD);
	}

	public static void deleteReportTemplateAndVerifyTheTemplatesNoLongerPresentInTable(WebDriver driver, String name)
			throws Exception {
		waitForElement(driver, By.xpath("//tr[contains(.,'" + name + "')]//span[@class='k-icon k-i-delete']"));
		click(driver, By.xpath("//tr[contains(.,'" + name + "')]//span[@class='k-icon k-i-delete']"));
		waitForElement(driver, clickOnOkButtonInModelWindow);
		click(driver, clickOnOkButtonInModelWindow);
		waitTill(1000);
		assertFalse(name + " template is not deleted", verifyElementPresent(driver,
				By.xpath("//tr[contains(.,'" + name + "')]//span[@class='k-icon k-i-delete']")));

	}

}
