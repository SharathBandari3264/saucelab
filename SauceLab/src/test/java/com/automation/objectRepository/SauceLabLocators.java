package com.automation.objectRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceLabLocators {

	@FindBy(xpath = "//div[@class='form_group']//input[@id='user-name']")
	public WebElement txtUsername;

	@FindBy(xpath = "//div[@class='form_group']//input[@id='password']")
	public WebElement txtPassword;

	@FindBy(xpath = "//input[@id='login-button']")
	public WebElement btnLogin;

	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	public WebElement addItemToCart; 

	@FindBy(xpath = "//div[@class='shopping_cart_container']") 
	public WebElement btnCart; 

	@FindBy(xpath = "//button[@id='checkout']") 
	public WebElement btnCheckOut; 

	@FindBy(xpath = "//input[@id='first-name']") 
	public WebElement labelfName; 

	@FindBy(xpath = "//input[@id='last-name']") 
	public WebElement labellName; 

	@FindBy(xpath = "//input[@id='postal-code']") 
	public WebElement labelPostalCode; 

	@FindBy(xpath = "//input[@id='continue']") 
	public WebElement btnContinue; 

	@FindBy(xpath = "//button[@id='finish']") 
	public WebElement btnFinish;

	@FindBy(xpath = "//button[@id='back-to-products']") 
	public WebElement btnHome;
}