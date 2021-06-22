package steps;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class SearchNotebookGoogle {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jessi\\Documents\\01 - Quality Engineer\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Dado("que estou na tela de pesquisa do google")
	public void que_estou_na_tela_de_pesquisa_do_google() {
		driver.get("https://www.google.com.br/");
	}
	
	@Quando("pesquiso por {string}")
	public void pesquiso_por(String item) {
		driver.findElement(By.name("q")).sendKeys(item);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Então("o título da página deve conter {string}")
	public void o_título_da_página_deve_conter(String searchResult) {
		assertEquals(searchResult, driver.getTitle());
	}

	@After
	public void exitPage() {
		driver.quit();
	}
}
