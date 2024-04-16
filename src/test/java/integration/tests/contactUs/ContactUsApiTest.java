package integration.tests.contactUs;


import com.fasterxml.jackson.core.JsonProcessingException;
import integration.ApiBase;
import integration.pages.contactUs.ContactUsApi;
import integration.pages.user.UserApi;
import integration.schemas.FeedbackReq;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static org.testng.AssertJUnit.assertNotNull;

public class ContactUsApiTest extends ApiBase {
    UserApi userApi;
    FeedbackReq feedbackReq;
    ContactUsApi contactUsApi;

    @Test(dependsOnMethods = "User can send feedback")
    public void userCanSendMessageFeedbackViaApi()throws JsonProcessingException {
        String newUserEmail = "wWw1s1trieng12324@gmail.com";
        String password = "Manowar33246";

        String name = "Nata";
        String email = "wWw1s1trieng12324@gmail.com";
        String content = "Sdsdf sdfg dfgh dfgh f sdfgh";

        userApi = new UserApi();
        String token = userApi.login(newUserEmail, password, 200);

        feedbackReq = new FeedbackReq();
        feedbackReq.setName(name);
        feedbackReq.setEmail(email);
        feedbackReq.setContent(content);

        contactUsApi = new ContactUsApi(token);
        contactUsApi.setDataToTheFeedback(feedbackReq, 201);

        Assert.assertEquals("Nata", feedbackReq.getName());
        Assert.assertEquals("wWw1s1trieng12324@gmail.com", feedbackReq.getEmail());
        Assert.assertEquals("Sdsdf sdfg dfgh dfgh f sdfgh", feedbackReq.getContent());
    }
    @Test(dependsOnMethods = "user can not send feedback with invalid email")
    public void userCanNotSendFeedbackWithInvalidEmail()throws JsonProcessingException{
        String newUserEmail = "wWw1s1trieng12324gmail.com";
        String password = "Manowar33246";

        String name = "Nata";
        String email = "wWw1s1trieng12324@gmail.com";
        String content = "Sdsdf sdfg dfgh dfgh f sdfgh";

        userApi = new UserApi();
        String token = userApi.login(newUserEmail, password, 200);

        feedbackReq = new FeedbackReq();
        feedbackReq.setName(name);
        feedbackReq.setEmail(email);
        feedbackReq.setContent(content);

        contactUsApi = new ContactUsApi(token);
        contactUsApi.setDataToTheFeedback(feedbackReq, 400);
    }

    @Test(description = "user can not send feedback without name")
    public void userCanNotSendFeedbackWithoutName()throws JsonProcessingException{
        String newUserEmail = "wWw1s1trieng12324@gmail.com";
        String password = "Manowar33246";

        String name = "";
        String email = "wWw1s1trieng12324@gmail.com";
        String content = "Sdsdf sdfg dfgh dfgh f sdfgh";

        userApi = new UserApi();
        String token = userApi.login(newUserEmail, password, 200);

        feedbackReq = new FeedbackReq();
        feedbackReq.setName(name);
        feedbackReq.setEmail(email);
        feedbackReq.setContent(content);

        contactUsApi = new ContactUsApi(token);
        contactUsApi.setDataToTheFeedback(feedbackReq, 400);
    }
    @Test(description = "user can not send feedback without email")
    public void userCanNotSendFeedbackWithoutEmail()throws JsonProcessingException{
        String newUserEmail = "wWw1s1trieng12324@gmail.com";
        String password = "Manowar33246";

        String name = "Nata";
        String email = "";
        String content = "Sdsdf sdfg dfgh dfgh f sdfgh";

        userApi = new UserApi();
        String token = userApi.login(newUserEmail, password, 200);

        feedbackReq = new FeedbackReq();
        feedbackReq.setName(name);
        feedbackReq.setEmail(email);
        feedbackReq.setContent(content);

        contactUsApi = new ContactUsApi(token);
        contactUsApi.setDataToTheFeedback(feedbackReq, 400);
    }
    @Test(description = "user can not send feedback without message")
    public void userCanNotSendFeedbackWithoutMessage()throws JsonProcessingException{
        String newUserEmail = "wWw1s1trieng12324@gmail.com";
        String password = "Manowar33246";

        String name = "Nata";
        String email = "wWw1s1trieng12324@gmail.com";
        String content = "";

        userApi = new UserApi();
        String token = userApi.login(newUserEmail, password, 200);

        feedbackReq = new FeedbackReq();
        feedbackReq.setName(name);
        feedbackReq.setEmail(email);
        feedbackReq.setContent(content);

        contactUsApi = new ContactUsApi(token);
        contactUsApi.setDataToTheFeedback(feedbackReq, 400);
    }

    @Feature(value = "Delete User")
    @Story(value = "Admin can Delete User")
    @Description(value = "Admin can Delete User")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Admin can Delete new User")
    public void adminCanLoginAndDeleteUser() {
        String email = "g.power@gmail.com";
        String password = "GPower3333";

        userApi = new UserApi();
        userApi.login(email, password,201);

        String emailLogin = "wWw1s1trieng12324@gmail.com";
        String passwordLogin = "Manowar33246";
        String deleteUserEndpoint = "/api/users";

        userApi = new UserApi();
        String token = userApi.login(emailLogin, passwordLogin, 200);

       /* UserInfoDto userInfo = getUserByEmail(token, email, 200).get(0);
        assertNotNull(userInfo);

        RestAssured.given()
                .spec(spec)
                .header("Authorization", "Bearer " + token)
                .when()
                .body(userInfo)
                .log().all()
                .delete(deleteUserEndpoint + "/" + userInfo.getId())
                .then().log().all()
                .extract().response();

        checkUserDelete(token, email, 404);*/

    }
}

