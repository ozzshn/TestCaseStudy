package ProjectDocuments.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	SearchBox searchBox;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void acceptCookie() {
		WebElement acceptCookie = driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler"));
		acceptCookie.click();
	}

	public void checkUrl() {
		String url = "https://www.network.com.tr/";
		Assert.assertEquals(url, getUrl());
	}

	public SearchBox searchBox() {
		return searchBox;
	}

	public void clickBasketLogo() {
		clickElement(By.cssSelector("button[class='header__basketTrigger js-basket-trigger -desktop']"));
	}

	public void deleteProduct() {
		clickElement(By.cssSelector("div[class='header__basketProductBtn header__basketModal -remove']"));
	}

}
