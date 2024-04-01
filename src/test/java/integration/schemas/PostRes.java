package integration.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRes {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private  String title;

    @JsonProperty("description")
    private  String description;

    @JsonProperty("body")
    private String body;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("publishDate")
    private String publishDate;

    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("draft")
    private boolean draft;

    @JsonProperty("userId")
    private String userId;
}
