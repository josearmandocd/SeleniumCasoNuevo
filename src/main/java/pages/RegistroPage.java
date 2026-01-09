package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistroPage {

    WebDriver driver;
    WebDriverWait wait;

    private By namelInput = By.name("name");
    private By emailInput = By.cssSelector("input[data-qa='signup-email']");
    private By loginButtom = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");

    public RegistroPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void escribirNombre(String usuario) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(namelInput)).sendKeys(usuario);
        // Espera hasta que el campo nombre sea visible

    }

    public void escribirEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clicInscribirse() {
        driver.findElement(loginButtom).click();
    }

    public void Inscripcion(String user, String email) {
        escribirNombre(user);
        escribirEmail(email);
        clicInscribirse();
    }
}

