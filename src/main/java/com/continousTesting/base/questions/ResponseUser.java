package com.continousTesting.base.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class ResponseUser {

    public static Question<String> getEmail() {
        return actor -> SerenityRest.lastResponse().path("data.email");
    }

    public static Question<String> getFirstName() {
        return actor -> SerenityRest.lastResponse().path("data.first_name");
    }

    public static Question<String> getLastName() {
        return actor -> SerenityRest.lastResponse().path("data.last_name");
    }

    public static Question<String> getName() {
        return actor -> SerenityRest.lastResponse().path("name");
    }

    public static Question<String> getJob() {
        return actor -> SerenityRest.lastResponse().path("job");
    }
}