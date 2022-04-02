package com.continousTesting.base.Utils;


import net.serenitybdd.rest.SerenityRest;


public class PrintLog {

    public static void ReqRespLog() {

        final String s = SerenityRest.then().log().all().toString();
        System.out.println(s);
        DataFileWriter.Writer(s, "DatosGrabados.log");


    }


}
