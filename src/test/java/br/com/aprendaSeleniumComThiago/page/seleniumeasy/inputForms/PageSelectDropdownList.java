package br.com.aprendaSeleniumComThiago.page.seleniumeasy.inputForms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.aprendaSeleniumComThiago.core.CorePage;

public class PageSelectDropdownList extends CorePage<PageSelectDropdownList> {
	public PageSelectDropdownList(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "select-demo")
	WebElement selectDemoElement;
	
	
	
}
