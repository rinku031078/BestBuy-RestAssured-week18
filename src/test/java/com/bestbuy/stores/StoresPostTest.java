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
public class StoresPostTest extends TestBaseForStores {

    @Test
    public void createNewStore(){

        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("Horley");
        storesPojo.setType("BigBox");
        storesPojo.setAddress("10 Downing Street");
        storesPojo.setAddress2("London Road");
        storesPojo.setCity("London");
        storesPojo.setState("surrey");
        storesPojo.setZip("55305");
        storesPojo.setLat(44.969658);
        storesPojo.setLng(-93.449539);
        storesPojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(storesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

}


