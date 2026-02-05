package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import pages.TestCasesPage;

public class TestCasesTest extends BaseTest {

    @Test
    public void verificarPaginaTestCases() {
        ContactUsPage contactPage = new ContactUsPage(driver, wait);

        contactPage.clickHogar();
        // 1️⃣ Home visible
        HomePage homePage = new HomePage(driver, wait);
        Assert.assertTrue(
                homePage.paginaHomeVisible(),
                "La página Home NO está visible"
        );

        // 2️⃣ Ir a Test Cases
        homePage.irATestCases();

        // 3️⃣ Validar Test Cases
        TestCasesPage testCasesPage = new TestCasesPage(driver, wait);
        Assert.assertTrue(
                testCasesPage.paginaTestCasesVisible(),
                "La página Test Cases NO está visible"
        );
    }
}
