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
public class CategoriesPostTest extends TestBaseForCategories {

    @Test
    public void createNewCategory() {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Computer Dept");
        categoriesPojo.setId("abcat00109874");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();


    }

}
