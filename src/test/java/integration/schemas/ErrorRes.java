package integration.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorRes {
    @JsonProperty("httpStatus")
    private String httpStatus;

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("message")
    private String message;
}
