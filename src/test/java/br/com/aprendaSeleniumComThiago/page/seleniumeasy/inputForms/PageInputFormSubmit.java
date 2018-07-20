package br.com.aprendaSeleniumComThiago.page.seleniumeasy.inputForms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.aprendaSeleniumComThiago.core.CorePage;

public class PageInputFormSubmit extends CorePage<PageInputFormSubmit> {

	public PageInputFormSubmit(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "first_name")
	WebElement firstNameInput;
	
	@FindBy(name = "last_name")
	WebElement lastNameInput;
	
	@FindBy(name = "email")
	WebElement emailInput;
	
	@FindBy(name = "phone")
	WebElement phoneInput;
	
	@FindBy(name = "address")
	WebElement addressInput;
	
	@FindBy(name = "city")
	WebElement cityInput;
	
	@FindBy(name = "state")
	WebElement stateInput;
	
	@FindBy(name = "zip")
	WebElement zipInput;
	
	@FindBy(name = "website")
	WebElement websiteInput;
	
	@FindBy(name = "comment")
	WebElement commentInput;
	
	@FindBy(xpath = "(//input[@name='hosting'])[1]")
	WebElement hostingRadioYes;
	
	@FindBy(xpath = "(//input[@name='hosting'])[2]")
	WebElement hostingRadioNo;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[1]/div/small[1]")
	WebElement firstNameErro1;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[1]/div/small[2]")
	WebElement firstNameErro2;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[2]/div/small[1]")
	WebElement lastNameErro1;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[2]/div/small[2]")
	WebElement lastNameErro2;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[3]/div/small[1]")
	WebElement emailErro1;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[3]/div/small[2]")
	WebElement emailErro2;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[4]/div/small[1]")
	WebElement phoneErro1;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[4]/div/small[2]")
	WebElement phoneErro2;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[5]/div/small[1]")
	WebElement addressErro1;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[5]/div/small[2]")
	WebElement addressErro2;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[6]/div/small[1]")
	WebElement cityErro1;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[6]/div/small[2]")
	WebElement cityErro2;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[7]/div/small")
	WebElement stateErro;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[8]/div/small[1]")
	WebElement zipErro;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[11]/div/small[1]")
	WebElement commentErro1;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[11]/div/small[2]")
	WebElement commentErro2;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[13]/div/button")
	WebElement btnSubmit;
	
	public void preencheCampo(WebElement campo, String value) {
		preencherCampo(firstNameInput, value);
	}
	
	public void selectStateCampo(int index) {
		selectElementByIndex(stateInput, index);
	}
	
	public boolean isBtnSubmitDisabled() {
		submit();
		return !btnSubmit.isEnabled();
	}
	
	public boolean isFistNameInvalid() {
		return isVisibility(firstNameErro1) 
				|| isVisibility(firstNameErro2);
	}
	
	public boolean isLastNameInvalid() {
		return isVisibility(lastNameErro1) 
				|| isVisibility(lastNameErro2);
	}
	
	public boolean isEmailInvalid() {
		return isVisibility(emailErro1) 
				|| isVisibility(emailErro2);
	}
	
	public boolean isPhoneInvalid() {
		return isVisibility(phoneErro1) 
				|| isVisibility(phoneErro2);
	}
	
	public boolean isAddressInvalid() {
		return isVisibility(addressErro1) 
				|| isVisibility(addressErro2);
	}
	
	public boolean isCityInvalid() {
		return isVisibility(cityErro1) 
				|| isVisibility(cityErro2);
	}
	
	public boolean isStateInvalid() {
		return isVisibility(stateErro);
	}
	
	public boolean isZipInvalid() {
		return isVisibility(zipErro);
	}
	
	public boolean isCommentInvalid() {
		return isVisibility(commentErro1) 
				|| isVisibility(commentErro2);
	}
	
	public void submit() {
		click(btnSubmit);
	}

	public WebElement getFirstNameInput() {
		return firstNameInput;
	}

	public WebElement getLastNameInput() {
		return lastNameInput;
	}

	public WebElement getEmailInput() {
		return emailInput;
	}

	public WebElement getPhoneInput() {
		return phoneInput;
	}

	public WebElement getAddressInput() {
		return addressInput;
	}

	public WebElement getCityInput() {
		return cityInput;
	}

	public WebElement getWebsiteInput() {
		return websiteInput;
	}

	public WebElement getCommentInput() {
		return commentInput;
	}

	public WebElement getZipInput() {
		return zipInput;
	}
	
}
