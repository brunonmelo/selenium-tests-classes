package br.com.aprendaSeleniumComThiago.test.seleniumeasy.inputForms;

import org.junit.Assert;
import org.junit.Test;

import br.com.aprendaSeleniumComThiago.core.CoreBaseTest;
import br.com.aprendaSeleniumComThiago.page.seleniumeasy.inputForms.PageBasicCheckbox;

public class TestBasicCheckbox extends CoreBaseTest {
	
	public PageBasicCheckbox navegaParaPage() {
		driver.navigate().to("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		return new PageBasicCheckbox(driver);
	}
		
	@Test
	public void testSingleCheckBoxTextVisible() {
		PageBasicCheckbox navegaParaPage = navegaParaPage();
		Assert.assertTrue(navegaParaPage.isSingleCheckBoxTextVisible());
	}
	
	@Test
	public void testShowingTextCheckAllOnButton() {
		PageBasicCheckbox navegaParaPage = navegaParaPage();
		Assert.assertTrue(navegaParaPage.isShowingTextCheckAllOnButton());
	}
	
	@Test
	public void testShowingTextUncheckAllOnButton() {
		PageBasicCheckbox navegaParaPage = navegaParaPage();
		Assert.assertTrue(navegaParaPage.isShowingTextUncheckAllOnButton());
	}
	
	@Test
	public void testAllCheckboxCheckedOnClickCheckAllButton() {
		PageBasicCheckbox navegaParaPage = navegaParaPage();
		Assert.assertTrue(navegaParaPage.isAllCheckboxCheckedOnClickCheckAllButton());
	}
	
}
