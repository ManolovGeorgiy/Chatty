package integration.user;


import integration.ApiBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import java.util.LinkedHashMap;

public class UserApi extends ApiBase {
    Response response;

    public UserApi(){

    }

    @Step("Login via api: {email},{password}")
    public String login(String email, String password,int code) {
        String endpoint = "/api/auth/login";
        LinkedHashMap<String, String> body = new LinkedHashMap<>();
        body.put("email", email);
        body.put("password", password);
        response = postRequest(endpoint,code,body);
        String token = response.jsonPath().getString("accessToken" + "RefreshToken");
        String refreshToken = null;
        return response.jsonPath().getString("refreshToken" + refreshToken);

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
    public String refreshToken(String refreshToken, int code) {
        String endpoint = "/api/auth/refresh";
        LinkedHashMap<String, String> body = new LinkedHashMap<>();
        body.put( "RefreshToken" + refreshToken, String.valueOf(code));
        response = postRequest(endpoint, code, body);
        return response.asString();
    }


    public Response getUser (int code, String token){
        String endpoint = "api/me";
        response = getRequestWithParamString(endpoint,code,"token",token);
        return response;
    }

}