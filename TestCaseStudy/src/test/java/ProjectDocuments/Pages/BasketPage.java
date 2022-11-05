package ProjectDocuments.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage {

	public BasketPage(WebDriver driver) {
		super(driver);
	}

	public void compareSize() {
		WebElement element = driver.findElements(By.cssSelector("span[class='cartItem__attrValue']")).get(0);
		String basketSize = element.getText();
		Assert.assertEquals(basketSize, ProductPage.productSize);
	}

	public void comparePrice() {
		WebElement element=driver.findElement(By.cssSelector("span[class='cartItem__price -sale']"));
		String basketPrice = element.getText();
		Assert.assertEquals(basketPrice, ProductPage.productPrice);

	}

	public void clickContinue() {
		clickElement(By.cssSelector("button[class='continueButton n-button large block text-center -primary']"));
	}

}
