package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class ApiTestingCase {

    public String baseURL="http://localhost:3000/allGrocery";
    private static final String SHOW_USER_ENDPOINT = "/{name}";
    JSONObject request = new JSONObject();


    @Test
    public void testProductNameandPriceStock(){
       given().
                contentType(ContentType.JSON).
        when().
                get(baseURL).
                then().
                statusCode(HttpStatus.SC_OK).
                body(
                        "price[0]", is(3),
                            "price[1]",is(5),
                            "stock[0]",is(100),
                            "stock[1]",is(50)
                );

    }

    @Test
    public void testReturningEndpointByName(){
     Response response = given()
                 .when()
                 .get(baseURL + SHOW_USER_ENDPOINT)
                 .then()
                 .statusCode(HttpStatus.SC_BAD_REQUEST)
                 .extract().response();

                Assert.assertNotNull(response.getBody().jsonPath().getList("name").get(0));
    }

    @Test
    public void postProductWithIdNamePriceAndStock(){

        request.put("id",4 );
        request.put("name", "string");
        request.put("price", 12.3);
        request.put("stock", 3);

        given()
                .header("Content-type", "application/json")
                .and()
                .body(request.toJSONString())
                .when()
                .post(baseURL)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }
}
