package com.continousTesting.base.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class ResponseNameBooking {

    public static Question<String> getName() {

        return actor -> SerenityRest.lastResponse().path("booking.firstname");
    }

    public static Question<String> getLastName() {

        return actor -> SerenityRest.lastResponse().path("booking.lastname");
    }

    public static Question<String> getName2() {

        return actor -> SerenityRest.lastResponse().path("firstname");
    }




    public static Question<String> getLastName2() {

        return actor -> SerenityRest.lastResponse().path("lastname");
    }




}
