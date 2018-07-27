package br.com.aprendaSeleniumComThiago.test.seleniumeasy.inputForms;

import org.junit.Assert;
import org.junit.Test;

import br.com.aprendaSeleniumComThiago.core.CoreBaseTest;
import br.com.aprendaSeleniumComThiago.page.seleniumeasy.inputForms.PageSimpleForm;
import br.com.aprendaSeleniumComThiago.util.Utils;

public class TestSimpleForm extends CoreBaseTest {
	
	public PageSimpleForm navegaParaPage() {
		driver.navigate().to("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
		return new PageSimpleForm(driver);
	}
		
	@Test
	public void testaSimpleInputValue() {
		PageSimpleForm pageSimpleForm = navegaParaPage();
		String msgTeste = "Mensagem teste?";
		Utils.takeScreenshot(driver, "SimpleForm", "testaSimpleInputValue");
		Assert.assertEquals(msgTeste, pageSimpleForm.getInputMessager(msgTeste));;
	}
	
	@Test
	public void testaSomaInput() {
		PageSimpleForm pageSimpleForm = navegaParaPage();
		int sum1 = 3;
		int sum2 = 2;
		int result = sum1 + sum2;
		Utils.takeScreenshot(driver, "SimpleForm", "testaSomaInput");
		Assert.assertEquals(String.valueOf(result), 
				pageSimpleForm.getSumMessager(String.valueOf(sum1), String.valueOf(sum2)));;
	}
	
	@Test
	public void testaNaNComString() {
		PageSimpleForm pageSimpleForm = navegaParaPage();
		int sum1 = 3;
		String sum2 = "Banana";
		String result = "NaN";
		Utils.takeScreenshot(driver, "SimpleForm", "testaNaNComString");
		Assert.assertEquals(result, pageSimpleForm.getSumMessager(String.valueOf(sum1), sum2));;
	}
	
	@Test
	public void testaNaNComCamposVazios() {
		PageSimpleForm pageSimpleForm = navegaParaPage();
		int sum1 = 3;
		String result = "NaN";
		Utils.takeScreenshot(driver, "SimpleForm", "testaNaNComCamposVazios");
		Assert.assertEquals(result, pageSimpleForm.getSumMessager(String.valueOf(sum1), ""));;
	}

}
