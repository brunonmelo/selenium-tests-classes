package br.com.aprendaSeleniumComThiago.test.seleniumeasy.inputForms;

import org.junit.Assert;
import org.junit.Test;

import br.com.aprendaSeleniumComThiago.core.CoreBaseTest;
import br.com.aprendaSeleniumComThiago.page.seleniumeasy.inputForms.PageRadioButtonDemo;

public class TestRadioButton extends CoreBaseTest {
	
	public PageRadioButtonDemo navegaParaPage() {
		driver.navigate().to("http://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		return new PageRadioButtonDemo(driver);
	}
		
	@Test
	public void testSimpleRadioIsMaleGenderChecked() {
		PageRadioButtonDemo radioButtonPage = navegaParaPage();
		radioButtonPage.getMaleRadioElement().click();
		Assert.assertTrue(radioButtonPage.isSelectedGender(PageRadioButtonDemo.MALE));
	}
	
	@Test
	public void testSimpleRadioIsFemaleGenderChecked() {
		PageRadioButtonDemo radioButtonPage = navegaParaPage();
		radioButtonPage.getFemaleRadioElement().click();
		Assert.assertTrue(radioButtonPage.isSelectedGender(PageRadioButtonDemo.FEMALE));
	}
	
	@Test
	public void testSimpleRadioNoneChecked() {
		PageRadioButtonDemo radioButtonPage = navegaParaPage();
		Assert.assertTrue(radioButtonPage.isNotSelectedGender());
	}
	
	
	@Test
	public void testIsGroupMale1To5Selected() {
		PageRadioButtonDemo radioButtonPage = navegaParaPage();
		radioButtonPage.getMaleGruopRadioElement().click();
		radioButtonPage.getAgeGroup0To5RadioElement().click();
		Assert.assertTrue(radioButtonPage.isGroupSelected(PageRadioButtonDemo.MALE, PageRadioButtonDemo.ZERO_TO_FIVE));
	}
	
	@Test
	public void testIsGroupFemale5To15Selected() {
		PageRadioButtonDemo radioButtonPage = navegaParaPage();
		radioButtonPage.getFemaleGruopRadioElement().click();
		radioButtonPage.getAgeGroup5To15RadioElement().click();
		Assert.assertTrue(radioButtonPage.isGroupSelected(PageRadioButtonDemo.FEMALE, PageRadioButtonDemo.FIVE_TO_FIFTEEN));
	}
	
	@Test
	public void testIsGroup15To50Selected() {
		PageRadioButtonDemo radioButtonPage = navegaParaPage();
		radioButtonPage.getAgeGroup15To50RadioElement().click();
		Assert.assertTrue(radioButtonPage.isGroupSelected("", PageRadioButtonDemo.FIFTEEN_TO_FIFTY));
	}
	
}
