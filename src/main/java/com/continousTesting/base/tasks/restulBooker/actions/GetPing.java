package com.continousTesting.base.tasks.restulBooker.actions;

import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetPing implements Task {



    public GetPing() {

    }

    public static Performable fromAPI() {

        return instrumented(GetPing.class);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Get.resource("/ping").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)

                )
        );




    }



}
