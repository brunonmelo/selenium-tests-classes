package br.com.aprendaSeleniumComThiago.page.seleniumeasy.inputForms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSimpleForm {
	
//	private WebDriver driver;

	public PageSimpleForm(WebDriver driver) {
//		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-message")
	WebElement userMessageInput;

	@FindBy(css = "button.btn.btn-default")
	WebElement showMessageButton;
	
	@FindBy(id = "display")
	WebElement displayMessager;

	@FindBy(id = "sum1")
	WebElement inputSum1;

	@FindBy(id = "sum2")
	WebElement inputSum2;
	
	@FindBy(css = "#gettotal > button.btn.btn-default")
	WebElement getTotalButton;
	
	@FindBy(id = "displayvalue")
	WebElement sumResult;
	
	
	public String getInputMessager(String messager) {
		userMessageInput.clear();
		userMessageInput.sendKeys(messager);
		showMessageButton.click();
		return displayMessager.getText();
	}
	
	public String getSumMessager(String sum1, String sum2) {
		inputSum1.clear();
		inputSum2.clear();
		
		inputSum1.sendKeys(sum1);
		inputSum2.sendKeys(sum2);
		
		getTotalButton.click();
		
		return sumResult.getText();
	}
	
}
