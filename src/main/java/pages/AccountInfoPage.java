package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
// Permite esperas explícitas

public class AccountInfoPage {

    WebDriver driver;
    // Variable del navegador

    WebDriverWait wait;
    // Variable para esperas

    public AccountInfoPage(WebDriver driver, WebDriverWait wait) {
        // Constructor que recibe el navegador y la espera

        this.driver = driver;
        // Asigna el driver a esta clase

        this.wait = wait;
        // Asigna la espera a esta clase
    }

    By passwordInput = By.id("password");
    // Campo Password

    By firstNameInput = By.id("first_name");
    // Campo First Name

    By lastNameInput = By.id("last_name");
    // Campo Last Name

    By addressInput = By.id("address1");
    // Campo Address

    By countrySelect = By.id("country");
    // Lista desplegable Country

    By stateInput = By.id("state");
    // Campo State

    By cityInput = By.id("city");
    // Campo City

    By zipcodeInput = By.id("zipcode");
    // Campo Zipcode

    By mobileInput = By.id("mobile_number");
    // Campo Mobile Number

    By createAccountButton = By.cssSelector("button[data-qa='create-account']");
    // Botón Create Account

    By accountCreatedText = By.xpath("//h2[contains(text(),'Account Created!')]");
    // Texto de confirmación
    By titleMrRadio = By.id("id_gender1");

    By daysSelect = By.id("days");
    By monthsSelect = By.id("months");
    By yearsSelect = By.id("years");
    By AccountCreatedContinue = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");

    public void seleccionarTitulo() {
        driver.findElement(titleMrRadio).click();
    }

    public void seleccionarFechaNacimiento(String dia, String mes, String anio) {
        new Select(driver.findElement(daysSelect)).selectByVisibleText(dia);
        new Select(driver.findElement(monthsSelect)).selectByVisibleText(mes);
        new Select(driver.findElement(yearsSelect)).selectByVisibleText(anio);
    }

    public void ingresarPassword(String password) {
        // Método para escribir el password
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput))
                .sendKeys(password);
        // Espera y escribe el password
    }

    public void ingresarNombre(String nombre) {
        driver.findElement(firstNameInput).sendKeys(nombre);
        // Escribe el nombre
    }

    public void ingresarApellido(String apellido) {
        driver.findElement(lastNameInput).sendKeys(apellido);
        // Escribe el apellido
    }

    public void ingresarDireccion(String direccion) {
        driver.findElement(addressInput).sendKeys(direccion);
        // Escribe la dirección
    }

    public void ingresarPais(String pais) {
        WebElement countryElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(countrySelect)
        );
        Select country = new Select(countryElement);
        country.selectByVisibleText(pais);
    }

    public void ingresarEstado(String estado) {
        driver.findElement(stateInput).sendKeys(estado);
        // Escribe el estado
    }

    public void ingresarCiudad(String ciudad) {
        driver.findElement(cityInput).sendKeys(ciudad);
        // Escribe la ciudad
    }

    public void ingresarCodigoPostal(String zip) {
        driver.findElement(zipcodeInput).sendKeys(zip);
        // Escribe el código postal
    }

    public void ingresarTelefono(String telefono) {
        driver.findElement(mobileInput).sendKeys(telefono);
        // Escribe el teléfono
    }

    public void crearCuenta() {
        driver.findElement(createAccountButton).click();
        // Da clic en Create Account

        driver.findElement(AccountCreatedContinue).click();
    }

    public boolean cuentaCreada() {
        // Valida si la cuenta se creó correctamente

        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedText))
                .isDisplayed();
        // Devuelve true si aparece el texto
    }
}
