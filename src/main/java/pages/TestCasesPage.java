package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCasesPage {

    WebDriver driver;
    WebDriverWait wait;

    // Título de la página Test Cases
    By testCasesTitle = By.cssSelector("a[href='/test_cases']");

    // Constructor
    public TestCasesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Verifica que la página Test Cases esté visible
    public boolean paginaTestCasesVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(testCasesTitle)
        ).isDisplayed();
    }
}
