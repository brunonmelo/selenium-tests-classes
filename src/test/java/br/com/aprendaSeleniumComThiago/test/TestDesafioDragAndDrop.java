package br.com.aprendaSeleniumComThiago.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.aprendaSeleniumComThiago.core.CoreBaseTest;
import br.com.aprendaSeleniumComThiago.page.PageCheckout;
import br.com.aprendaSeleniumComThiago.page.PageDesafioDragAndDrop;
import br.com.aprendaSeleniumComThiago.page.PageDesafioDragAndDrop.Itens;

public class TestDesafioDragAndDrop extends CoreBaseTest{
	
	@Test
	@Ignore
	public void testDesafioDragAndDrop(){
		PageDesafioDragAndDrop pageDesafioDragAndDrop = new PageDesafioDragAndDrop(driver);
		PageCheckout pageCheckout = new PageCheckout(driver);
		
		driver.navigate().to("http://eliasnogueira.com/arquivos_blog/selenium/desafio/3desafio/drag_and_drop/demo.php");
		
		List<String> itens = pageDesafioDragAndDrop.moveElementsParaCarrinho();
		assertTrue(pageCheckout.contaisItens(itens));
	}
	
	@Test
	@Ignore
	public void testDesafioDragAndDropUmItem(){
		PageDesafioDragAndDrop pageDesafioDragAndDrop = new PageDesafioDragAndDrop(driver);
		PageCheckout pageCheckout = new PageCheckout(driver);
		
		driver.navigate().to("http://eliasnogueira.com/arquivos_blog/selenium/desafio/3desafio/drag_and_drop/demo.php");
		
		String item = pageDesafioDragAndDrop.moveItemParaCarrinho(Itens.IPHONE, true);
		assertTrue(pageCheckout.contaisItens(item));
	}
	
	@Test
	public void testDesafioDragAndDropVariosItens(){
		PageDesafioDragAndDrop pageDesafioDragAndDrop = new PageDesafioDragAndDrop(driver);
		PageCheckout pageCheckout = new PageCheckout(driver);
		List<String> itens = new ArrayList<String>(); 
		
		driver.navigate().to("http://eliasnogueira.com/arquivos_blog/selenium/desafio/3desafio/drag_and_drop/demo.php");
		
		itens.add(pageDesafioDragAndDrop.moveItemParaCarrinho(Itens.IPHONE, false));
		itens.add(pageDesafioDragAndDrop.moveItemParaCarrinho(Itens.APPLE_TV, false));
		itens.add(pageDesafioDragAndDrop.moveItemParaCarrinho(Itens.IMAC, false));
		itens.add(pageDesafioDragAndDrop.moveItemParaCarrinho(Itens.IPOD, false));
		itens.add(pageDesafioDragAndDrop.moveItemParaCarrinho(Itens.IPOD_NANO, false));
		itens.add(pageDesafioDragAndDrop.moveItemParaCarrinho(Itens.IPOD_SHUFFLE, true));
		
		assertTrue(pageCheckout.contaisItens(itens));
	}
	
	

}
