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

public class ContactUsApiTest extends ApiBase {
    UserApi userApi;
    FeedbackReq feedbackReq;
    ContactUsApi contactUsApi;

    @Feature(value = "User can send feedback")
    @Story(value = "User can send feedback with valid values")
    @Description(value = "User can send feedback with valid values")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User can send feedback")
    public void userCanSendMessageFeedbackViaApi() throws JsonProcessingException {
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

    @Feature(value = "User can not send feedback with invalid email")
    @Story(value = "User can not send feedback with invalid email")
    @Description(value = "User can not send feedback with invalid email")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User can not send feedback with invalid email")
    public void userCanNotSendFeedbackWithInvalidEmail() throws JsonProcessingException {
        String newUserEmail = "wWw1s1trieng12324@gmail.com";
        String password = "Manowar33246";

        String name = "Nata";
        String email = "wWw1s1trieng12324gmail.com";
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

    @Feature(value = "User can not send feedback")
    @Story(value = "User can not send feedback without name")
    @Description(value = "User can not send feedback without name")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User can not send feedback without name")
    public void userCanNotSendFeedbackWithoutName() throws JsonProcessingException {
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

    @Feature(value = "User can not send feedback")
    @Story(value = "User can not send feedback without email")
    @Description(value = "User can not send feedback without email")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User can not send feedback without email")
    public void userCanNotSendFeedbackWithoutEmail() throws JsonProcessingException {
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

    @Feature(value = "User can not send feedback")
    @Story(value = "User can not send feedback without message")
    @Description(value = "User can not send feedback without message")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User can not send feedback without message")
    public void userCanNotSendFeedbackWithoutMessage() throws JsonProcessingException {
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

}


