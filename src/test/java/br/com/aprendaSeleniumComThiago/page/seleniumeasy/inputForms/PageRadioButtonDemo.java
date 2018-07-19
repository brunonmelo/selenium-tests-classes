package br.com.aprendaSeleniumComThiago.page.seleniumeasy.inputForms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageRadioButtonDemo {
	private static final String RADIO_NOT_CHECKED = "Radio button is Not checked";
	public static final String ZERO_TO_FIVE = "0 - 5";
	public static final String FIVE_TO_FIFTEEN = "5 - 15";
	public static final String FIFTEEN_TO_FIFTY = "15 - 50";
	public static final String MALE = "Male";
	public static final String FEMALE = "Female";
	
	WebDriver driver;

	public PageRadioButtonDemo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//input[@name='optradio'])[1]")
	WebElement maleRadioElement;

	@FindBy(xpath = "(//input[@name='optradio'])[2]")
	WebElement femaleRadioElement;
	
	@FindBy(id = "buttoncheck")
	WebElement buttonGenderCheckElement;
	
	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[3]")
	WebElement textGenderResult;
	
	@FindBy(xpath = "(//input[@name='gender'])[1]")
	WebElement maleGruopRadioElement;

	@FindBy(xpath = "(//input[@name='gender'])[2]")
	WebElement femaleGruopRadioElement;
	
	@FindBy(xpath = "(//input[@name='ageGroup'])[1]")
	WebElement ageGroup0To5RadioElement;
	
	@FindBy(xpath = "(//input[@name='ageGroup'])[2]")
	WebElement ageGroup5To15RadioElement;
	
	@FindBy(xpath = "(//input[@name='ageGroup'])[3]")
	WebElement ageGroup15To50RadioElement;
	
	@FindBy(css = "div.panel-body > button.btn.btn-default")
	WebElement buttonGroupElement;
	
	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]")
	WebElement textGroupResultElement;
	
	public void checkElement(WebElement elemento) {
		elemento.click();
	}
	
	public boolean isSelectedGender(String gender) {
		buttonGenderCheckElement.click();
		String msg = "Radio button '" + gender + "' is checked";
		return textGenderResult.getText().equals(msg);
	}
	
	public boolean isNotSelectedGender() {
		buttonGenderCheckElement.click();
		return textGenderResult.getText().equals(RADIO_NOT_CHECKED);
	}
	
	public boolean isGroupSelected(String gender, String ageGroup) {
		buttonGroupElement.click();
		String resultText = textGroupResultElement.getText();
		boolean isGenderMatch = resultText.contains("Sex : " + gender);		
		boolean isAgeGroupMatch = resultText.contains("Age group: " + ageGroup);
		
		return isGenderMatch && isAgeGroupMatch;
	}
	
	// getters
	public WebElement getMaleRadioElement() {
		return maleRadioElement;
	}

	public WebElement getFemaleRadioElement() {
		return femaleRadioElement;
	}

	public WebElement getMaleGruopRadioElement() {
		return maleGruopRadioElement;
	}

	public WebElement getFemaleGruopRadioElement() {
		return femaleGruopRadioElement;
	}

	public WebElement getAgeGroup0To5RadioElement() {
		return ageGroup0To5RadioElement;
	}

	public WebElement getAgeGroup5To15RadioElement() {
		return ageGroup5To15RadioElement;
	}

	public WebElement getAgeGroup15To50RadioElement() {
		return ageGroup15To50RadioElement;
	}
	
	
	

}
