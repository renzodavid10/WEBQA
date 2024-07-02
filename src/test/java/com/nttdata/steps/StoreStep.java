package com.nttdata.steps;

import com.nttdata.page.StorePage;
import org.openqa.selenium.WebDriver;

public class StoreStep {
    WebDriver driver;
    StorePage pageStore;

    public StoreStep(WebDriver driver) {
        this.driver = driver;
        pageStore = new StorePage(driver);
    }

    public void navegarA(String url) {
        driver.get(url);
    }

    public void iniciarSesion(String user, String pass) {
        pageStore.clickIniciarSesion();
        pageStore.IngresarDatosUsuario(user, pass);
        pageStore.clickLogearSesion();
    }

    public void validoInicioSesion() {
        // pageStore.verificarSesionIniciada();
        System.out.println(pageStore.verificarSesionIniciada());
    }

    public void navegarClotherMen() {
        pageStore.navegoaClothes();
        pageStore.navegoaClothesMen();
    }

    public void agregarCarrito(int cantidad) {
        pageStore.clickPrimerProducto();
        pageStore.agregarCantidad(cantidad);
        pageStore.añadirCarrito();
    }

    public void verificarPopu() {
        System.out.println(pageStore.verificarPopuConfimarcionProducto());

    }
    public void validarMontos(){
        System.out.println(pageStore.validarMonto());
        System.out.println(pageStore.montoTotal());
    }

    public void finalizarCompra() {
        pageStore.finalizarCompra();
    }
    public void validarTituloCarrito(){
        System.out.println( pageStore.validarTituloCarrito());
    }
    public void validarTotalCarrito(){
        System.out.println( pageStore.validarPrecioUnitarioCarrito());
        System.out.println( pageStore.validarCantidadCarrito());
        System.out.println( pageStore.validarTotalCarrito());
    }
}
