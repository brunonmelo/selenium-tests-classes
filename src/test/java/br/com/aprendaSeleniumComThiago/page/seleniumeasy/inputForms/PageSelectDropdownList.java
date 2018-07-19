package br.com.aprendaSeleniumComThiago.page.seleniumeasy.inputForms;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.aprendaSeleniumComThiago.core.CorePage;

public class PageSelectDropdownList extends CorePage<PageSelectDropdownList> {

	public PageSelectDropdownList(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "select-demo")
	WebElement selectElement;
	
	@FindBy(xpath = "//div[@id='easycont']/div/div[2]/div/div[2]/p[2]")
	WebElement textResultSelectElement;
	
	@FindBy(id = "multi-select")
	WebElement multiSelectElement;
	
	@FindBy(xpath = "//*[@id='easycont']/div/div[2]/div[2]/div[2]/p[2]")
	WebElement textResultMultiSelectElement;
	
	@FindBy(id = "printMe")
	WebElement buttonPrintMeElement;
	
	@FindBy(id = "printAll")
	WebElement buttonPrintAllElement;
	
	public boolean isSelectedElement(DropDownList itemList) {
		selectElementByVisibleText(selectElement, itemList.name());
		return textResultSelectElement.getText().equals("Day selected :- " + itemList.name());
	}

	public boolean isPrintMultipleSelectionNoneSelectedElement() {
		click(buttonPrintMeElement);
		return getTextElement(textResultMultiSelectElement)
				.equals("First selected option is : undefined");
	}
	
	public boolean isPrintSingleSelectionFirstSelectedElement(MultiSelectDownList item) {
		selectElementByVisibleText(multiSelectElement, item.getValue());
		click(buttonPrintMeElement);
		return getTextElement(textResultMultiSelectElement)
				.equals("First selected option is : " + item.getValue());
	}
	
	public boolean isPrintMultipleSelectionFirstSelectedElement(List<MultiSelectDownList> itens) {
		for (int i = 0; i < itens.size(); i++) {			
			multiSelectElement.sendKeys(Keys.CONTROL);
			selectElementByVisibleText(multiSelectElement, itens.get(i).getValue());

		}
		
		click(buttonPrintMeElement);
		System.out.println(getTextElement(textResultMultiSelectElement));
		System.out.println("First selected option is : " + itens.get(0).getValue());
		return getTextElement(textResultMultiSelectElement)
				.equals("First selected option is : " + itens.get(0).getValue());
	}
	
	public boolean isPrintMultipleSelectionAllSelectedElement(List<MultiSelectDownList> itens) {
		for (int i = 0; i < itens.size(); i++) {
			multiSelectElement.sendKeys(Keys.CONTROL);
			selectElementByVisibleText(multiSelectElement, itens.get(i).getValue());
		}
		
		click(buttonPrintAllElement);
		System.out.println(getTextElement(textResultMultiSelectElement));
		System.out.println("First selected option is : " + itens.get(0).getValue());
		return getTextElement(textResultMultiSelectElement)
				.equals("Options selected are : " + itens.toString());
	}
	
	public static enum DropDownList {
		Sunday,
		Monday,
		Tuesday,
		Wednesday,
		Thursday,
		Friday,
		Saturday
	}
	
	public static enum MultiSelectDownList {
		Florida("Florida"),
		New_Jersey("New Jersey"),
		New_York("New York"),
		Ohio("Ohio"),
		Texas("Texas"),
		Pennsylvania("Pennsylvania"),
		Washington("Washington");
		
		private String value;

		MultiSelectDownList(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}
	
}


