package com.continousTesting.base.Utils;


import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;


public class RestAssuredRequestFilter2 implements Filter {

        public static String textToPrint;

        @Override
        public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {

            Response response = ctx.next(requestSpec, responseSpec);

            textToPrint = "<-------->\n"+requestSpec.getMethod() + " " + requestSpec.getURI() + " \n Request Body =>" + requestSpec.getBody() + "\n Response Status => " +
                    response.getStatusCode() + " " + response.getStatusLine() + " \n Response Body => " + response.getBody().prettyPrint()+"\n<-------->";

            return response;


        }

        public static void example(){

            DataFileWriter.Writer(textToPrint,"DatosGrabados.log");
        }





    }


