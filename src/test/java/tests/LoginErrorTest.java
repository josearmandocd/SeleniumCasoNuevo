package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginErrorTest extends BaseTest {

    @Test(enabled = false)
    public void loginCredencialesErroneas() {

        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.Login("joseacd@gmail.com", "123452");
        loginPage.Acceso();

        Assert.assertTrue(
                loginPage.mensajeErrorVisible(),
                "El mensaje de error NO se mostró"
        );
    }
}



