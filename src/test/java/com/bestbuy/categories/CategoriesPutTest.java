package com.bestbuy.categories;

import com.bestbuy.model.CategoriesPojo;
import com.bestbuy.testbase.TestBaseForCategories;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * @author Anand Tripathi
 * @project BestBuy-API-RestAssured
 * @created 03/01/2022
 */
public class CategoriesPutTest extends TestBaseForCategories {

    @Test
    public void updateCategoryWithPut(){
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Computer Shop");
        categoriesPojo.setId("abcat00109874");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id","abcat00109874")
                .body(categoriesPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }


}
