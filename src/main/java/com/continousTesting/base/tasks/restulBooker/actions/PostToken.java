package com.continousTesting.base.tasks.restulBooker.actions;

import com.continousTesting.base.Utils.RestAssuredRequestFilter2;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostToken implements Task {


    private final String bodyCreateTokenApiRestullbooker;

    public PostToken(String bodyCreateTokenApiRestullbooker) {

        this.bodyCreateTokenApiRestullbooker = bodyCreateTokenApiRestullbooker;

    }

    public static Performable fromAPI(String bodyCreateTokenApiRestullbooker) {
        return instrumented(PostToken.class,bodyCreateTokenApiRestullbooker);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Post.to("/auth").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON).
                body(bodyCreateTokenApiRestullbooker)
                .filter(new RestAssuredRequestFilter2())
                ));

                RestAssuredRequestFilter2.example();


    }



}
