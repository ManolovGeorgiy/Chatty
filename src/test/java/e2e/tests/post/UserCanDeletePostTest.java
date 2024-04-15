package e2e.tests.post;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.Header;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.post.EditPostPage;
import integration.pages.post.PostApi;
import integration.pages.user.UserApi;
import integration.schemas.PostCreateReq;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class UserCanDeletePostTest extends TestBase {

    Faker faker = new Faker();
    UserApi userApi;
    PostApi postApi;
    PostCreateReq postCreateReq;
    LoginPage loginPage;
    HomeBlogPage homeBlogPage;
    Header header;
    EditPostPage editPostPage;

    @Epic(value = "User can delete post")
    @Feature(value = "User deleted post")
    @Description(value = "User can delete post")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "CHATTY-8")
    public void userCanDeletePost() throws JsonProcessingException {

        String email = "tatar1@abv.bg";
        String password = "Manowar33246";

        String title = "Chatty";
        String description = "GPower";
        String body = faker.lorem().sentence(10);
        String imageURL = ("https://dfstudio-d420.kxcdn.com/wordpress/wp-content/uploads/2019/06/digital_camera_photo-1080x675.jpg");


        userApi = new UserApi();
        String token = userApi.login(email, password, 200);

        postCreateReq = new PostCreateReq();
        postCreateReq.setTitle(title);
        postCreateReq.setDescription(description);
        postCreateReq.setBody(body);
        postCreateReq.setImageUrl(imageURL);

        postApi = new PostApi(token);
        String response = postApi.createPost(201, postCreateReq);
        JsonPath jsonPath = new JsonPath(response);
        String postId = jsonPath.getString("id");
        postApi.getPostId(postId,200);

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homeBlogPage = new HomeBlogPage(app.driver);

        header = new Header(app.driver);
        header.waitForLoading();
        header.myPostClick();
        header.waitForLoading();
        header.setMyPostTab();

        editPostPage = new EditPostPage(app.driver);
        editPostPage.waitForLoading();
        editPostPage.deletePostButtonClick();

        homeBlogPage = new HomeBlogPage(app.driver);

    }
}
