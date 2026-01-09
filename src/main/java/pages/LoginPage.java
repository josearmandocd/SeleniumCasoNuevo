package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By emailInputL = By.cssSelector("input[data-qa='login-email']");
    By contrasenaL = By.cssSelector("input[data-qa='login-password']");
    By buttonContinue = By.cssSelector("button[data-qa='login-button']");
    By errorMessage = By.xpath("//p[text()='Your email or password is incorrect!']");
    // Mensaje de error

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void Login(String email, String contrasena) {
        driver.findElement(emailInputL).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(contrasenaL)).sendKeys(contrasena);
    }

    public void Acceso() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonContinue)).click();
    }

    public boolean mensajeErrorVisible() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage))
                .isDisplayed();
        // Devuelve TRUE si el mensaje de error se muestra
    }


}
