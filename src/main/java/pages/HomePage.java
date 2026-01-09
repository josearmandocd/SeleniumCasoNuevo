package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    // Driver para interactuar con el navegador
    WebDriver driver;

    // Esperas explícitas
    WebDriverWait wait;

    // Localizador del botón "Contact us"
    By contactUsButton = By.xpath("//a[text()=' Contact us']");

    // Localizador del slider de la página principal
    By homeSlider = By.id("slider-carousel");

    // Constructor que recibe driver y wait
    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Verifica que la página Home esté visible
    public boolean paginaHomeVisible() {

        // Espera a que el slider sea visible y valida que se muestre
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homeSlider))
                .isDisplayed();
    }

    // Hace clic en el botón "Contact us"
    public void irAContactUs() {

        // Espera a que el botón sea clickeable y hace clic
        wait.until(ExpectedConditions.elementToBeClickable(contactUsButton))
                .click();
    }
}
