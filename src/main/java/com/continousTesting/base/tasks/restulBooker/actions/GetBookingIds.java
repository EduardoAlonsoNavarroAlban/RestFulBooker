package com.continousTesting.base.tasks.restulBooker.actions;

import com.continousTesting.base.Utils.RestAssuredRequestFilter2;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetBookingIds implements Task {




    public static Performable fromAPI() {
        return instrumented(GetBookingIds.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Get.resource("/booking").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                        .filter(new RestAssuredRequestFilter2())
                )
        );
        RestAssuredRequestFilter2.example();


    }


}
