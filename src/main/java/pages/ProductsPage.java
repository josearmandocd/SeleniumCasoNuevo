package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    By allProductsTitle = By.xpath("//h2[text()='All Products']");
    By productsList = By.cssSelector(".features_items");
    By firstViewProduct = By.xpath("(//a[text()='View Product'])[1]");

    public ProductsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Paso 5
    public boolean isAllProductsPageVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(allProductsTitle)
        ).isDisplayed();
    }

    // Paso 6
    public boolean isProductListVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productsList)
        ).isDisplayed();
    }

    // Paso 7 (SOLUCIÓN REAL AL PROBLEMA DE IFRAME / ADS)
    public void clickFirstViewProduct() {

        WebElement viewProduct = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstViewProduct)
        );

        // 1️⃣ Hacemos scroll para centrar el elemento
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                viewProduct
        );

        // 2️⃣ Click por JavaScript (evita el iframe de anuncios)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                viewProduct
        );
    }
}
