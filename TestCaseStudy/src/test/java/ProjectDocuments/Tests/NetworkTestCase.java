package ProjectDocuments.Tests;

import java.io.IOException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.opencsv.exceptions.CsvValidationException;
import ProjectDocuments.Pages.LoginPage;
import ProjectDocuments.Pages.BasketPage;
import ProjectDocuments.Pages.HomePage;
import ProjectDocuments.Pages.ProductPage;

public class NetworkTestCase extends BaseTest {
	
	ProductPage product=new ProductPage(driver);
	LoginPage login= new LoginPage(driver);
	HomePage home=new HomePage(driver);
    BasketPage basketPage = new BasketPage(driver);

	
	@Test
	@Order(1)
	public void search_product() {
		home.checkUrl();
		home.acceptCookie();
		home.searchBox();
	}

	@Test
	@Order(2)
	public void select_product() throws InterruptedException {
		product.scrollPage();
		product.hover();
		product.randomProduct();
		product.getPrice();
		product.getSize();
		product.gotoBasket();
	}

	@Test
	@Order(3)
	public void goToBasket() throws InterruptedException {
		basketPage.comparePrice();
		basketPage.compareSize();
		basketPage.clickContinue();

	}

	@Test
	@Order(4)
	public void login() throws InterruptedException, CsvValidationException, IOException {
		login.mailAndPasswordCsv();
		login.checkLoginButton();
		login.clickLogo();
		

	}

	@Test
	@Order(5)
	public void deleteBasket() throws InterruptedException, CsvValidationException, IOException {
		home.clickBasketLogo();
		home.deleteProduct();
	}

}
