package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactFormTest extends BaseTest {

    @Test
    public void enviarFormularioContacto() {

        // Crea objeto de la página Home
        HomePage homePage = new HomePage(driver, wait);
        // Crea objeto de la página Contact Us
        ContactUsPage contactPage = new ContactUsPage(driver, wait);

        contactPage.clickHogar();
        // Valida que la página principal sea visible
        Assert.assertTrue(
                homePage.paginaHomeVisible(),
                "La página de inicio NO se mostró correctamente"
        );

        // Hace clic en Contact Us
        homePage.irAContactUs();


        // Valida que el texto GET IN TOUCH sea visible
        Assert.assertTrue(
                contactPage.getInTouchVisible(),
                "El texto GET IN TOUCH no es visible"
        );

        // Llena el formulario
        contactPage.llenarFormulario(
                "Jose QA",
                "jose@test.com",
                "Prueba automatizada",
                "Este es un mensaje de prueba con Selenium"
        );

        // Sube un archivo
        contactPage.subirArchivo();

        // Envía el formulario
        contactPage.enviarFormulario();

        // Valida que el mensaje de éxito se muestre
        Assert.assertTrue(
                contactPage.mensajeExitoVisible(),
                "El mensaje de éxito NO se mostró"
        );
    }
}
