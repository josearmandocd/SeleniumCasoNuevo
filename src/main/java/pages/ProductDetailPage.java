package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage {

    WebDriver driver;
    WebDriverWait wait;

    By productName = By.xpath("//div[@class='product-information']/h2");
    By category = By.xpath("//p[contains(text(),'Category')]");
    By price = By.xpath("//span/span");
    By availability = By.xpath("//b[text()='Availability:']");
    By condition = By.xpath("//b[text()='Condition:']");
    By brand = By.xpath("//b[text()='Brand:']");

    public ProductDetailPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Paso 9
    public boolean areProductDetailsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).isDisplayed()
                && driver.findElement(category).isDisplayed()
                && driver.findElement(price).isDisplayed()
                && driver.findElement(availability).isDisplayed()
                && driver.findElement(condition).isDisplayed()
                && driver.findElement(brand).isDisplayed();
    }
}
