package tests;

import org.testng.annotations.Test;
import pages.RegistroPage;
// Paquete donde viven los tests

// Importamos la página LoginPage
public class InscribirmeTest extends BaseTest {

    @Test
    public void InscripcionExitoso() {
        driver.get("https://automationexercise.com/login");
        RegistroPage InscribirmePage = new RegistroPage(driver, wait);

        InscribirmePage.Inscripcion("Jose Armando", "josearmando@gmail.com");

    }

}
