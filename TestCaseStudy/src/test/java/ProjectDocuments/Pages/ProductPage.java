package ProjectDocuments.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductPage extends BasePage {

	public static String productPrice;
	public static String productSize;

	public ProductPage(WebDriver driver) {
	super(driver);
	}

	public void hover() {
		WebElement ele = driver.findElement(By.xpath("(//span[small='%'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

	}

	public void randomProduct() {
		clickElement(By.xpath("//*[@class='products__item col-6 col-md-4'][1]//*[@class=\"radio-box__label\"]"));
	}

	public void getSize() {
		WebElement element = driver.findElements(By.cssSelector("div[class='header__basketProductVariation--val']"))
				.get(1);
		productSize = element.getText();
	}

	public void getPrice() {
		WebElement element =driver.findElement(By.cssSelector("span[class='a-product__price -salePrice']"));
		productPrice = element.getText();
	}


	public void gotoBasket() {
		clickElement(
				By.cssSelector("a[class='button -primary header__basket--checkout header__basketModal -checkout']"));

	}


}
