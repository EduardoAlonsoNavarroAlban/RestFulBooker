package com.continousTesting.base.stepDefinitions;


import com.continousTesting.base.questions.ResponseCode;
import com.continousTesting.base.questions.ResponseNameBooking;
import com.continousTesting.base.tasks.restulBooker.actions.*;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;


public class RestfulBookerSD {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("Que {actor} verifica que el servicio Apis RestFulBooker este habilitado")
    public void queAlonsoVerificaQueElServicioApisRestFulBookerEsteHabilitado(Actor actor) {
        actor.whoCan(CallAnApi.at("https://restful-booker.herokuapp.com"));
    }

    @When("crea un token usando")
    public void creaUnTokenUsando(String bodyTokenApi) {
        theActorInTheSpotlight().attemptsTo(
                PostToken.fromAPI(bodyTokenApi)
        );

    }

    @When("lista todos los Ids")
    public void listaTodosLosIds() {
        theActorInTheSpotlight().attemptsTo(
                GetBookingIds.fromAPI()
        );
    }


    @When("lista booking por: {string}")
    public void listaBookingPor(String id) {
        theActorInTheSpotlight().attemptsTo(
                GetBookingById.fromAPI(id)
        );

    }

    //public static String token;
    @When("genero token")
    public void generoToken() {
        theActorInTheSpotlight().attemptsTo(
                PostGetToken.fromAPI()
        );

    }

    @When("creo un booking usando")
    public void creoUnBookingUsando(String bodyCreateBookingApi) {

        theActorInTheSpotlight().attemptsTo(
                PostCreateBooking.fromAPI(bodyCreateBookingApi)
        );
    }


    @And("actualizo el booking aqui usando")
    public void actualizoUnBookingUsando(String bodyUpdateBookingApi) {

        String token = SerenityRest.lastResponse()
                .jsonPath()
                .get("token");

        theActorInTheSpotlight().attemptsTo(
                PutUpdateBooking.fromAPI(bodyUpdateBookingApi,token)

        );

    }

    @And("actualizo el booking parcialmente aqui usando")
    public void actualizoElBookingParcialmenteAquiUsando(String bodyUpdateParcialBookingApi) {

        String token = SerenityRest.lastResponse()
                .jsonPath()
                .get("token");

        theActorInTheSpotlight().attemptsTo(
                PatchUpdateBooking.fromAPI(bodyUpdateParcialBookingApi,token)

        );

    }

    @And("delete item booking: {string}")
    public void deleteItemBooking(String id) {

        String token = SerenityRest.lastResponse()
                .jsonPath()
                .get("token");


        theActorInTheSpotlight().attemptsTo(
                DeleteBookById.fromAPI(id,token)

        );
    }

    @When("valida ping Health Check")
    public void validaPingHealthCheck() {

        theActorInTheSpotlight().attemptsTo(
                GetPing.fromAPI()

        );
    }

    @Then("Verifica que el nombre sea: {string}")
    public void verificaQueElNombreSea(String nombre) {

        theActorInTheSpotlight().should(seeThat("El nombre creado", ResponseNameBooking.getName2(), equalTo(nombre)));

    }

    @Then("Verifica que el apellido creado sea: {string}")
    public void verificaQueElApellidoCreadoSea(String apellido) {
        theActorInTheSpotlight().should(seeThat("El apellido creado", ResponseNameBooking.getLastName2(), equalTo(apellido)));
    }

    @Then("Verifica que la respuesta sea {int}")
    public void verificaQueLaRespuestaSea(int responseCode) {

        theActorInTheSpotlight().should(seeThat("El codigo de respuesta", ResponseCode.getStatus(), equalTo(responseCode)));
    }

    @Then("El esquema sea {string}")
    public void elEsquemaSea(String esquema) {
        theActorInTheSpotlight().attemptsTo(ValidaEsquemaResponse.getSchemaResponse(esquema));


    }

    @Then("Verifica que el nombre x sea: {string}")
    public void verificaQueElNombreXSea(String nombre) {

        theActorInTheSpotlight().should(seeThat("El nombre creado", ResponseNameBooking.getName(), equalTo(nombre)));

    }
}
