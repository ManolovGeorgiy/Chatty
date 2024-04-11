package integration.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeedbackReq {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;
    @JsonProperty("content")
    private String content;
}
