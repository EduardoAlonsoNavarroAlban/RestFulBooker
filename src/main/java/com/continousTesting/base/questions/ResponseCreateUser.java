package com.continousTesting.base.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class ResponseCreateUser {

    public static Question<String> getName() {
        return actor -> SerenityRest.lastResponse().path("name");
    }
    public static Question<String> getId() {
        return actor -> SerenityRest.lastResponse().path("id");
    }

  //  public static Question<String> getFirstName() {
  //      return actor -> SerenityRest.lastResponse().path("data.first_name");
  //  }


}
