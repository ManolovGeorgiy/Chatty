package integration.user;

import integration.ApiBase;
import integration.schemas.UserRes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserReqApi extends ApiBase {

    @Test
    public void userCanWorkWithDateApiTest() {
       /* UserRes userMe = given()
                .when()
                .get("http://chatty.telran-edu.de:8089/login/api/me")
                .then()
                .contentType(ContentType.TEXT)
                .extract().as(UserRes.class);*/
        getRequest("/api/me", 200);
        //getRequestWithParamString("/api/me",200,UserRes.class,"id","Geory","e");
        /*Response response = RestAssured.given()
                .when()
                .log().all()
                .get("http://chatty.telran-edu.de:8089/login/api/me")
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(200);*/
    }
}
