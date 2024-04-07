package integration;

import config.Config;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiBase {
    private final Config config = new Config();
    private final String BASE_URI = config.getProjectUrl();
    private RequestSpecification spec;


    public ApiBase() {
        this.spec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }

    public ApiBase(String token) {
        this();
        this.spec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .addHeader("RefreshToken", token)
                .build();
    }

    protected Response getRequest(String endpoint, int code) {
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .log().all()
                .get(endpoint);
        validateStatusCode(response, code);
        return response;
    }

    protected Response getRequestWithQueryParam(String endpoint, int code, String paramName, String paramValue, String refreshToken) {
        Response response = RestAssured.given()
                .spec(spec)
                .param(paramName, paramValue)
                .log().all()
                .get(endpoint);
        if (refreshToken != null && !refreshToken.isEmpty()) {
            refreshAccessToken(refreshToken);
        }
        validateStatusCode(response, code);
        return response;
    }

    protected Response getRequestWithParamString(String endpoint, int code,String paramName, String paramValue){
        Response response = RestAssured.given()
                .spec(spec)
                .pathParam(paramName,paramValue)
                .log().all()
                .get(endpoint);
        response.then().assertThat().statusCode(code);
        return response;
    }

    protected Response postRequest(String endpoint, int code, Object body) {
        Response response = RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .post(endpoint);
        validateStatusCode(response, code);
        return response;
    }

    protected Response putRequest(String endpoint, int code, Object body) {
        Response response = RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .put(endpoint);
        validateStatusCode(response, code);
        return response;
    }

    protected Response deleteRequest(String endpoint, int code, int id) {
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .pathParam("id", id)
                .log().all()
                .delete(endpoint);
        validateStatusCode(response, code);
        return response;
    }

    private void validateStatusCode(Response response, int code) {
        response.then().assertThat().statusCode(code);
    }

    protected void refreshAccessToken(String refreshToken) {
        // Логика обновления токена
    }
}
