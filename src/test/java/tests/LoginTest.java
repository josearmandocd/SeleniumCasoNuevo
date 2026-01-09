package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void LoginExit() {

        LoginPage loginPage = new LoginPage(driver, wait);


        loginPage.Login("josearmandocd@gmail.com", "123456");

        loginPage.Acceso();

    }

}
