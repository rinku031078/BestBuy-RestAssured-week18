package com.bestbuy.services;

import com.bestbuy.model.ServicesPojo;
import com.bestbuy.testbase.TestBaseForServices;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * @author Anand
 * @project BestBuy-API-RestAssured
 * @created 03/01/2022
 */
public class ServicesPatchTest extends TestBaseForServices {

    @Test
    public void updateServicesWithPatch() {

        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Computers Repairs");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", "26")
                .body(servicesPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
