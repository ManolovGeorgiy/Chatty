package integration.tests.post;

import Integration.authApi.AuthApi;
import Integration.post.CreatePost;
import Integration.post.DeletePost;
import Integration.post.GetPostByPostId;
import Integration.uploadPhoto.UploadPhoto;
import Integration.schemas.PostCreateReq;
import Integration.schemas.UserUpdateReq;
import Integration.user.GetUser;
import Integration.user.UpdateUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;
import integration.pages.user.UserApi;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class UserCanCratePostAndDeletePost {
    Faker faker = new Faker();
    UserApi userApi;
     UserInfo userInfo;
    UploadPhoto uploadPhoto;
    UpdateUser updateUser;
    CreatePost createPost;
    GetPostByPostId getPostByPostId;
    DeletePost deletePost;
    @Epic(value = "Create post")
    @Feature(value= "Creating post")
    @Story(value = "User can create post with role user")
    @Description(value = "User can create post")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User Can create post")
    public void userCanCreatePost() throws JsonProcessingException {
        String email = faker.internet().emailAddress();
        String password = "RedBull1234";
        String newName = "Georgiy";
        String newSurname = "Manolov";
        File filePath = new File("src/test/java/resources/5204092180870848355_121.jpg");

        String title = "My first post";
        String description = "Hello world";
        String body = "its beautiful";

        userApi = new UserApi();
        String token = UserApi.login(email, password, 200);

        getUser = new GetUser(token);
        String userJson = getUser.getUser(200);
        JsonPath object = new JsonPath(userJson);
        String userId = object.getString("id");

        uploadPhoto = new UploadPhoto(token);
        String imageURL = uploadPhoto.uploadImage(filePath, 201);
        System.out.println(imageURL);

        updateUser = new UpdateUser(token);
        UserUpdateReq userUpdateReq = new UserUpdateReq();
        userUpdateReq.setName(newName);
        userUpdateReq.setSurname(newSurname);
        userUpdateReq.setAvatarUrl(imageURL);

        updateUser.updateUser(userId, userUpdateReq, 200);
        String userJson1 = getUser.getUser(200);
        System.out.println(userJson1);

        PostCreateReq postCreateReq = new PostCreateReq();
        postCreateReq.setTitle(title);
        postCreateReq.setDescription(description);
        postCreateReq.setBody(body);
        postCreateReq.setImageUrl(imageURL);

        createPost = new CreatePost(token);
        String response = createPost.createPost(postCreateReq,201);
        JsonPath jsonPath = new JsonPath(response);
        String postId = jsonPath.getString("id");

        getPostByPostId = new GetPostByPostId(token);
        String postResponse=getPostByPostId.getPostByPostId(postId,200);
        JsonPath postJson = new JsonPath(postResponse);
        String postTitle = jsonPath.getString("title");
        String postDescription = jsonPath.getString("description");
        String postBody = jsonPath.getString("body");
        String postImageUrl = jsonPath.getString("imageUrl");

        Assert.assertEquals(title,postTitle);
        Assert.assertEquals(description,postDescription);
        Assert.assertEquals(body,postBody);
        Assert.assertEquals(imageURL,postImageUrl);

        deletePost = new DeletePost(token);
        deletePost.deletePost(postId,204);

        getPostByPostId.getPostByPostId(postId,404);
    }
}
