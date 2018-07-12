package br.com.aprendaSeleniumComThiago.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageRadioButtonDemo {
	WebDriver driver;

	public PageRadioButtonDemo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

}
