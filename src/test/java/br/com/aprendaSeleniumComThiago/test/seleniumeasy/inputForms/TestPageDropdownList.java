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
import br.com.aprendaSeleniumComThiago.util.Utils;

public class TestPageDropdownList extends CoreBaseTest{
	
	public PageSelectDropdownList navegaParaPage() {
		driver.navigate().to("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		return new PageSelectDropdownList(driver);
	}
		
	@Test
	public void testaIsSelectedElement() {
		PageSelectDropdownList pageSelectDropdownList = navegaParaPage();
		boolean selectedElement = pageSelectDropdownList.isSelectedElement(DropDownList.Saturday);
		Utils.takeScreenshot(driver, "PageDropdownList", "testaIsSelectedElement");
		Assert.assertTrue(selectedElement);
	}
	
	@Test
	public void testaIsPrintMultipleSelectionNoneSelectedElement() {
		PageSelectDropdownList pageSelectDropdownList = navegaParaPage();
		boolean selectedElement = pageSelectDropdownList.isPrintMultipleSelectionNoneSelectedElement();
		Utils.takeScreenshot(driver, "PageDropdownList", "testaIsPrintMultipleSelectionNoneSelectedElement");
		Assert.assertTrue(selectedElement);
	}
	
	@Test
	public void testaIsPrintSingleSelectionFirstSelectedElement() {
		PageSelectDropdownList pageSelectDropdownList = navegaParaPage();
		boolean selectedElement = pageSelectDropdownList
				.isPrintSingleSelectionFirstSelectedElement(MultiSelectDownList.New_York);
		Utils.takeScreenshot(driver, "PageDropdownList", "testaIsPrintSingleSelectionFirstSelectedElement");
		Assert.assertTrue(selectedElement);
	}
	
	@Test
	@Ignore
	public void testaIsPrintMultipleSelectionFirstSelectedElement() {
		PageSelectDropdownList pageSelectDropdownList = navegaParaPage();
		List<MultiSelectDownList> selectItens = new ArrayList<>();
		selectItens.add(MultiSelectDownList.Pennsylvania);
		selectItens.add(MultiSelectDownList.Washington);
		selectItens.add(MultiSelectDownList.New_Jersey);
		selectItens.add(MultiSelectDownList.Ohio);
		boolean selectedElement = pageSelectDropdownList
				.isPrintMultipleSelectionFirstSelectedElement(selectItens);
		Utils.takeScreenshot(driver, "PageDropdownList", "testaIsPrintMultipleSelectionFirstSelectedElement");
		Assert.assertTrue(selectedElement);
	}
	
	@Test
	@Ignore
	public void testaIsPrintMultipleSelectionAllSelectedElement() {
		PageSelectDropdownList pageSelectDropdownList = navegaParaPage();
		List<MultiSelectDownList> selectItens = new ArrayList<>();
		selectItens.add(MultiSelectDownList.Ohio);
		selectItens.add(MultiSelectDownList.New_Jersey);
		selectItens.add(MultiSelectDownList.Pennsylvania);
		selectItens.add(MultiSelectDownList.Washington);
		boolean selectedElement = pageSelectDropdownList
				.isPrintMultipleSelectionAllSelectedElement(selectItens);
		Utils.takeScreenshot(driver, "PageDropdownList", "testaIsPrintMultipleSelectionAllSelectedElement");
		Assert.assertTrue(selectedElement);
	}

}
