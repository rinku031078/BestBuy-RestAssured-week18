package com.bestbuy.categories;

import com.bestbuy.model.CategoriesPojo;
import com.bestbuy.testbase.TestBaseForCategories;
import com.bestbuy.utils.TestUtils;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * @author Anand Tripathi
 * @project BestBuy-API-RestAssured
 * @created 03/01/2022
 */
public class CategoriesCRUDTest extends TestBaseForCategories {

    static String name = "Computers and Electronics";
    static String id = TestUtils.getRandomName();
    static String categoryId;

    @Test
    public void test001() {

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName(name);
        categoriesPojo.setId(id);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
    public void test002() {
        String p1 = "data.findAll{it.name='";
        String p2 = "'}.get(0)";

        HashMap value =
                given()
                        .when()
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path(p1 + name + p2);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(value));
        categoryId = (String) value.get("id");
    }

    @Test
    public void test003() {
        String p1 = "data.findAll{it.name='";
        String p2 = "'}.get(0)";


        name = name + " (Updated)";

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName(name);
        categoriesPojo.setId(id);

        given()
                .header("Content-Type", "application/json")
                .pathParam("categoryId", categoryId)
                .body(categoriesPojo)
                .when()
                .put("/{categoryId}")
                .then().log().all().statusCode(200);


        HashMap<String, Object> value =

                given()
                        .when()
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path(p1 + name + p2);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(value));
    }

    @Test
    public void test004(){

        given()
                .pathParam("categoryId", categoryId)
                .when()
                .delete("/{categoryId}")
                .then()
                .statusCode(200);

        given()
                .pathParam("categoryId", categoryId)
                .when()
                .get("/{categoryId}")
                .then()
                .statusCode(404);
    }
}
