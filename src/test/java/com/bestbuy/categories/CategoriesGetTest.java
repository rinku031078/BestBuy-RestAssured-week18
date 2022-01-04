package com.bestbuy.categories;

import com.bestbuy.testbase.TestBaseForCategories;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * @author Anand Tripathi
 * @project BestBuy-API-RestAssured
 * @created 03/01/2022
 */
public class CategoriesGetTest extends TestBaseForCategories {


    @Test
    public void getAllCategories(){
        Response response = given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleCategoryById(){
        Response response = given()
                .pathParam("id","pcmcat748300579354")
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getCategoryByName(){
        Response response = given()
                .pathParam("name", "Learning Toys")
                .when()
                .get("/{name}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
