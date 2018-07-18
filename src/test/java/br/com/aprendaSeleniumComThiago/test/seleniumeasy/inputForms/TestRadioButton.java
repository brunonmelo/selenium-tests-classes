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
	
//	@Test
//	public void testShowingTextCheckAllOnButton() {
//		PageRadioButtonDemo radioButtonPage = navegaParaPage();
//		Assert.assertTrue(navegaParaPage.isShowingTextCheckAllOnButton());
//	}
//	
//	@Test
//	public void testShowingTextUncheckAllOnButton() {
//		PageRadioButtonDemo radioButtonPage = navegaParaPage();
//		Assert.assertTrue(navegaParaPage.isShowingTextUncheckAllOnButton());
//	}
//	
//	@Test
//	public void testAllCheckboxCheckedOnClickCheckAllButton() {
//		PageRadioButtonDemo radioButtonPage = navegaParaPage();
//		Assert.assertTrue(navegaParaPage.isAllCheckboxCheckedOnClickCheckAllButton());
//	}
	
}
