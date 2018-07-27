package br.com.aprendaSeleniumComThiago.test.seleniumeasy.inputForms;

import org.junit.Assert;
import org.junit.Test;

import br.com.aprendaSeleniumComThiago.core.CoreBaseTest;
import br.com.aprendaSeleniumComThiago.page.seleniumeasy.inputForms.PageInputFormSubmit;
import br.com.aprendaSeleniumComThiago.util.Utils;

public class TestInputFormSubmit extends CoreBaseTest {
	
	public PageInputFormSubmit navegaParaPage() {
		driver.navigate().to("http://www.seleniumeasy.com/test/input-form-demo.html");
		return new PageInputFormSubmit(driver);
	}
		
	@Test
	public void testaFistNameInvalid() {
		PageInputFormSubmit pageInputForm = navegaParaPage();
		pageInputForm.preencheCampo(pageInputForm.getFirstNameInput(), "");
		pageInputForm.submit();
		boolean isInvalid1 = pageInputForm.isFistNameInvalid();
		
		Utils.takeScreenshot(driver, "InputFormSubmit", "testaFistNameInvalid-1");
		pageInputForm.preencheCampo(pageInputForm.getFirstNameInput(), "a");
		pageInputForm.submit();
		boolean isInvalid2 = pageInputForm.isFistNameInvalid();
		Utils.takeScreenshot(driver, "InputFormSubmit", "testaFistNameInvalid-2");
		
		Assert.assertTrue(isInvalid1 || isInvalid2);
	}
	
	@Test
	public void testaLastNameInvalid() {
		PageInputFormSubmit pageInputForm = navegaParaPage();
		pageInputForm.preencheCampo(pageInputForm.getLastNameInput(), "");
		pageInputForm.submit();
		boolean isInvalid1 = pageInputForm.isLastNameInvalid();
		Utils.takeScreenshot(driver, "InputFormSubmit", "testaLastNameInvalid-1");
		
		pageInputForm.preencheCampo(pageInputForm.getLastNameInput(), "a");
		pageInputForm.submit();
		boolean isInvalid2 = pageInputForm.isLastNameInvalid();
		Utils.takeScreenshot(driver, "InputFormSubmit", "testaLastNameInvalid-2");
		
		Assert.assertTrue(isInvalid1 || isInvalid2);
	}
	
	@Test
	public void testaEmailInvalid() {
		PageInputFormSubmit pageInputForm = navegaParaPage();
		pageInputForm.preencheCampo(pageInputForm.getEmailInput(), "");
		pageInputForm.submit();
		boolean isInvalid1 = pageInputForm.isEmailInvalid();
		Utils.takeScreenshot(driver, "InputFormSubmit", "testaEmailInvalid-1");
		
		pageInputForm.preencheCampo(pageInputForm.getEmailInput(), "a");
		pageInputForm.submit();
		boolean isInvalid2 = pageInputForm.isEmailInvalid();
		Utils.takeScreenshot(driver, "InputFormSubmit", "testaEmailInvalid-2");
		
		Assert.assertTrue(isInvalid1 || isInvalid2);
	}
	
	@Test
	public void testaPhoneInvalid() {
		PageInputFormSubmit pageInputForm = navegaParaPage();
		pageInputForm.preencheCampo(pageInputForm.getPhoneInput(), "");
		pageInputForm.submit();
		boolean isInvalid1 = pageInputForm.isEmailInvalid();
		Utils.takeScreenshot(driver, "InputFormSubmit", "testaPhoneInvalid-1");
		
		pageInputForm.preencheCampo(pageInputForm.getPhoneInput(), "a");
		pageInputForm.submit();
		boolean isInvalid2 = pageInputForm.isPhoneInvalid();
		Utils.takeScreenshot(driver, "InputFormSubmit", "testaPhoneInvalid-2");
		
		Assert.assertTrue(isInvalid1 || isInvalid2);
	}
	
