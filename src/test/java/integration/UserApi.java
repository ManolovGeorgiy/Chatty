package integration;

import integration.schemas.LoginReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.LinkedHashMap;

public class UserApi extends ApiBase {

LoginReq loginReq;
Response response;

    @Step("Login via api: {email}, {password}")
    public String login(String email, String password, int code) {
        String endpoint = "/api/auth/login";
        LinkedHashMap<String, String> body = new LinkedHashMap<>();
        body.put("email", email);
        body.put("password", password);
        response = postRequest(endpoint, code, body);
        return response.header("accessToken");
    }
    @Step("Activation via api:refreshToken")
    public void activation( String token ,int code) {
        String endpoint = "/api/auth/refresh";
        getRequestWithParamString();
    }


}
