package tests;
// Declara el paquete donde vive esta clase

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
// Anotación que se ejecuta antes de cada test

public class BaseTest {
    // Clase base que usarán todos los tests

    protected WebDriver driver;
    // Variable protegida para que las clases hijas la usen
    protected WebDriverWait wait;
    // Variable protegida para manejar esperas explícitas
    protected static final String BASE_URL = "https://automationexercise.com/signup";

    // ✅ URL centralizada (solo aquí)
    @BeforeMethod
    public void setup() {
        // Este método se ejecuta ANTES de cada test

        WebDriverManager.chromedriver().setup();
        // Descarga y configura el ChromeDriver compatible

        driver = new ChromeDriver();
        // Abre una nueva ventana del navegador Chrome

        driver.manage().window().maximize();
        // Maximiza la ventana del navegador
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        abrirAplicacion();
    }

    protected void abrirAplicacion() {
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        // Este método se ejecuta DESPUÉS de cada test

        if (driver != null) {
            // Validamos que el navegador exista

            driver.quit();
            // Cierra el navegador y libera memoria
        }
    }
}

