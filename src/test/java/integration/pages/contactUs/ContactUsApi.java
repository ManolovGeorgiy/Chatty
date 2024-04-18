package integration.pages.contactUs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.ApiBase;
import integration.schemas.FeedbackReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class ContactUsApi extends ApiBase {
    public  ContactUsApi(String token) {
        super(token);
    }
<<<<<<< HEAD
        @Step("Send message to the feedback :{name},{email},{content}")
        public String setDataToTheFeedback(FeedbackReq feedbackReq, int expectedStatusCode) throws JsonProcessingException {
            String endpoint = "/api/feedback";
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonRequestBody = objectMapper.writeValueAsString(feedbackReq);
            Response response = postRequest(endpoint,expectedStatusCode,jsonRequestBody);
=======
        @Step("Send message to the setFeedbackForm :{name},{email},{content}")
        public String setDataToTheFeedback(FeedbackReq feedbackReq, int code) throws JsonProcessingException {
            String endpoint = "/api/feedback";
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonRequestBody = objectMapper.writeValueAsString(feedbackReq);
            Response response = postRequest(endpoint,code,jsonRequestBody);
>>>>>>> origin/dev_Natalie
            switch (response.getStatusCode()) {
                case 200:
                    return response.asString();
                case 400:
                    return "Bad Request: " + response.jsonPath().getString("message");
                case 401:
                    return "Unauthorized: " + response.jsonPath().getString("message");
                default:
                    return "Unexpected status code: " + response.getStatusCode() + " - " + response.asString();
            }
            //https://stackoverflow.com/questions/22561527/handling-custom-error-response-in-jax-rs-2-0-client-library
    }
}
