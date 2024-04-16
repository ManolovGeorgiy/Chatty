package integration.tests.contactUs;

import com.fasterxml.jackson.core.JsonProcessingException;
import integration.pages.contactUs.ContactUsApi;
import integration.pages.user.UserApi;
import integration.schemas.FeedbackReq;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContactUsApiTest {

    UserApi userApi;
    ContactUsApi contactUsApi;
    FeedbackReq feedbackReq;

    @Test(description = "User can send message")
    public void userCanSendMessageToTheContactUs() throws JsonProcessingException {
        String emailUser = "feedback@gmail.com";
        String password = "Manowar33246";

        String name = "Georgiy";
        String emailContact = "feedback@gmail.com";
        String content = "Hallo Chatty";
        userApi = new UserApi();
        String token = userApi.login(emailUser, password, 200);

        feedbackReq = new FeedbackReq();
        feedbackReq.setName(name);
        feedbackReq.setEmail(emailContact);
        feedbackReq.setContent(content);

        contactUsApi = new ContactUsApi(token);
        contactUsApi.setDataToTheFeedback(feedbackReq,201);

        Assert.assertEquals("Georgiy", feedbackReq.getName());
        Assert.assertEquals("feedback@gmail.com", feedbackReq.getEmail());
        Assert.assertEquals("Hallo Chatty", feedbackReq.getContent());


    }
    @Test(description = "user can not send message with invalid email")
    public void userCanNotSendMessageWithInvalidEmail() throws JsonProcessingException {
        String email = "feedback@gmail.com";
        String password = "Manowar33246";

        String name = "Georgiy";
        String emailContact = "feedbackgmail.com";
        String content = "Hallo Chatty";
        userApi = new UserApi();
        String token = userApi.login(email, password, 200);
        feedbackReq = new FeedbackReq();
        feedbackReq.setName(name);
        feedbackReq.setEmail(emailContact);
        feedbackReq.setContent(content);

        contactUsApi = new ContactUsApi(token);
        contactUsApi.setDataToTheFeedback(feedbackReq,400);
    }
    @Test(description = "user cannot send message without name")
    public void userCanNOtSendMessageWithoutName() throws JsonProcessingException {
        String email = "feedback@gmail.com";
        String password = "Manowar33246";

        String name = "";
        String emailContact = "feedback@gmail.com";
        String content = "Hallo Chatty";
        userApi = new UserApi();
        String token = userApi.login(email, password, 200);

        feedbackReq = new FeedbackReq();
        feedbackReq.setName(name);
        feedbackReq.setEmail(emailContact);
        feedbackReq.setContent(content);

        contactUsApi = new ContactUsApi(token);
        contactUsApi.setDataToTheFeedback( feedbackReq,400);
    }
}
