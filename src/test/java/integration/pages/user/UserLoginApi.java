package integration.pages.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;

<<<<<<<< HEAD:src/test/java/integration/pages/user/UserLoginApi.java
public class UserLoginApi {
========
public class UserAuthLogin {
>>>>>>>> dev_Manolov:src/test/java/integration/pages/user/UserAuthLogin.java

    public static void main(String[] args) {
        String baseUrl = "http://chatty.telran-edu.de:8989";
        String endpoint = "/api/auth/login";


        String email = "tatar@abv.bg";
        String password = "Manowar33246";


        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .basePath(endpoint)
                .header("accept", "*/*")
                .header("Content-Type", "application/json")
                .body("{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }")
                .post();


        int statusCode = response.getStatusCode();
        System.out.println("Response Code: " + statusCode);


        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);


        if (statusCode == 200) {
            String accessToken = response.jsonPath().getString("accessToken");
            String refreshToken = response.jsonPath().getString("refreshToken");
            long expiration = response.jsonPath().getLong("expiration");
            System.out.println("Access Token: " + accessToken);
            System.out.println("Refresh Token: " + refreshToken);
            System.out.println("Expiration: " + expiration);
        }
    }
}
