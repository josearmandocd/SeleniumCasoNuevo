package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    // Localizadores
    By contactUsButton = By.xpath("//a[text()=' Contact us']");
    By testCasesButton = By.xpath("//a[text()=' Test Cases']");
    By btnContact = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    By homeSlider = By.id("slider-carousel");

    // Constructor
    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Verificar Home visible
    public boolean paginaHomeVisible() {

        // Espera a que cargue la página completamente
        wait.until(driver ->
                ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );

        // Espera a que el slider exista (no necesariamente visible)
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(homeSlider)
        ).isDisplayed();
    }

    // Ir a Contact Us
    public void irAContactUs() {
        wait.until(
                ExpectedConditions.elementToBeClickable(contactUsButton)
        ).click();
    }

    // Ir a Test Cases
    public void irATestCases() {
        wait.until(
                ExpectedConditions.elementToBeClickable(testCasesButton)
        ).click();
    }
}

