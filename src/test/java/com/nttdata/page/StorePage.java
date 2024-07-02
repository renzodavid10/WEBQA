package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StorePage {
    private WebDriver driver;
    private By userInput = By.xpath("//input[@id='field-email']");
    private By passInput = By.xpath("//input[@id='field-password']");
    private By botonIniciarSesion = By.xpath("//div[@id='_desktop_user_info']//span[contains(text(), 'Iniciar sesión')]\n");
    private By botonLogeo = By.xpath("//button[@id='submit-login']");
    private By nombreLogeo = By.xpath("//a[@class='account']/span[@class='hidden-sm-down']");
    private By botonClothes = By.xpath("//li[@id='category-3']//a[@class='dropdown-item']");
    private By botonClothesMen = By.xpath("//ul[@class='category-sub-menu']/li[1]");
    private By botonPrimerRopa = By.xpath("//article[contains(@class, 'product-miniature js-product-miniature')]");
    private By agregarCantidad = By.xpath("//input[@id='quantity_wanted']");
    private By agregarCarrito = By.xpath("//button[@class='btn btn-primary add-to-cart']");
    private By popuConfimarcion = By.xpath("//h4[@id='myModalLabel']");
    private By popuFinalizarCompra = By.xpath("//div[@id='blockcart-modal']//a[1]\n");
    private By precioUnitario = By.xpath("//p[@class='product-price']");
    private By precioTotalProducto = By.xpath("//span[@class='subtotal value']");
    private By tituloCarrito = By.xpath("//div[@class='card-block']//h1[contains(@class,'h1')]");
    private By precioCarritoUnitario = By.xpath("//div[@class='current-price']/span[@class='price']");

    private By carritoCantidad = By.xpath("//input[@class='js-cart-line-product-quantity form-control' and @name='product-quantity-spin']\n");

    private By carritoTotal = By.xpath("//span[contains(@class,'product-price')]");

    private WebDriverWait wait;

    public StorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickIniciarSesion() {
        wait.until(ExpectedConditions.elementToBeClickable(botonIniciarSesion));
        WebElement botonInicioSesion = driver.findElement(botonIniciarSesion);
        botonInicioSesion.click();
    }

    public void IngresarDatosUsuario(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userInput));
        WebElement inputUser = driver.findElement(userInput);
        WebElement inputPass = driver.findElement(passInput);
        inputUser.sendKeys(user);
        inputPass.sendKeys(pass);

    }

    public void clickLogearSesion() {
        wait.until(ExpectedConditions.elementToBeClickable(botonLogeo));
        WebElement botonLogearse = driver.findElement(botonLogeo);
        botonLogearse.click();
    }

    public String verificarSesionIniciada() {
        WebElement logeoNombre;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(nombreLogeo));
            logeoNombre = driver.findElement(nombreLogeo);
            return "Bienvenido Usuario del Store : " + logeoNombre.getText();
        } catch (Exception e) {
            return "No se pudo iniciar sesion";
        }

    }

    public void navegoaClothes() {
        wait.until(ExpectedConditions.elementToBeClickable(botonClothes));
        WebElement clothesBoton = driver.findElement(botonClothes);
        clothesBoton.click();
    }

    public void navegoaClothesMen() {
        wait.until(ExpectedConditions.elementToBeClickable(botonClothesMen));
        WebElement clothesMenBoton = driver.findElement(botonClothesMen);
        clothesMenBoton.click();
    }

    public void clickPrimerProducto() {
        wait.until(ExpectedConditions.elementToBeClickable(botonPrimerRopa));
        WebElement primerRopa = driver.findElement(botonPrimerRopa);
        primerRopa.click();
    }

    public void agregarCantidad(int cantidad) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(agregarCantidad));
        WebElement cantidadAgregar = driver.findElement(agregarCantidad);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", cantidadAgregar);
        cantidadAgregar.sendKeys(Integer.toString(cantidad));

    }

    public void añadirCarrito() {
        wait.until(ExpectedConditions.elementToBeClickable(agregarCarrito));
        WebElement carritoAgregado = driver.findElement(agregarCarrito);
        carritoAgregado.click();
    }

    public String verificarPopuConfimarcionProducto() {
        WebElement popuValidacion;

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(popuConfimarcion));
            popuValidacion = driver.findElement(popuConfimarcion);
            return "Validacion del Producto en el POPUP : " + popuValidacion.getText();
        } catch (Exception e) {
            return "No se pudo confirmar el producto";
        }

    }

    public String validarMonto() {
        WebElement montoInicial;

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(precioUnitario));
            montoInicial = driver.findElement(precioUnitario);
            return "Validacion del Monto Unitario del Producto : " + montoInicial.getText();
        } catch (Exception e) {
            return "No se pudo confirmar el precio unitario del producto ";
        }
    }

    public String montoTotal() {
        WebElement montoTotal;

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(precioTotalProducto));
            montoTotal = driver.findElement(precioTotalProducto);
            return "Validacion del Monto Total del Producto : " + montoTotal.getText();
        } catch (Exception e) {
            return "No se pudo confirmar el precio total del producto ";
        }
    }

    public void finalizarCompra() {
        wait.until(ExpectedConditions.elementToBeClickable(popuFinalizarCompra));
        WebElement finalizarCompra = driver.findElement(popuFinalizarCompra);
        finalizarCompra.click();
    }

    public String validarTituloCarrito() {
        WebElement tituloCar;

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(tituloCarrito));
            tituloCar = driver.findElement(tituloCarrito);
            return "Validacion del Titulo Carrito : " + tituloCar.getText();
        } catch (Exception e) {
            return "No se pudo confirmar el titulo del carrito";
        }
    }
    public String validarPrecioUnitarioCarrito() {
        WebElement precioUnitario;

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(precioCarritoUnitario));
            precioUnitario = driver.findElement(precioCarritoUnitario);
            return "Validacion del Precio Unitario del Producto en el Carrito: " + precioUnitario.getText();
        } catch (Exception e) {
            return "No se pudo confirmar el Precio unitario del producto en el carrito";
        }
    }
    public String validarCantidadCarrito() {
        WebElement cantidad;

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(carritoCantidad));
            cantidad = driver.findElement(carritoCantidad);
            return "Validacion de la cantidad a Comprar : " + cantidad.getAttribute("value");
        } catch (Exception e) {
            return "No se pudo confirmar la cantidad a comprar en el carrito";
        }
    }
    public String validarTotalCarrito() {
        WebElement total;

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(carritoTotal));
            total = driver.findElement(carritoTotal);
            return "Validacion del Total a Pagar del carrito : " + total.getText();
        } catch (Exception e) {
            return "No se pudo confirmar el total a pagar";
        }
    }


}
