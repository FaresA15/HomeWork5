package Selleniun_start_projects.Selleniun_start_projects;

import static org.junit.Assert.assertEquals;  
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTestingValidation {
    
    static WebDriver browser;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("https://testpages.eviltester.com/styled/apps/7charval/simple7charvalidation.html");
    }

    @Test
    public void testShortInputValidation() {
        WebElement textBox = browser.findElement(By.name("characters"));
        WebElement submitButton = browser.findElement(By.name("validate"));
        WebElement validationMessage = browser.findElement(By.name("validation_message"));

        // Case 1: Input less than 7 characters
        textBox.clear();
        textBox.sendKeys("short");
        submitButton.click();
        assertEquals("Invalid Value", validationMessage.getAttribute("value"));
    }

    @Test
    public void testMoreThan7CharInput() {
        WebElement textBox = browser.findElement(By.name("characters"));
        WebElement submitButton = browser.findElement(By.name("validate"));
        WebElement validationMessage = browser.findElement(By.name("validation_message"));

        // Case 3: Input more than 7 characters
        textBox.clear();
        textBox.sendKeys("morethan7chars");
        submitButton.click();
        assertEquals("Invalid Value", validationMessage.getAttribute("value"));
    }

    @Test
    public void testEmptyInput() {
        WebElement textBox = browser.findElement(By.name("characters"));
        WebElement submitButton = browser.findElement(By.name("validate"));
        WebElement validationMessage = browser.findElement(By.name("validation_message"));

        // Case 4: Empty input
        textBox.clear();
        submitButton.click();
        assertEquals("Invalid Value", validationMessage.getAttribute("value"));
    }

    
    @Test
    public void testSpecialCharacterInput() {
        WebElement textBox = browser.findElement(By.name("characters"));
        WebElement submitButton = browser.findElement(By.name("validate"));
        WebElement validationMessage = browser.findElement(By.name("validation_message"));

        // Case: Input with special characters like '%'
        textBox.clear();
        textBox.sendKeys("valid%");
        submitButton.click();
        assertEquals("Invalid Value", validationMessage.getAttribute("value"));
    }
    
    @Test
    public void testMixedCaseAndNumbersInput() {
        WebElement textBox = browser.findElement(By.name("characters"));
        WebElement submitButton = browser.findElement(By.name("validate"));
        WebElement validationMessage = browser.findElement(By.name("validation_message"));

        // Case: Input with mixed uppercase, lowercase, and numbers
        textBox.clear();
        textBox.sendKeys("Val1dUs");
        submitButton.click();
        assertEquals("Valid Value", validationMessage.getAttribute("value"));
    }
    
    @Test
    public void testNumbersOnlyInput() {
        WebElement textBox = browser.findElement(By.name("characters"));
        WebElement submitButton = browser.findElement(By.name("validate"));
        WebElement validationMessage = browser.findElement(By.name("validation_message"));

        // Case: Input with numbers only
        textBox.clear();
        textBox.sendKeys("1234567");
        submitButton.click();
        assertEquals("Valid Value", validationMessage.getAttribute("value"));
    }

    
}

