package com.continousTesting.base.tasks.restulBooker.actions;

import com.continousTesting.base.Utils.RestAssuredRequestFilter2;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Patch;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PatchUpdateBooking implements Task {

    private final String bodyUpdateParcialBookingApi;
    private final String token;

    public PatchUpdateBooking(String bodyUpdateParcialBookingApi, String token) {

        this.bodyUpdateParcialBookingApi = bodyUpdateParcialBookingApi;
        this.token = token;

    }

    public static Performable fromAPI(String bodyUpdateParcialBookingApi,String token) {
        return instrumented(PatchUpdateBooking.class,bodyUpdateParcialBookingApi, token);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                 Patch.to("/booking/"+"1")
                 .with(request -> request
                        .header("Content-Type", "application/json")
                         .cookie("token",token)
                        .body(bodyUpdateParcialBookingApi)
                        .filter(new RestAssuredRequestFilter2())
                 ));

                RestAssuredRequestFilter2.example();

    }



}
