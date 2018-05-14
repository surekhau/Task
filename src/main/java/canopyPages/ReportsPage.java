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

	/**
	 * @author: Surekha
	 * @desc: This function is used to click on create button in report templage
	 *        design page
	 * @param driver
	 * @throws Exception
	 */
	public static void clickOnCreateButtonInReportsTemplatesDesign(WebDriver driver) throws Exception {
		waitForElement(driver, createButtonInRTD);
		click(driver, createButtonInRTD); // Clicking on create button
	}

	/**
	 * @author: Surekha
	 * @desc: This function clicks on save button in add/edit report template
	 *        design popup
	 * @param driver
	 * @throws Exception
	 */
	public static void clickOnSaveButtonInRTD(WebDriver driver) throws Exception {
		waitForElement(driver, saveButtonInRTD);
		click(driver, saveButtonInRTD); // clicking on Save button
	}

	/**
	 * @author: Surekha
	 * @desc: This function is used to add report template with name and style
	 *        template
	 * @param driver
	 * @throws Exception
	 */
	public static void addReportTemplate(WebDriver driver, String name, String styleTemplate) throws Exception {
		waitForElement(driver, repotNameLocator);
		sendKeys(driver, repotNameLocator, name); // filling name textfield
		waitForElement(driver, styleTemplateLocator);
		// clicking on style template dropdown
		click(driver, styleTemplateLocator);
		waitForElement(driver, baseTemplateDLLocatoer);
		// selecting BaseTemplateDL from style template
		click(driver, baseTemplateDLLocatoer);
		waitTill(1000);
		clickOnSaveButtonInRTD(driver); // Click on Save button
	}

	/**
	 * @author: Surekha
	 * @desc: This function is used to fill the name textbox in filters of RDT
	 *        table
	 * @param driver
	 * @throws Exception
	 */
	public static void fillNameTextboxInFiltersOfTableRDT(WebDriver driver, String name) throws Exception {
		waitForElement(driver, nameSearchBoxInRTDTable);
		// clear the text if it is available
		clear(driver, nameSearchBoxInRTDTable);
		// filling the name textbox
		sendKeys(driver, nameSearchBoxInRTDTable, name);
		hitEnter(driver, nameSearchBoxInRTDTable); // click on Enter in keyboard
	}

	/**
	 * @author: Surekha
	 * @desc: This function is used to verify whether the search results are
	 *        matching with the filters criteria (Name)
	 * @param driver
	 * @throws Exception
	 */
	public static void verifySearchResultsWithName(WebDriver driver, String name) throws Exception {
		waitForElement(driver,
				By.xpath("//tbody[contains(.,'My Templates: yes')]//td[@role='gridcell' and text()='" + name + "']"));
		assertTrue("Created template " + name + " is not present in table", verifyElementPresent(driver,
				By.xpath("//tbody[contains(.,'My Templates: yes')]//td[@role='gridcell' and text()='" + name + "']")));
	}

	/**
	 * @author: Surekha
	 * @desc: This function is used to click on edit template icon in RDT Table
	 *        for a particular row
	 * @param driver
	 * @throws Exception
	 */
	public static void clickOnTheEditTemplateIcon(WebDriver driver) throws Exception {
		waitForElement(driver, editTemplateIconLocator);
		click(driver, editTemplateIconLocator);
	}

	/**
	 * @author: Surekha
	 * @desc: This funciton is used to change the status to ready to assign and
	 *        click on save button
	 * @param driver
	 * @throws Exception
	 */
	public static void changeTheStatusToReadyToAssignAndClickOnSaveButton(WebDriver driver) throws Exception {
		waitForElement(driver, statusDropdownLocator);
		click(driver, statusDropdownLocator); // click on status dropdown
		waitTill(1000);
		waitForElement(driver, valueInStatusDropdown);
		click(driver, valueInStatusDropdown);
		// select ready to assign value in dropdown
		clickOnSaveButtonInRTD(driver); // click on save
	}

	/**
	 * @author: Surekha
	 * @desc: This function is used to verify whether the satus changed to ready
	 *        to assign or not
	 * @param driver
	 * @throws Exception
	 */
	public static void verifyTheStatusChangeInRTD(WebDriver driver, String name) throws Exception {
		waitForElement(driver, By.xpath("//tr[contains(.,'" + name + "') and contains(.,'Ready To Assign')]"));
		assertTrue("Status is not changed to Ready to Assign", verifyElementPresent(driver,
				By.xpath("//tr[contains(.,'" + name + "') and contains(.,'Ready To Assign')]")));
	}

	/**
	 * @author: Surekha
	 * @desc: This function is used to click on copy template icon
	 * @param driver
	 * @throws Exception
	 */
	public static void clickOnTheCopyTemplateIcon(WebDriver driver) throws Exception {
		waitForElement(driver, copyTemplateIconLocator);
		click(driver, copyTemplateIconLocator);
	}

	/**
	 * @author: Surekha
	 * @desc: This function is used to change the template name and click on
	 *        save button
	 * @param driver
	 * @throws Exception
	 */
	public static void changeTemplateNameAndClickOnSaveButton(WebDriver driver, String name) throws Exception {
		waitForElement(driver, repotNameLocator);
		clear(driver, repotNameLocator); // clear the exisisting name
		waitTill(1000);
		sendKeys(driver, repotNameLocator, name); // fill new name
		click(driver, By.xpath("//div[@class='modal-body']"));
		waitForElement(driver, saveButtonInRTD);
		click(driver, saveButtonInRTD); // click on save button
	}

	/**
	 * @author: Surekha
	 * @desc: This function is used to delete report template and verify whether
	 *        the template is deleted or not
	 * @param driver
	 * @throws Exception
	 */
	public static void deleteReportTemplateAndVerifyTheTemplatesNoLongerPresentInTable(WebDriver driver, String name)
			throws Exception {
		waitForElement(driver, By.xpath("//tr[contains(.,'" + name + "')]//span[@class='k-icon k-i-delete']"));
		// click on delete icon
		click(driver, By.xpath("//tr[contains(.,'" + name + "')]//span[@class='k-icon k-i-delete']"));
		waitForElement(driver, clickOnOkButtonInModelWindow);
		// click on Ok button in delete model window
		click(driver, clickOnOkButtonInModelWindow);
		waitTill(1000);
		// verifying whether the template deleted or not
		assertFalse(name + " template is not deleted", verifyElementPresent(driver,
				By.xpath("//tr[contains(.,'" + name + "')]//span[@class='k-icon k-i-delete']")));

	}

}
