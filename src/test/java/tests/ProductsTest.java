package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    @Test
    public void verificarProductosYDetalle() {

        HomePage home = new HomePage(driver, wait);
        ProductsPage products = new ProductsPage(driver, wait);
        ProductDetailPage detail = new ProductDetailPage(driver, wait);
        ContactUsPage contactPage = new ContactUsPage(driver, wait);
        contactPage.clickHogar();
        // Paso 3
        Assert.assertTrue(home.paginaHomeVisible(), "Home no visible");

        // Paso 4
        home.clickProducts();

        // Paso 5
        Assert.assertTrue(products.isAllProductsPageVisible(), "No es página All Products");

        // Paso 6
        Assert.assertTrue(products.isProductListVisible(), "Lista de productos no visible");

        // Paso 7
        products.clickFirstViewProduct();

        // Paso 8 y 9
        Assert.assertTrue(detail.areProductDetailsVisible(), "Detalles del producto no visibles");
    }
}


