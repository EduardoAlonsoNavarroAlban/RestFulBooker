package com.continousTesting.base.tasks.restulBooker.actions;

import com.continousTesting.base.Utils.RestAssuredRequestFilter2;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteBookById implements Task {


    private final String id;
    private final String token;

    public DeleteBookById(String id,String token) {

        this.id = id;
        this.token=token;

    }

    public static Performable fromAPI(String id,String token) {
        return instrumented(DeleteBookById.class,id,token);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Delete.from("/booking/"+id).with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                        .header("Content-Type", "application/json")
                        .cookie("token",token)
                        .filter(new RestAssuredRequestFilter2()))
                 );
        RestAssuredRequestFilter2.example();
    }
}
