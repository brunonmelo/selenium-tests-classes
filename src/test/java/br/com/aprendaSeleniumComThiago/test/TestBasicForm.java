package br.com.aprendaSeleniumComThiago.test;

import org.junit.Test;

import br.com.aprendaSeleniumComThiago.core.CoreBaseTest;
import br.com.aprendaSeleniumComThiago.page.PageHomeSeleniumEasy;
import br.com.aprendaSeleniumComThiago.util.Property;

public class TestBasicForm extends CoreBaseTest{
	
	
	@Test
	public void realizarPrimeiroTest() {
		PageHomeSeleniumEasy homeSeleniumEasy = new PageHomeSeleniumEasy(driver);
		driver.navigate().to(Property.URL);
		homeSeleniumEasy.acessarTestSelenium("BASIC EXAMPLES TO START WITH SELENIUM");
	}

}
