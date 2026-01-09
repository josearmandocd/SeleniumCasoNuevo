package tests;
// Define el paquete tests

import org.testng.annotations.Test;
import pages.AccountInfoPage;
import pages.RegistroPage;
// Importa la segunda pantalla

public class FullRegisterTest extends BaseTest {
// Clase de test que hereda de BaseTest

    @Test
    // Indica que es un caso de prueba

    public void registroCompletoExitoso() {
        // Nombre del caso de prueba

        RegistroPage RegistroPage = new RegistroPage(driver, wait);
        // Crea el objeto de la página Signup

        driver.get("https://automationexercise.com/login");
        //signupPage.abrirPagina();
        // Abre la página de registro

        RegistroPage.escribirNombre("Juan Tester");
        // Ingresa el nombre

        RegistroPage.escribirEmail("juan" + System.currentTimeMillis() + "@test.com");
        // Genera un email único

        RegistroPage.clicInscribirse();
        // Da clic en Signup

        AccountInfoPage accountPage = new AccountInfoPage(driver, wait);
        // Crea el objeto de la segunda página

        accountPage.seleccionarTitulo();

        accountPage.ingresarPassword("1234");
        // Ingresa el password
        accountPage.seleccionarFechaNacimiento("10", "May", "1995");

        accountPage.ingresarNombre("Juan");
        // Ingresa el nombre

        accountPage.ingresarApellido("Perez");
        // Ingresa el apellido

        accountPage.ingresarPais("Canada");

        accountPage.ingresarDireccion("Calle QA 123");
        // Ingresa la dirección

        accountPage.ingresarEstado("Puebla");
        // Ingresa el estado

        accountPage.ingresarCiudad("Xicotepec");
        // Ingresa la ciudad

        accountPage.ingresarCodigoPostal("73080");
        // Ingresa el código postal

        accountPage.ingresarTelefono("2221234567");
        // Ingresa el teléfono

        accountPage.crearCuenta();
        // Da clic en Create Account

        //  boolean resultado = accountPage.cuentaCreada();
        // Valida que la cuenta se haya creado

        // assert resultado;
        // Verifica que el registro fue exitoso
    }
}
