package ProjectDocuments.Pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	protected WebDriver driver;
	JavascriptExecutor jsDriver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		jsDriver = (JavascriptExecutor) driver;
	}

	public WebElement findElement(By by) {
		return driver.findElement(by);
	}

	public List<WebElement> findAll(By locator) {
		return driver.findElements(locator);
	}

	public void clickElement(By locator) {
		findElement(locator).submit();
	}

	public void getText(By by,String text) {
		 findElement(by).sendKeys(text);
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public void scrollPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 15000; i += 81) {
			js.executeScript("window.scrollTo(0, " + i + ")");
		}
		clickElement(By.xpath("//button[@class='button -secondary -sm relative']"));
	}

	public boolean isDisplayed(By by) {
		return findElement(by).isDisplayed();
	}
}
