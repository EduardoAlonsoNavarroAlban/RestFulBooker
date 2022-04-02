package com.continousTesting.base.tasks.restulBooker.actions;

import com.continousTesting.base.Utils.SchemaValidation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ValidaEsquemaResponse implements Task {


    private static String esquemaValidation;

    public synchronized static void setEsquemaValidation(String esquemaValidation) {
        ValidaEsquemaResponse.esquemaValidation = esquemaValidation;
    }

    public ValidaEsquemaResponse(String esquemaValidation) {
        setEsquemaValidation(esquemaValidation);
    }


    public static ValidaEsquemaResponse getSchemaResponse(String esquemaValidation) {
        return instrumented(ValidaEsquemaResponse.class,esquemaValidation);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        SchemaValidation.getSchemaResponse(esquemaValidation);
    }




}
