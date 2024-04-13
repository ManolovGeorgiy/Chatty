package integration.tests.myTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;
import integration.pages.post.CreatePost;
import integration.pages.post.DeletePost;
import integration.pages.post.GetPostByPostId;
import integration.pages.post.UpdatePost;
import integration.pages.user.UserApi;
import integration.schemas.PostCreateReq;
import integration.schemas.PostUpdateReq;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;


public class UserCanCreateEditAndDeletePost {

    Faker faker = new Faker();
    UserApi userApi;
    CreatePost createPost;
    GetPostByPostId getPostByPostId;
    UpdatePost updatePost;
    DeletePost deletePost;

    private void checkPostData(String postId, PostCreateReq postCreateReq){

        JsonPath actualObjects = JsonPath.given(getPostByPostId.getPostId(postId,200));
        LinkedHashMap<String,String> postObjects = new LinkedHashMap<>();
        postObjects.put(actualObjects.getString("title"),postCreateReq.getTitle());
        postObjects.put(actualObjects.getString("description"),postCreateReq.getDescription());
        postObjects.put(actualObjects.getString("body"),postCreateReq.getBody());

        for (Map.Entry<String,String> postObject:postObjects.entrySet()){
            String actualResult = postObject.getKey();
            String expectedResult =postObject.getValue();
            Assert.assertEquals(actualResult,expectedResult, actualResult + " is not equals " + expectedResult);
        }
    }
    @Feature(value = "Creating post")
    @Story(value = "User can create a post")
    @Description(value = "User can create a post")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User Can create post")
    public void userCanCreatePost() throws JsonProcessingException {
        String email = "user.can.create.a.post@gmail.com";
        String password = "Manowar33246";

        String title = "Chatty";
        String description = "GPower";
        String body = "My first post";
        String imageURL = ("https://dfstudio-d420.kxcdn.com/wordpress/wp-content/uploads/2019/06/digital_camera_photo-1080x675.jpg");

        String editTitle = "GPower";
        String editDescription = "Beautiful";
        String editBody = "My new post";
        String editImageURL = ("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg");

        userApi = new UserApi();
        String token = userApi.login(email, password, 200);

        PostCreateReq postCreateReq = new PostCreateReq();
        postCreateReq.setTitle(title);
        postCreateReq.setDescription(description);
        postCreateReq.setBody(body);
        postCreateReq.setImageUrl(imageURL);

        createPost = new CreatePost(token);
        String response = createPost.createPost(201, postCreateReq);
        JsonPath jsonPath = new JsonPath(response);
        String postId = jsonPath.getString("id");

        getPostByPostId = new GetPostByPostId(token);
        checkPostData(postId,postCreateReq);

        PostUpdateReq postUpdateReq = new PostUpdateReq();
        postUpdateReq.setTitle(editTitle);
        postUpdateReq.setDescription(editDescription);
        postUpdateReq.setBody(editBody);
        postUpdateReq.setImageUrl(editImageURL);

        updatePost = new UpdatePost(token);
        String responseEdit = updatePost.updateUserPost(postId, postUpdateReq, 200);
        JsonPath jsonPathEdit = new JsonPath(responseEdit);
        String editPostId = jsonPathEdit.getString("id");

        deletePost = new DeletePost(token);
        deletePost.deleteUserPost(editPostId, 204);
    }
}
