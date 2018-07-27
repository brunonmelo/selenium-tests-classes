package br.com.aprendaSeleniumComThiago.test.seleniumeasy.inputForms;

import org.junit.Assert;
import org.junit.Test;

import br.com.aprendaSeleniumComThiago.core.CoreBaseTest;
import br.com.aprendaSeleniumComThiago.page.seleniumeasy.inputForms.PageBasicCheckbox;
import br.com.aprendaSeleniumComThiago.util.Utils;

public class TestBasicCheckbox extends CoreBaseTest {
	
	public PageBasicCheckbox navegaParaPage() {
		driver.navigate().to("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		return new PageBasicCheckbox(driver);
	}
		
	@Test
	public void testSingleCheckBoxTextVisible() {
		PageBasicCheckbox navegaParaPage = navegaParaPage();
		boolean textVisible = navegaParaPage.isSingleCheckBoxTextVisible();
		Utils.takeScreenshot(driver, "BasicCheckbox", "testSingleCheckBoxTextVisible");
		Assert.assertTrue(textVisible);
	}
	
	@Test
	public void testShowingTextCheckAllOnButton() {
		PageBasicCheckbox navegaParaPage = navegaParaPage();
		boolean checkAllOnButton = navegaParaPage.isShowingTextCheckAllOnButton();
		Utils.takeScreenshot(driver, "BasicCheckbox", "testShowingTextCheckAllOnButton");
		Assert.assertTrue(checkAllOnButton);
	}
	
	@Test
	public void testShowingTextUncheckAllOnButton() {
		PageBasicCheckbox navegaParaPage = navegaParaPage();
		boolean uncheckAllOnButton = navegaParaPage.isShowingTextUncheckAllOnButton();
		Utils.takeScreenshot(driver, "BasicCheckbox", "testShowingTextUncheckAllOnButton");
		Assert.assertTrue(uncheckAllOnButton);
	}
	
	@Test
	public void testAllCheckboxCheckedOnClickCheckAllButton() {
		PageBasicCheckbox navegaParaPage = navegaParaPage();
		boolean clickCheckAllButton = navegaParaPage.isAllCheckboxCheckedOnClickCheckAllButton();
		Utils.takeScreenshot(driver, "BasicCheckbox", "testAllCheckboxCheckedOnClickCheckAllButton");
		Assert.assertTrue(clickCheckAllButton);
	}
	
}
