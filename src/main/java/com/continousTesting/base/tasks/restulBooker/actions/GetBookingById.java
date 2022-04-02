package com.continousTesting.base.tasks.restulBooker.actions;

import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetBookingById implements Task {


    private final String id;

    public GetBookingById(String id) {

        this.id = id;

    }

    public static Performable fromAPI(String id) {
        return instrumented(GetBookingById.class,id);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Get.resource("/booking/"+id).with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                        //.filter(new RestAssuredRequestFilter2())
                )
        );
        //RestAssuredRequestFilter2.example();



    }



}
