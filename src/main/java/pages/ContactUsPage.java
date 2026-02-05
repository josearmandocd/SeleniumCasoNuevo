package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class ContactUsPage {

    // Driver del navegador
    WebDriver driver;

    // Esperas explícitas
    WebDriverWait wait;

    // Texto "GET IN TOUCH"
    By getInTouchText = By.xpath("//h2[text()='Get In Touch']");

    // Campos del formulario
    By nameInput = By.name("name");
    By emailInput = By.name("email");
    By subjectInput = By.name("subject");
    By messageInput = By.id("message");

    // Campo para subir archivo
    By uploadFile = By.name("upload_file");

    // Botón enviar
    By submitButton = By.name("submit");

    // Mensaje de éxito
    By successMessage = By.xpath("//div[contains(text(),'Success')]");

    By btnContact = By.xpath("//a[text()=' Home']");

    // Constructor
    public ContactUsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Verifica que el texto GET IN TOUCH sea visible
    public boolean getInTouchVisible() {

        // Espera hasta que el texto sea visible y devuelve true si se muestra
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getInTouchText))
                .isDisplayed();
    }

    // Llena todos los campos del formulario
    public void llenarFormulario(String nombre, String email, String asunto, String mensaje) {

        // Escribe el nombre
        driver.findElement(nameInput).sendKeys(nombre);

        // Escribe el email
        driver.findElement(emailInput).sendKeys(email);

        // Escribe el asunto
        driver.findElement(subjectInput).sendKeys(asunto);

        // Escribe el mensaje
        driver.findElement(messageInput).sendKeys(mensaje);
    }

    // Sube un archivo desde la computadora
    public void subirArchivo() {

        File archivo = new File(
                getClass()
                        .getClassLoader()
                        .getResource("PruebaAuto.txt")
                        .getFile()
        );

        driver.findElement(uploadFile)
                .sendKeys(archivo.getAbsolutePath());
    }

    // Envía el formulario
    public void enviarFormulario() {

        // Hace clic en el botón Submit
        driver.findElement(submitButton).click();

        // Acepta la alerta que aparece después de enviar
        driver.switchTo().alert().accept();
    }

    // Valida que el mensaje de éxito se muestre
    public boolean mensajeExitoVisible() {

        // Espera el mensaje de éxito y valida que esté visible
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage))
                .isDisplayed();
    }

    public void clickHogar() {
        driver.findElement(btnContact).click();
    }
}

