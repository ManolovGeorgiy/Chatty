package integration.admin;

import com.github.javafaker.Faker;
import integration.ApiBase;
import integration.schemas.LoginReq;
import io.restassured.response.Response;

public class LoginReqApi extends ApiBase {
    Response response;
    LoginReq loginReq;
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    public getLoginReq rndDataForGetLogin(String email, String password){
        getLoginReq getLoginReq = new getLoginReq();
        getLoginReq.setEmail(email);
        getLoginReq.setPassword(password);
        return getLoginReq;
    }
    public void getLoginReq (int code,String email,String password){
        String endpoint = "/api/auth/login";
        Object body = rndDataForGetLogin(email,password);
        Response request;
        request = putRequest(endpoint,200,email,password);
    }
}
