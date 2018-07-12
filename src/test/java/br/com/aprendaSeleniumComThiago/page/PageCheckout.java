package br.com.aprendaSeleniumComThiago.page;

import java.util.Collection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCheckout {
	
	private WebDriver driver;

	public PageCheckout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div")
	WebElement resultElement;
	
	public boolean contaisItens(Collection<String> itens) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(resultElement, "Voce pediu:"));
		
		for (String item : itens) {
			boolean isContais = resultElement
					.getText()
					.toLowerCase()
					.contains(item.toLowerCase());
			
				if(!isContais) return false;
		}
		
		return true;
	}
	
	public boolean contaisItens(String item) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(resultElement));
		
		if(!resultElement
				.getText()
				.toLowerCase()
				.contains(item.toLowerCase())) {
			return false;
		}
		
		return true;
	}

}
