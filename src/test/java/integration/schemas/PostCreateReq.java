package integration.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostCreateReq {
    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;
    @JsonProperty("body")
    private String body;

    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("publishDate")
    private String publishDate;

    @JsonProperty("draft")
    private int draft; //boolean

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getDraft() {
        return draft;
    }

    public void setDraft(int draft) {
        this.draft = draft;
    }
}
