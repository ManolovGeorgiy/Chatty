package integration.tests.contactUs;

import com.beust.ah.A;
import com.fasterxml.jackson.core.JsonProcessingException;
import integration.pages.contactUs.ContactUsApi;
import integration.pages.user.UserApi;
import integration.schemas.FeedbackReq;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserCanSendMessageTest {

    UserApi userApi;
    ContactUsApi contactUsApi;
    FeedbackReq feedbackReq;

    private void checkContactUsData(FeedbackReq feedbackReq) throws JsonProcessingException {

        JsonPath actualObjects = JsonPath.given(contactUsApi.setDataToTheFeedback(feedbackReq,200));
        LinkedHashMap<String,String> postObjects = new LinkedHashMap<>();
        postObjects.put(actualObjects.getString("name"),feedbackReq.getName());
        postObjects.put(actualObjects.getString("emailContact"),feedbackReq.getEmail());
        postObjects.put(actualObjects.getString("content"),feedbackReq.getContent());

        for (Map.Entry<String,String> postObject:postObjects.entrySet()){
            String actualResult = postObject.getKey();
            String expectedResult =postObject.getValue();
            Assert.assertEquals(actualResult,expectedResult, actualResult + " is not equals " + expectedResult);
        }
    }
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
