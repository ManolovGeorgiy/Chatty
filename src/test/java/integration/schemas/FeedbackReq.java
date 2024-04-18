package integration.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeedbackReq {
<<<<<<< HEAD
    @JsonProperty("email")
    private String email;
    @JsonProperty("content")
    private String content;
    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getContent() {return content;}

    public void setContent(String content) {this.content = content;}


    public String getEmail() {
        return email;
=======


    public String getName() {
        return name;
>>>>>>> origin/dev_Natalie
    }

    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD
=======

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("name")
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("email")
    private String email;
    @JsonProperty("content")
    private String content;
>>>>>>> origin/dev_Natalie
}
