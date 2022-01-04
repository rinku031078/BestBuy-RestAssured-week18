package com.bestbuy.stores;

import com.bestbuy.model.StoresPojo;
import com.bestbuy.testbase.TestBaseForStores;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * @author Anand
 * @project BestBuy-API-RestAssured
 * @created 03/01/2022
 */
public class StoresPatchTest extends TestBaseForStores {

    @Test
    public void updateStoreDataWithPatch(){
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("Brighton");
        storesPojo.setType("BigBox");
        storesPojo.setAddress("101 London road");
        storesPojo.setAddress2("");
        storesPojo.setCity("Brighton");
        storesPojo.setState("East Sussex");
        storesPojo.setZip("78089");
        storesPojo.setLat(44.964587);
        storesPojo.setLng(-88.446523);
        storesPojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id","8927")
                .body(storesPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
