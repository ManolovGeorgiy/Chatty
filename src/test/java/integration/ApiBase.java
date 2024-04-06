package integration;

import config.Config;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.URI;

public class ApiBase {
    private final Config config = new Config();
    private final String BASE_URI = config.getProjectUrl();
    private RequestSpecification spec;

    public ApiBase() {
        RequestSpecification spec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .addHeader("RefreshToken", BASE_URI)
                .build();
    }


    public Response getRequest(String endpoint, int code) {
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .log().all()
                .get(endpoint)
                .then().log().all()
                .extract().response();
        validateStatusCode(response, code);
        return response;
    }

    protected Response getRequestWithParam(String endpoint, int code, String paramName, int id) {
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .pathParam(paramName, id)
                .log().all()
                .get(endpoint)
                .then().log().all()
                .extract().response();
        validateStatusCode(response, code);
        return response;
    }

    private void validateStatusCode(Response response, int code) {
    }

    protected Response getRequestWithParamString() {

        Response response = RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .pathParam(paramName, paramValue)
                .log().all()
                .get(endpoint)
                .then().log().all()
                .extract().response();
        if (refreshToken != null && !refreshToken.isEmpty()) {
            refreshAccessToken(refreshToken);
        }
        validateStatusCode(response, code);
        return response;
    }

    protected Response postRequest(String endpoint, int code, Object body) {
        Response response = RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .post(endpoint)
                .then().log().all()
                .extract().response();
        validateStatusCode(response, code);
        return response;
    }

    protected Response putRequest(String endpoint, int code, String email, Object body) {
        Response response = RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .put(endpoint)
                .then().log().all()
                .extract().response();
        validateStatusCode(response, code);
        return response;
    }

    protected Response deleteRequest(String endpoint, int code, int id) {
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .pathParam("id", id)
                .log().all()
                .delete(endpoint)
                .then().log().all()
                .extract().response();
        validateStatusCode(response, code);
        return response;
    }


    public void refreshAccessToken(String refreshToken) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(BASE_URI);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Access-Token", refreshToken);
        this.spec = requestSpecBuilder
                .build();
    }
}
