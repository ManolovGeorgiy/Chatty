package integration.pages.homeBlog;

import integration.schemas.LoginReq;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.LinkedHashMap;

public class LoginReqApi {
    LoginReq loginReq;
    Response response;
    /*@Step("Login via api: {email}, {password}")
    public String login(String email, String password, int code) {
        String endpoint = "/api/auth/login";
        LinkedHashMap<String, String> body = new LinkedHashMap<>();
        body.put("email", email);
        body.put("password", password);
        response = postRequest(endpoint, code, body);
        return response.header("Access-Token");
        return response.header("RefreshToken");
    }
    protected Response postRequest(String endpoint, int code, Object body){
        RequestSpecification spec;
        Response response = RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .post(endpoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(code);
        return response;
    }*/
}
