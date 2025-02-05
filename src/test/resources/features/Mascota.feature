
@ProbarFeatureMascota
  Feature: Mascota

    @CrearyConsultarorden
    Scenario Outline: Crear orden de compra de mascota y consultar orden de mascota

      When Ingreso la orden de mascota con id 4, petId 2, quantity 2, shipDate "2025-02-06T00:01:46.522+0000", status "<status>", complete false
      Then valido el codigo de respuesta 200
      And valido que el body de la respuesta sea  4, petId 2, quantity 2, shipDate "2025-02-06T00:01:46.522+0000", status "<status>", complete false
      
      When Consulto la orden de mascota con orderId 4
      Then valido el codigo de respuesta 200
      And valido que el body de la respuesta sea  4, petId 2, quantity 2, shipDate "2025-02-06T00:01:46.522+0000", status "<status>", complete false


      Examples:
        | status |
        | placed |
        | unplaced |

