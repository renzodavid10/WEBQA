Feature: Store de QA Lab bengs

  @StoreQLab
  Scenario Outline: : Validación del Precio de un Producto

    Given estoy en la página de la tienda
    And me logueo con mi usuario "<user>" y clave "<password>"
    Then valido la autenticación exitosa
    When navego a la categoria "Clothes" y subcategoria "Men"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito
    Examples:
      | user                      | password         |
      | renzo.torres110@gmail.com | renzordtarenzo10 |