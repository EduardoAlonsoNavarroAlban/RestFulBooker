package com.continousTesting.base.tasks.restulBooker.actions;

import com.continousTesting.base.Utils.RestAssuredRequestFilter2;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostCreateBooking implements Task {


    private final String bodyCreateBookingApi;


    public PostCreateBooking(String bodyCreateBookingApi) {

        this.bodyCreateBookingApi = bodyCreateBookingApi;



    }

    public static Performable fromAPI(String bodyCreateBookingApi) {
        return instrumented(PostCreateBooking.class,bodyCreateBookingApi);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Post.to("/booking").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON).
                body(bodyCreateBookingApi)
                .filter(new RestAssuredRequestFilter2())
                ));

                RestAssuredRequestFilter2.example();


    }



}
