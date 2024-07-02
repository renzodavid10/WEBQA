package com.nttdata.stepsdefinitions;


import com.nttdata.steps.StoreStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StoreStepdefs {
    private StoreStep storeStep;
    private WebDriver driver;
    private Scenario scenario;

    @Before(order = 0)
    public void setUp() {
        //Se ejecutará Automáticamente
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void quitDriver() {
           driver.quit();
    }

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        storeStep = new StoreStep(driver);
        storeStep.navegarA("https://qalab.bensg.com/store/pe/");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String arg0, String arg1) {
        storeStep.iniciarSesion(arg0, arg1);
        screenShot();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String arg0, String arg1) {
        storeStep.navegarClotherMen();
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int arg0) {
        storeStep.agregarCarrito(arg0);
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        storeStep.verificarPopu();
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        storeStep.validarMontos();
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        storeStep.finalizarCompra();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        storeStep.validarTituloCarrito();
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        storeStep.validarTotalCarrito();
        screenShot();
    }

    @Then("valido la autenticación exitosa")
    public void validoLaAutenticaciónExitosa() {
        storeStep.validoInicioSesion();
        screenShot();
    }

    public void screenShot() {
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }


}
