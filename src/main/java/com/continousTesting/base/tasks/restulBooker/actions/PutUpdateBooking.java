package com.continousTesting.base.tasks.restulBooker.actions;

import com.continousTesting.base.Utils.RestAssuredRequestFilter2;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutUpdateBooking implements Task {

    private final String bodyUpdateBookingApi;
    private final String token;


    public PutUpdateBooking(String bodyUpdateBookingApi, String token) {

        this.bodyUpdateBookingApi = bodyUpdateBookingApi;
        this.token = token;


    }

    public static Performable fromAPI(String bodyUpdateBookingApi,String token) {
        return instrumented(PutUpdateBooking.class,bodyUpdateBookingApi, token);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(

                 Put.to("/booking/"+"2")
                 .with(request -> request
                        .header("Content-Type", "application/json")
                         .cookie("token",token)
                        .body(bodyUpdateBookingApi)
                        .filter(new RestAssuredRequestFilter2())
                 ));

                RestAssuredRequestFilter2.example();

    }



}
