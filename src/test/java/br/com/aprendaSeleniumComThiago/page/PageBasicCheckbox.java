package br.com.aprendaSeleniumComThiago.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageBasicCheckbox {
	
	private static final String SINGLE_CHECKBOX_TEXT = "Success - Check box is checked";
	private static final String CHECK_ALL_TEXT = "Check All";
	private static final String UNCHECK_ALL_TEXT = "Uncheck All";
	
	WebDriver driver;

	public PageBasicCheckbox(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "isAgeSelected")
	WebElement checkboxAgeElement;
	
	@FindBy(id = "txtAge")
	WebElement textAgeElement;
	
	@FindBy(id = "check1")
	WebElement buttonCheckAllElement;
	
	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label/input")
	WebElement checkboxOption1;
	
	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label/input")
	WebElement checkboxOption2;
	
	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[3]/label/input")
	WebElement checkboxOption3;
	
	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[4]/label/input")
	WebElement checkboxOption4;
	
	public boolean isSingleCheckBoxTextVisible() {
		uncheckAllCheckbox();
		checkboxAgeElement.click();
		return textAgeElement.getText().equals(SINGLE_CHECKBOX_TEXT);
	}
	
	public boolean isAllCheckboxCheckedOnClickCheckAllButton() {
		uncheckAllCheckbox();
		buttonCheckAllElement.click();
		boolean selected1 = checkboxOption1.isSelected();
		boolean selected2 = checkboxOption2.isSelected();
		boolean selected3 = checkboxOption3.isSelected();
		boolean selected4 = checkboxOption4.isSelected();
		return selected1 && selected2 && selected3 && selected4;
	}
	
	public boolean isShowingTextUncheckAllOnButton() {
		uncheckAllCheckbox();
		buttonCheckAllElement.click();
		return buttonCheckAllElement.getAttribute("value").equals(UNCHECK_ALL_TEXT);
	}
	
	public boolean isShowingTextCheckAllOnButton() {
		uncheckAllCheckbox();
		buttonCheckAllElement.click();
		checkboxOption2.click();
		return buttonCheckAllElement.getAttribute("value").equals(CHECK_ALL_TEXT);
	}
	
	private void uncheckAllCheckbox() {
		if (checkboxAgeElement.isSelected()) checkboxAgeElement.click();
		if (checkboxOption1.isSelected()) checkboxOption1.click();
		if (checkboxOption2.isSelected()) checkboxOption2.click();
		if (checkboxOption3.isSelected()) checkboxOption3.click();
		if (checkboxOption4.isSelected()) checkboxOption4.click();
	}
		
	
}
