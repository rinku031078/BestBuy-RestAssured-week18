package com.bestbuy.stores;

import com.bestbuy.testbase.TestBaseForStores;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * @author Anand
 * @project BestBuy-API-RestAssured
 * @created 03/01/2022
 */
public class StoresDeleteTest extends TestBaseForStores {

    @Test
    public void deleteSingleStoreData(){
        Response response = given()
                .pathParam("id", "8929")
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
