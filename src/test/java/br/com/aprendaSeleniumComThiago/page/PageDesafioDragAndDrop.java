package br.com.aprendaSeleniumComThiago.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.aprendaSeleniumComThiago.core.CoreDriver;

public class PageDesafioDragAndDrop {
	
	public static String ipodId = "1";
	public static final int iMacId = 2;
	public static String iphoneId = "3";
	public static final int ipodShuffleId = 4;
	public static final int ipodNanoId = 5;
	public static final int appleTvId = 6;
	
	private WebDriver driver;

	public PageDesafioDragAndDrop(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[1]/div/div[1]/img")
	static WebElement ipodElement;

	@FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[1]/div/div[2]/img")
	static WebElement iMacElement;
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[1]/div/div[3]/img")
	static WebElement iphoneElement;
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[1]/div/div[4]/img")
	static WebElement ipodShuffleElement;
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[1]/div/div[5]/img")
	static WebElement ipodNanoElement;
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[1]/div/div[6]/img")
	static 	WebElement appleTvElement;
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div[3]/div[1]/div")
	WebElement dropableAreaElement;

	@FindBy(id = "table_1")
	static WebElement ipodTable;

	@FindBy(id = "table_2")
	static WebElement iMacTable;

	@FindBy(id = "table_3")
	static WebElement iphoneTable;

	@FindBy(id = "table_4")
	static WebElement ipodShuffleTable;

	@FindBy(id = "table_5")
	static WebElement ipodNanoTable;

	@FindBy(id = "table_6")
	static WebElement appleTvTable;
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div[3]/div[1]/div/a")
	WebElement checkoutButtonElement;
	
	public List<String> moveElementsParaCarrinho() {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(CoreDriver.getDriver(), 30);
		List<String> listResult = new ArrayList<String>();
		
		moveElement(action, iphoneElement);
		wait.until(ExpectedConditions.visibilityOf(iphoneTable));
		listResult.add("iphone");
		
		moveElement(action, ipodShuffleElement);
		wait.until(ExpectedConditions.visibilityOf(ipodShuffleTable));
		listResult.add("ipod Shuffle");
		
		moveElement(action, appleTvElement);
		wait.until(ExpectedConditions.visibilityOf(appleTvTable));
		listResult.add("apple Tv");
		
		checkoutButtonElement.click();
		return listResult;
	}
	
	public String moveItemParaCarrinho(Itens item, boolean isNavega) {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(CoreDriver.getDriver(), 30);
		
		moveElement(action, item.getEntrada());
		wait.until(ExpectedConditions.visibilityOf(item.getResultTable()));
		
		if(isNavega) checkoutButtonElement.click();
		
		return item.getTexto();
	}
	
	private void moveElement(Actions action, WebElement elemento) {
		Actions moveElement = action.clickAndHold(elemento).moveToElement(dropableAreaElement).release();
		moveElement.build().perform();
	}
	
	public enum Itens {
		IPOD(ipodElement, ipodTable, "iPod"),
		IMAC(iMacElement, iMacTable, "iMac"),
		IPHONE(iphoneElement, iphoneTable, "iPhone"),
		IPOD_SHUFFLE(ipodShuffleElement, ipodShuffleTable, "iPod Shuffle"),
		IPOD_NANO(ipodNanoElement, ipodNanoTable, "iPod Nano"),
		APPLE_TV(appleTvElement, appleTvTable, "Apple TV");
		
		private WebElement entrada;
		private WebElement resultTable;
		private String texto;
		
		Itens(WebElement entrada, WebElement resultTable, String texto) {
			this.entrada = entrada;
			this.resultTable = resultTable;
			this.texto = texto;
		}

		public WebElement getEntrada() {
			return entrada;
		}

		public WebElement getResultTable() {
			return resultTable;
		}

		public String getTexto() {
			return texto;
		}
		
	}
}
