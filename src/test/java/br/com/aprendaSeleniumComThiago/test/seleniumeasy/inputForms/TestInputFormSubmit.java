package br.com.aprendaSeleniumComThiago.test.seleniumeasy.inputForms;

import org.junit.Assert;
import org.junit.Test;

import br.com.aprendaSeleniumComThiago.core.CoreBaseTest;
import br.com.aprendaSeleniumComThiago.page.seleniumeasy.inputForms.PageInputFormSubmit;

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
		
		pageInputForm.preencheCampo(pageInputForm.getFirstNameInput(), "a");
		pageInputForm.submit();
		boolean isInvalid2 = pageInputForm.isFistNameInvalid();
		
		Assert.assertTrue(isInvalid1 || isInvalid2);
	}
	
	@Test
	public void testaLastNameInvalid() {
		PageInputFormSubmit pageInputForm = navegaParaPage();
		pageInputForm.preencheCampo(pageInputForm.getLastNameInput(), "");
		pageInputForm.submit();
		boolean isInvalid1 = pageInputForm.isLastNameInvalid();
		
		pageInputForm.preencheCampo(pageInputForm.getLastNameInput(), "a");
		pageInputForm.submit();
		boolean isInvalid2 = pageInputForm.isLastNameInvalid();
		
		Assert.assertTrue(isInvalid1 || isInvalid2);
	}
	
	@Test
	public void testaEmailInvalid() {
		PageInputFormSubmit pageInputForm = navegaParaPage();
		pageInputForm.preencheCampo(pageInputForm.getEmailInput(), "");
		pageInputForm.submit();
		boolean isInvalid1 = pageInputForm.isEmailInvalid();
		
		pageInputForm.preencheCampo(pageInputForm.getEmailInput(), "a");
		pageInputForm.submit();
		boolean isInvalid2 = pageInputForm.isEmailInvalid();
		
		Assert.assertTrue(isInvalid1 || isInvalid2);
	}
	
	@Test
	public void testaPhoneInvalid() {
		PageInputFormSubmit pageInputForm = navegaParaPage();
		pageInputForm.preencheCampo(pageInputForm.getPhoneInput(), "");
		pageInputForm.submit();
		boolean isInvalid1 = pageInputForm.isEmailInvalid();
		
		pageInputForm.preencheCampo(pageInputForm.getPhoneInput(), "a");
		pageInputForm.submit();
		boolean isInvalid2 = pageInputForm.isPhoneInvalid();
		
		Assert.assertTrue(isInvalid1 || isInvalid2);
	}
	
	@Test
	public void testaAddressInvalid() {
		PageInputFormSubmit pageInputForm = navegaParaPage();
		pageInputForm.preencheCampo(pageInputForm.getAddressInput(), "");
		pageInputForm.submit();
		boolean isInvalid1 = pageInputForm.isAddressInvalid();
		
		pageInputForm.preencheCampo(pageInputForm.getAddressInput(), "a");
		pageInputForm.submit();
		boolean isInvalid2 = pageInputForm.isAddressInvalid();
		
		Assert.assertTrue(isInvalid1 || isInvalid2);
	}
	
	@Test
	public void testaCityInvalid() {
		PageInputFormSubmit pageInputForm = navegaParaPage();
		pageInputForm.preencheCampo(pageInputForm.getCityInput(), "");
		pageInputForm.submit();
		boolean isInvalid1 = pageInputForm.isCityInvalid();
		
		pageInputForm.preencheCampo(pageInputForm.getCityInput(), "a");
		pageInputForm.submit();
		boolean isInvalid2 = pageInputForm.isCityInvalid();
		
		Assert.assertTrue(isInvalid1 || isInvalid2);
	}
	
	@Test
	public void testaStateInvalid() {
		PageInputFormSubmit pageInputForm = navegaParaPage();
		pageInputForm.selectStateCampo(0);
		pageInputForm.submit();
		boolean isInvalid = pageInputForm.isStateInvalid();
		
		Assert.assertTrue(isInvalid);
	}

	@Test
	public void testaZipInvalid() {
		PageInputFormSubmit pageInputForm = navegaParaPage();
		pageInputForm.preencheCampo(pageInputForm.getZipInput(), "");
		pageInputForm.submit();
		boolean isInvalid1 = pageInputForm.isZipInvalid();
		
		pageInputForm.preencheCampo(pageInputForm.getZipInput(), "1");
		pageInputForm.submit();
		boolean isInvalid2 = pageInputForm.isZipInvalid();
		
		Assert.assertTrue(isInvalid1 || isInvalid2);
	}
	
	@Test
	public void testaCommentInvalid() {
		PageInputFormSubmit pageInputForm = navegaParaPage();
		pageInputForm.preencheCampo(pageInputForm.getCommentInput(), "");
		pageInputForm.submit();
		boolean isInvalid1 = pageInputForm.isCommentInvalid();
		
		pageInputForm.preencheCampo(pageInputForm.getCommentInput(), "a");
		pageInputForm.submit();
		boolean isInvalid2 = pageInputForm.isCommentInvalid();
		
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
