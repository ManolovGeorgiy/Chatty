package integration.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostGetReq {
    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;
    @JsonProperty("body")
    private String body;

    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("createAt")
    private String createAt;
    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonProperty("draft")
    private int draft; //boolean

    @JsonProperty("user")
    private String user;
}