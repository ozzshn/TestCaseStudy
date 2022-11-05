package ProjectDocuments.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;

public class LoginPage extends BasePage {
	private CSVReader csvReader;
	String[] cell;
	String CSV_PATH = "csv/login.csv";

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void mailAndPasswordCsv() throws IOException, CsvValidationException {
		csvReader = new CSVReader(new FileReader(CSV_PATH));

		while ((cell = csvReader.readNext()) != null) {
			for (int i = 0; i < 1; i++) {
				String mail = cell[i];
				String password = cell[i + 1];
				findElement(By.xpath("//input[@class='input js-trim']")).sendKeys(mail);
				findElement(By.xpath("//input[@class='input']")).sendKeys(password);
			}
		}
	}

	public void clickLogo() {
		clickElement(By.cssSelector("a[class='headerCheckout__logo']"));
	}

	public void checkLoginButton() {
		isDisplayed(By.cssSelector("button[class='n-button large block text-center -primary']"));
	}
}
