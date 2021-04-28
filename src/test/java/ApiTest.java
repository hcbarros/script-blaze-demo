

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ApiTest {

	private static final WebDriver chrome = new ChromeDriver();
	private static final WebDriverWait webdriver = new WebDriverWait(chrome, 1000);
		
	@Test
	public void test_blaze_demo() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", 
				"/home/henrique/workspace-spring-tool/test-blaze-demo/chromedriver");
		
		chrome.get("https://blazedemo.com/");
		
		Thread.sleep(500);
		
		for(int i = 0; i < 3; i++ ) {
			
			webdriver.until(ExpectedConditions.visibilityOfElementLocated(
					By.cssSelector("input[type=\"submit\"]"))).click();	
			Thread.sleep(500);
		}	
		
		String msg = webdriver.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector(".hero-unit h1"))).getText();
		
		assertEquals(msg, "Thank you for your purchase today!");
	}
}
