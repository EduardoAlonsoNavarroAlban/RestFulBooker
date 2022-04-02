@ApiRestfulBooker
Feature: Automatizacion de Apis RestFulBooker para el reto YAPE

  @CreateToken
  Scenario: Auth - CreateToken

    Given Que Alonso verifica que el servicio Apis RestFulBooker este habilitado
    When crea un token usando
        """
        {
        "username" : "admin",
        "password" : "password123"
        }
        """
    Then Verifica que la respuesta sea 200
    Then El esquema sea "schemaTokenRestfulBooker.json"

  @GetBookingIds
  Scenario: Booking - GetBookingIds
    Given Que Alonso verifica que el servicio Apis RestFulBooker este habilitado
    When lista todos los Ids
    Then Verifica que la respuesta sea 200


  @GetBooking
  Scenario Outline: Booking - GetBooking by Id
    Given Que Alonso verifica que el servicio Apis RestFulBooker este habilitado
    When lista booking por: "<ID>"
    Then Verifica que la respuesta sea 200

    Examples:
      | ID |
      | 1  |
      | 2  |


  @CreateBooking
  Scenario Outline: Booking - CreateBooking
    Given Que Alonso verifica que el servicio Apis RestFulBooker este habilitado
    When creo un booking usando
          """
        {
        "firstname" : "<firstname>",
        "lastname" : "<lastname>",
        "totalprice" : <totalprice>,
        "depositpaid" : <depositpaid>,
        "bookingdates" : {
        "checkin" : "<checkin>",
        "checkout" : "<checkout>"
        },
        "additionalneeds" : "<additionalneeds>"
        }
         """
    Then Verifica que la respuesta sea 200
    Then Verifica que el nombre x sea: "<firstname>"
    Then El esquema sea "schemaCreateRestfulBooker.json"

    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Jim       | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
      | Alonso    | Navarro  | 222        | true        | 2020-01-01 | 2022-01-01 | Dinner          |


  @UpdateBooking
  Scenario Outline: Booking - UpdateBooking
    Given Que Alonso verifica que el servicio Apis RestFulBooker este habilitado
    When genero token
    And actualizo el booking aqui usando
        """
        {
        "firstname" : "<firstname>",
        "lastname" : "<lastname>",
        "totalprice" : <totalprice>,
        "depositpaid" : <depositpaid>,
        "bookingdates" : {
        "checkin" : "<checkin>",
        "checkout" : "<checkout>"
        },
        "additionalneeds" : "<additionalneeds>"
        }
         """
    Then Verifica que la respuesta sea 200
    Then Verifica que el apellido creado sea: "<lastname>"

    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Jim       | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
      | Alonso    | Navarro  | 222        | true        | 2020-01-01 | 2022-01-01 | Dinner          |

  @PartialUpdateBooking
  Scenario: Booking - PartialUpdateBooking
    Given Que Alonso verifica que el servicio Apis RestFulBooker este habilitado
    When genero token
    And actualizo el booking parcialmente aqui usando
        """
        {
          "firstname" : "James",
          "lastname" : "Brown"
        }
         """
    Then Verifica que la respuesta sea 200
    Then Verifica que el nombre sea: "James"

  @DeleteBooking
  Scenario Outline: Booking - DeleteBooking
    Given Que Alonso verifica que el servicio Apis RestFulBooker este habilitado
    When genero token
    And delete item booking: "<ID>"
    Then Verifica que la respuesta sea 201

    Examples:
      | ID |
      | 11 |
      | 12 |


  @HealthCheck
  Scenario: Ping - HealthCheck
    Given Que Alonso verifica que el servicio Apis RestFulBooker este habilitado
    When valida ping Health Check
    Then Verifica que la respuesta sea 201


