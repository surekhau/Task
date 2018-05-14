package core.PageFactory;//span[@id='lnkName' and text()='at_011']

import org.openqa.selenium.By;

public class GlobalConstants {

	public static String CHROMEpATH = "C:\\chromedriver.exe";
	public static String baseUrl = "https://dev-engine.kurtosys.org";
	public static String userName = "at_011";
	public static String password = "TechGeek12!";

	public static By userNameTextbox = By.name("username");
	public static By passwordTextbox = By.name("password");
	public static By loginButton = By.xpath("//button[text()='Login']");
	public static By userNameTextAfterLogin = By.xpath("//span[@id='lnkName' and text()='" + userName + "']");
	public static By reportsLocator = By.xpath("//span[text()=' REPORTS']");
	public static By reportsTemplatesDesignLocator = By.xpath("//span[text()=' Reports Templates Design']");
	public static By createButtonInRTD = By.xpath("//a[contains(@class,'addReport') and contains(.,'Create')]");
	// RTD means Report Template Design
	public static By repotNameLocator = By.id("reportName");
	public static By styleTemplateLocator = By
			.xpath("//span[@unselectable='on'][contains(text(),'Choose style template...')]");
	public static By baseTemplateDLLocatoer = By.xpath("//li[text()='BaseTemplateDL' and @class='k-item']");
	public static By saveButtonInRTD = By.xpath("//button[text()='Save']");
	public static By nameSearchBoxInRTDTable = By
			.xpath("//thead[@class='tableFloatingHeaderOriginal']//input[@data-text-field='name']");

	public static By dropdownMenuToLogout = By.xpath("//i[@class='fa fa-caret-down']");
	public static By logutLocator = By.xpath("//a[@href='/Account/LogOff']");
	public static By loginLink = By.linkText("Login");
	public static By editTemplateIconLocator = By.xpath("//span[@class='k-icon k-i-edit']");
	public static By statusDropdownLocator = By.xpath("//span[@unselectable='on'][contains(text(),'In Progress')]");
	public static By valueInStatusDropdown = By
			.xpath("//div[@class='k-animation-container']//li[text()='Ready To Assign']");
	public static By copyTemplateIconLocator = By.xpath("//span[@class='k-icon k-i-copy']");
	public static By clickOnOkButtonInModelWindow = By.xpath("//button[@data-bb-handler='confirm']");
	public static By userAccountsLocator = By.xpath("//span[contains(text(),'USER ACCOUNTS')]");
	public static By accountHoldingLocator = By.xpath("//span[contains(text(),'Account Holdings')]");
	public static By accountDropdownLocatore = By.xpath("//input[@class='k-input k-readonly']");
	public static By accountValueLocator = By.xpath("//input[@class='k-input' and @role='listbox']");
	public static By accountValueInDropdownLoacator = By.xpath("//option[contains(.,'acdc4ever')]");
	public static By applyFiltersButton = By.xpath("//button[text()='Apply filters']");
	public static By currentValueUSDLocatoer = By.xpath("//span[contains(@data-bind,'totalNetworthInUSDFormatted')]");

}
