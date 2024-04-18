package e2e.tests.post;

<<<<<<< HEAD
=======
import com.fasterxml.jackson.core.JsonProcessingException;
>>>>>>> origin/dev_Natalie
import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.Header;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.post.EditAPostForm;
import e2e.pages.post.EditPostPage;
<<<<<<< HEAD
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCanEditPostTest extends TestBase {

    Faker faker = new Faker();
=======
import integration.pages.post.PostApi;
import integration.pages.user.UserApi;
import integration.schemas.PostCreateReq;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserCanEditPostTest extends TestBase {

    Faker faker = new Faker();
    UserApi userApi;
    PostCreateReq postCreateReq;
    PostApi postApi;
>>>>>>> origin/dev_Natalie
    LoginPage loginPage;
    HomeBlogPage homeBlogPage;
    Header header;
    EditPostPage editPostPage;
    EditAPostForm editAPostForm;

<<<<<<< HEAD
=======
    private void checkPostData(String postId, PostCreateReq postCreateReq){

        JsonPath actualObjects = JsonPath.given(postApi.getPostId(postId,200));
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

>>>>>>> origin/dev_Natalie
    private void checkEditPostData(EditAPostForm page, String editTitle, String editDescription, String editContent) {
        String actualTitle = page.getEditTitle();
        String actualDescription = page.getEditDescriptionText();
        String actualContent = page.getEditContent();
        Assert.assertEquals(actualTitle, editTitle, actualTitle + " is not equal " + editTitle);
        Assert.assertEquals(actualDescription, editDescription, actualDescription + " is not equal " + editDescription);
        Assert.assertEquals(actualContent, editContent, actualContent + " is not equal " + editContent);
    }

    @Epic(value = "User can edit post")
    @Feature(value = "User edited post")
    @Description(value = "User can edit post")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User can edit existing post")
<<<<<<< HEAD
    public void userCanEditAPost() {
=======
    public void userCanEditAPost() throws JsonProcessingException {
>>>>>>> origin/dev_Natalie

        String email = "user.can.edit.post@abv.bg";
        String password = "RedBull1234";

<<<<<<< HEAD
=======
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
        checkPostData(postId,postCreateReq);

>>>>>>> origin/dev_Natalie
        String editTitle = "IT";
        String editDescription = "QA Engineer";
        String editContent = "HALLO WORLD";
        String imagePath = "uploadReferences/5204092180870848366_121.jpg";

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
        editPostPage.editPostButtonClick();
        editPostPage.waitForLoading();

        editAPostForm = new EditAPostForm(app.driver);
        editAPostForm.waitForLoading();
<<<<<<< HEAD
        editAPostForm.imageLoading(imagePath);
=======
        editAPostForm.uploadImageLoading(imagePath);
>>>>>>> origin/dev_Natalie
        editAPostForm.fillEditPostForm(editTitle, editDescription, editContent);
        checkEditPostData(editAPostForm, editTitle, editDescription, editContent);
        editAPostForm.clickEditSubmitButton();

        editPostPage = new EditPostPage(app.driver);
        editPostPage.waitForLoading();
    }
}
