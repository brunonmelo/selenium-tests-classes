package br.com.aprendaSeleniumComThiago.test.seleniumeasy.inputForms;

import org.junit.Assert;
import org.junit.Test;

import br.com.aprendaSeleniumComThiago.core.CoreBaseTest;
import br.com.aprendaSeleniumComThiago.page.seleniumeasy.inputForms.PageRadioButtonDemo;
import br.com.aprendaSeleniumComThiago.util.Utils;

public class TestRadioButton extends CoreBaseTest {
	
	public PageRadioButtonDemo navegaParaPage() {
		driver.navigate().to("http://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		return new PageRadioButtonDemo(driver);
	}
		
	@Test
	public void testSimpleRadioIsMaleGenderChecked() {
		PageRadioButtonDemo radioButtonPage = navegaParaPage();
		radioButtonPage.getMaleRadioElement().click();
		boolean selectedGender = radioButtonPage.isSelectedGender(PageRadioButtonDemo.MALE);
		Utils.takeScreenshot(driver, "RadioButton", "testSimpleRadioIsMaleGenderChecked");
		Assert.assertTrue(selectedGender);
	}
	
	@Test
	public void testSimpleRadioIsFemaleGenderChecked() {
		PageRadioButtonDemo radioButtonPage = navegaParaPage();
		radioButtonPage.getFemaleRadioElement().click();
		boolean selectedGender = radioButtonPage.isSelectedGender(PageRadioButtonDemo.FEMALE);
		Utils.takeScreenshot(driver, "RadioButton", "testSimpleRadioIsFemaleGenderChecked");
		Assert.assertTrue(selectedGender);
	}
	
	@Test
	public void testSimpleRadioNoneChecked() {
		PageRadioButtonDemo radioButtonPage = navegaParaPage();
		boolean selectedGender = radioButtonPage.isNotSelectedGender();
		Utils.takeScreenshot(driver, "RadioButton", "testSimpleRadioNoneChecked");
		Assert.assertTrue(selectedGender);
	}
	
	
	@Test
	public void testIsGroupMale1To5Selected() {
		PageRadioButtonDemo radioButtonPage = navegaParaPage();
		radioButtonPage.getMaleGruopRadioElement().click();
		radioButtonPage.getAgeGroup0To5RadioElement().click();
		boolean groupSelected = radioButtonPage.isGroupSelected(PageRadioButtonDemo.MALE, PageRadioButtonDemo.ZERO_TO_FIVE);
		Utils.takeScreenshot(driver, "RadioButton", "testIsGroupMale1To5Selected");
		Assert.assertTrue(groupSelected);
	}
	
	@Test
	public void testIsGroupFemale5To15Selected() {
		PageRadioButtonDemo radioButtonPage = navegaParaPage();
		radioButtonPage.getFemaleGruopRadioElement().click();
		radioButtonPage.getAgeGroup5To15RadioElement().click();
		boolean groupSelected = radioButtonPage.isGroupSelected(PageRadioButtonDemo.FEMALE, PageRadioButtonDemo.FIVE_TO_FIFTEEN);
		Utils.takeScreenshot(driver, "RadioButton", "testIsGroupFemale5To15Selected");
		Assert.assertTrue(groupSelected);
	}
	
	@Test
	public void testIsGroup15To50Selected() {
		PageRadioButtonDemo radioButtonPage = navegaParaPage();
		radioButtonPage.getAgeGroup15To50RadioElement().click();
		boolean groupSelected = radioButtonPage.isGroupSelected("", PageRadioButtonDemo.FIFTEEN_TO_FIFTY);
		Utils.takeScreenshot(driver, "RadioButton", "testIsGroup15To50Selected");
		Assert.assertTrue(groupSelected);
	}
	
}
