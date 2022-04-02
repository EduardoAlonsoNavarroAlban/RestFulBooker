package com.continousTesting.base.Utils;


import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




public class RestAssuredRequestFilter implements Filter {
        private static final Log log = LogFactory.getLog(RestAssuredRequestFilter.class);
        public static String alonso;


        public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {


            Response response = ctx.next(requestSpec, responseSpec);

            String nn = Integer.toString(response.statusCode());
            String sSubCadena = nn.substring(0,1);
            String valor = StringUtils.rightPad(sSubCadena, 3, "0");

            if (!valor.equals("200")) {  //verificando que todas las respuestas 2xx sean correctas, si no falsas

                log.error(requestSpec.getMethod() + " " + requestSpec.getURI() + " => " +
                        response.getStatusCode() + " " + response.getStatusLine());


            }
            log.info(requestSpec.getMethod() + " " + requestSpec.getURI() + " \n Request Body =>" + requestSpec.getBody() + "\n Response Status => " +
                    response.getStatusCode() + " " + response.getStatusLine() + " \n Response Body => " + response.getBody().prettyPrint());

           alonso = requestSpec.getMethod() + " " + requestSpec.getURI() + " \n Request Body =>" + requestSpec.getBody() + "\n Response Status => " +
                    response.getStatusCode() + " " + response.getStatusLine() + " \n Response Body => " + response.getBody().prettyPrint();

            return response;

        }

        public static void example(){

            DataFileWriter.Writer(alonso,"DatosGrabados.log");
        }
    }


