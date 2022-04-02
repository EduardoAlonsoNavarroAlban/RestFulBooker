package com.continousTesting.base.tasks.restulBooker.actions;

import com.continousTesting.base.Utils.RestAssuredRequestFilter2;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostGetToken implements Task {




    public static Performable fromAPI() {
        return instrumented(PostGetToken.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Post.to("/auth").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON).
                body("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}")
                .filter(new RestAssuredRequestFilter2())
        ));

        RestAssuredRequestFilter2.example();


    }


}