	@Test
	public void testaAddressInvalid() {
		PageInputFormSubmit pageInputForm = navegaParaPage();
		pageInputForm.preencheCampo(pageInputForm.getAddressInput(), "");
		pageInputForm.submit();
		boolean isInvalid1 = pageInputForm.isAddressInvalid();
		Utils.takeScreenshot(driver, "InputFormSubmit", "testaAddressInvalid-1");
		
		pageInputForm.preencheCampo(pageInputForm.getAddressInput(), "a");
		pageInputForm.submit();
		boolean isInvalid2 = pageInputForm.isAddressInvalid();
		Utils.takeScreenshot(driver, "InputFormSubmit", "testaAddressInvalid-2");
		
		Assert.assertTrue(isInvalid1 || isInvalid2);
	}
	
	@Test
	public void testaCityInvalid() {
		PageInputFormSubmit pageInputForm = navegaParaPage();
		pageInputForm.preencheCampo(pageInputForm.getCityInput(), "");
		pageInputForm.submit();
		boolean isInvalid1 = pageInputForm.isCityInvalid();
		Utils.takeScreenshot(driver, "InputFormSubmit", "testaCityInvalid-1");
		
		pageInputForm.preencheCampo(pageInputForm.getCityInput(), "a");
		pageInputForm.submit();
		boolean isInvalid2 = pageInputForm.isCityInvalid();
		Utils.takeScreenshot(driver, "InputFormSubmit", "testaCityInvalid-2");
		
		Assert.assertTrue(isInvalid1 || isInvalid2);
	}
	
	@Test
	public void testaStateInvalid() {
		PageInputFormSubmit pageInputForm = navegaParaPage();
		pageInputForm.selectStateCampo(0);
		pageInputForm.submit();
		boolean isInvalid = pageInputForm.isStateInvalid();
		Utils.takeScreenshot(driver, "InputFormSubmit", "testaStateInvalid");
		
		Assert.assertTrue(isInvalid);
	}

	@Test
	public void testaZipInvalid() {
		PageInputFormSubmit pageInputForm = navegaParaPage();
		pageInputForm.preencheCampo(pageInputForm.getZipInput(), "");
		pageInputForm.submit();
		boolean isInvalid1 = pageInputForm.isZipInvalid();
		Utils.takeScreenshot(driver, "InputFormSubmit", "testaZipInvalid-1");
		
		pageInputForm.preencheCampo(pageInputForm.getZipInput(), "1");
		pageInputForm.submit();
		boolean isInvalid2 = pageInputForm.isZipInvalid();
		Utils.takeScreenshot(driver, "InputFormSubmit", "testaZipInvalid-2");
		
		Assert.assertTrue(isInvalid1 || isInvalid2);
	}
	
	@Test
	public void testaCommentInvalid() {
		PageInputFormSubmit pageInputForm = navegaParaPage();
		pageInputForm.preencheCampo(pageInputForm.getCommentInput(), "");
		pageInputForm.submit();
		boolean isInvalid1 = pageInputForm.isCommentInvalid();
		Utils.takeScreenshot(driver, "InputFormSubmit", "testaCommentInvalid-1");
		
		pageInputForm.preencheCampo(pageInputForm.getCommentInput(), "a");
		pageInputForm.submit();
		boolean isInvalid2 = pageInputForm.isCommentInvalid();
		Utils.takeScreenshot(driver, "InputFormSubmit", "testaCommentInvalid-2");
		
		Assert.assertTrue(isInvalid1 || isInvalid2);
	}
	
//	@Test
//	public void testaFormValido() {
//		PageInputFormSubmit pageInputForm = navegaParaPage();
//		pageInputForm.preencheCampo(pageInputForm.getFirstNameInput(), "abcde");
//		pageInputForm.preencheCampo(pageInputForm.getLastNameInput(), "abcde");
//		pageInputForm.preencheCampo(pageInputForm.getEmailInput(), "abc@abc.com");
//		pageInputForm.preencheCampo(pageInputForm.getPhoneInput(), "1111111111");
//		pageInputForm.preencheCampo(pageInputForm.getAddressInput(), "abcdefgh");
//		pageInputForm.preencheCampo(pageInputForm.getCityInput(), "abcd");
//		pageInputForm.selectElementByIndex(element, index);
//		pageInputForm.preencheCampo(pageInputForm.getCityInput(), "abcd");
//		
//		pageInputForm.submit();
//		boolean isInvalid2 = pageInputForm.isCommentInvalid();
//		
//		Assert.assertTrue(isInvalid1 || isInvalid2);
//	}
	
}
