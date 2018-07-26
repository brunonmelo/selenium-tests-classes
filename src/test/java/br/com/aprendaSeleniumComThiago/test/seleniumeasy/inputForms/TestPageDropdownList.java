package br.com.aprendaSeleniumComThiago.test.seleniumeasy.inputForms;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.com.aprendaSeleniumComThiago.core.CoreBaseTest;
import br.com.aprendaSeleniumComThiago.page.seleniumeasy.inputForms.PageSelectDropdownList;
import br.com.aprendaSeleniumComThiago.page.seleniumeasy.inputForms.PageSelectDropdownList.DropDownList;
import br.com.aprendaSeleniumComThiago.page.seleniumeasy.inputForms.PageSelectDropdownList.MultiSelectDownList;

public class TestPageDropdownList extends CoreBaseTest{
	
	public PageSelectDropdownList navegaParaPage() {
		driver.navigate().to("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		return new PageSelectDropdownList(driver);
	}
		
	@Test
	public void testaIsSelectedElement() {
		PageSelectDropdownList pageSelectDropdownList = navegaParaPage();
		Assert.assertTrue(pageSelectDropdownList.isSelectedElement(DropDownList.Saturday));
	}
	
	@Test
	public void testaIsPrintMultipleSelectionNoneSelectedElement() {
		PageSelectDropdownList pageSelectDropdownList = navegaParaPage();
		Assert.assertTrue(pageSelectDropdownList.isPrintMultipleSelectionNoneSelectedElement());
	}
	
	@Test
	public void testaIsPrintSingleSelectionFirstSelectedElement() {
		PageSelectDropdownList pageSelectDropdownList = navegaParaPage();
		Assert.assertTrue(pageSelectDropdownList
				.isPrintSingleSelectionFirstSelectedElement(MultiSelectDownList.New_York));
	}
	
	@Test @Ignore
	public void testaIsPrintMultipleSelectionFirstSelectedElement() {
		PageSelectDropdownList pageSelectDropdownList = navegaParaPage();
		List<MultiSelectDownList> selectItens = new ArrayList<>();
		selectItens.add(MultiSelectDownList.Pennsylvania);
		selectItens.add(MultiSelectDownList.Washington);
		selectItens.add(MultiSelectDownList.New_Jersey);
		selectItens.add(MultiSelectDownList.Ohio);
		Assert.assertTrue(pageSelectDropdownList
				.isPrintMultipleSelectionFirstSelectedElement(selectItens));
	}
	
	@Test
	public void testaIsPrintMultipleSelectionAllSelectedElement() {
		PageSelectDropdownList pageSelectDropdownList = navegaParaPage();
		List<MultiSelectDownList> selectItens = new ArrayList<>();
		selectItens.add(MultiSelectDownList.Ohio);
		selectItens.add(MultiSelectDownList.New_Jersey);
		selectItens.add(MultiSelectDownList.Pennsylvania);
		selectItens.add(MultiSelectDownList.Washington);
		Assert.assertTrue(pageSelectDropdownList
				.isPrintMultipleSelectionAllSelectedElement(selectItens));
	}

}
