package Selleniun_start_projects.Selleniun_start_projects;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TriangleClassificationTest {

	static WebDriver browser;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		browser = new FirefoxDriver();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		browser.get("https://testpages.eviltester.com/styled/apps/triangle/triangle001.html");
	}

	@AfterClass
	public static void teardown() {
		if (browser != null) {
			browser.quit();
		}
	}
	
	@Test
	public void invalid() {
		browser.findElement(By.id("side1")).clear();
		browser.findElement(By.id("side2")).clear();
		browser.findElement(By.id("side3")).clear();
		browser.findElement(By.id("side1")).sendKeys("2");
		browser.findElement(By.id("side2")).sendKeys("4");
		browser.findElement(By.id("side3")).sendKeys("2");

		browser.findElement(By.id("identify-triangle-action")).click();

		WebElement result = browser.findElement(By.id("triangle-type"));
		String resultText = result.getText();
		assertEquals("Error: Not a Triangle", resultText);
	}

	@Test
	public void testEquilateralTriangle() {
		browser.findElement(By.id("side1")).clear();
		browser.findElement(By.id("side2")).clear();
		browser.findElement(By.id("side3")).clear();
		browser.findElement(By.id("side1")).sendKeys("5");
		browser.findElement(By.id("side2")).sendKeys("5");
		browser.findElement(By.id("side3")).sendKeys("5");

		browser.findElement(By.id("identify-triangle-action")).click();

		WebElement result = browser.findElement(By.id("triangle-type"));
		assertEquals("Equilateral", result.getText());
	}

	@Test
	public void testIsoscelesTriangle() {
		browser.findElement(By.id("side1")).clear();
		browser.findElement(By.id("side2")).clear();
		browser.findElement(By.id("side3")).clear();
		browser.findElement(By.id("side1")).sendKeys("7");
		browser.findElement(By.id("side2")).sendKeys("7");
		browser.findElement(By.id("side3")).sendKeys("3");

		browser.findElement(By.id("identify-triangle-action")).click();

		WebElement result = browser.findElement(By.id("triangle-type"));
		String resultText = result.getText();
		assertEquals("Isosceles", resultText);
	}

	@Test
	public void testScaleneTriangle() {
		browser.findElement(By.id("side1")).clear();
		browser.findElement(By.id("side2")).clear();
		browser.findElement(By.id("side3")).clear();
		browser.findElement(By.id("side1")).sendKeys("8");
		browser.findElement(By.id("side2")).sendKeys("5");
		browser.findElement(By.id("side3")).sendKeys("4");

		browser.findElement(By.id("identify-triangle-action")).click();

		WebElement result = browser.findElement(By.id("triangle-type"));
		String resultText = result.getText();
		assertEquals("Scalene", resultText);
	}

	
	
}

	