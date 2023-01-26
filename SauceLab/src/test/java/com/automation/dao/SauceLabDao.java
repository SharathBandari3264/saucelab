package com.automation.dao;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import com.automation.baseClass.BaseClass;
import com.automation.objectRepository.SauceLabLocators;
import com.automation.supportLibraries.Report;
import com.automation.supportLibraries.Util;
public class SauceLabDao extends BaseClass {
	private static Logger logger=LogManager.getLogger(SauceLabDao.class);
	private Util utils;
	Map<Object, String> testData;
	private SauceLabLocators slLocatorsPage;

	public SauceLabDao(String scenario) throws Exception {
		this.slLocatorsPage = PageFactory.initElements(driver, SauceLabLocators.class);
		this.utils = new Util();
	}

	public void userLogIn() throws Exception {
		logger.info("In enterCredentials");
		try {
			utils.waitForElement(slLocatorsPage.txtUsername);
			utils.type(slLocatorsPage.txtUsername, "Entered Username: ", configProp.getProperty("slUserName"));
			utils.type(slLocatorsPage.txtPassword, "Entered Password: ",configProp.getProperty("slPassword") , true);
			Report.passTestScreenshotEmbedded(driver, "SauceLab Log In", "UserLogin");
			utils.JSClick(slLocatorsPage.btnLogin);
		} catch (Exception e) {
		}
	}

	public void addproductToCart() throws Exception{
		utils.waitForElement(slLocatorsPage.addItemToCart);
		Report.passTestScreenshotEmbedded(driver, "SauceLab", "PRODUCTS");
		utils.JSClick(slLocatorsPage.addItemToCart);
		Report.passTestScreenshotEmbedded(driver, "SauceLab", "PRODUCTS-Add Item to Cart");
		utils.JSClick(slLocatorsPage.btnCart);
		Report.passTestScreenshotEmbedded(driver, "SauceLab", "YOUR CART");
		utils.JSClick(slLocatorsPage.btnCheckOut);
	}

	public void enterUserInfo() throws Exception {
		utils.waitForElement(slLocatorsPage.labelfName);
		utils.type(slLocatorsPage.labelfName, "Entered First Name: ",configProp.getProperty("infoFName"));
		utils.type(slLocatorsPage.labellName, "Entered Last Name: ",configProp.getProperty("infoLName"));
		utils.type(slLocatorsPage.labelPostalCode, "Entered Postalcode: ",configProp.getProperty("infoPostalCode"));
		Report.passTestScreenshotEmbedded(driver, "SauceLab", "YOUR INFORMATION");
		utils.waitForElement(slLocatorsPage.btnContinue);
	}

	public void productCheckout() throws Exception {
		utils.JSClick(slLocatorsPage.btnContinue);
		Report.passTestScreenshotEmbedded(driver, "SauceLab", "OVERVIEW");
		utils.JSClick(slLocatorsPage.btnFinish);
		Report.passTestScreenshotEmbedded(driver, "SauceLab", "BACK HOME");
		utils.JSClick(slLocatorsPage.btnHome);
	}
}
