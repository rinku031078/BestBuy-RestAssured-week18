package com.bestbuy.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * @author Anand Tripathi
 * @project BestBuy-API-RestAssured
 * @created 03/01/2022
 */
public class TestBaseForStores {

    @BeforeClass
    public static void initialize() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/stores";

    }
}
