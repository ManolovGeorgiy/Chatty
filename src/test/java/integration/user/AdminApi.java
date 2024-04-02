package integration.user;


import integration.ApiBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import java.util.LinkedHashMap;

public class AdminApi extends ApiBase {
    Response response;

    public AdminApi(){

    }

    @Step("Login via api: {email},{password}")
    public String login(String email, String password,int code) {
        String endpoint = "/api/auth/login";
        LinkedHashMap<String, String> body = new LinkedHashMap<>();
        body.put("email", email);
        body.put("password", password);
        response = postRequest(endpoint,code,body);
        //String refreshToken = response.jsonPath().getString("refreshToken");
        //return response.jsonPath().getString("refreshToken" + refreshToken);
        return response.header("RefreshToken");
    }
    @Step("New User Registration : {email},{password},{confirmPassword},{role}")
    public String newUserRegistration(String email, String password,String confirmPassword,String user ,int code) {
        String endpoint = "/api/auth/register";
        LinkedHashMap<String, String> body = new LinkedHashMap<>();
        body.put("email", email);
        body.put("password", password);
        body.put("confirmPassword", confirmPassword);
        body.put("user", user);
        response = postRequest(endpoint, code, body);
        return response.asString();
    }

    // Метод переименован и удалены ненужные параметры
    @Step("Activate New User: {token}")
    public void activateNewUser(String accessToken,String refreshToken, int code) {
        String endpoint = "/api/auth/token";
        LinkedHashMap<String, String> body = new LinkedHashMap<>();
        body.put("AccessToken: " + accessToken + ", RefreshToken: " + refreshToken, String.valueOf(code));
        response = postRequest(endpoint, code, body);
    }
}