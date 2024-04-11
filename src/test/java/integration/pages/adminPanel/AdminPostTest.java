package integration.pages.adminPanel;

import integration.ApiBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AdminPostTest extends ApiBase {
    @Test
    public void testCreateNewPost() {
        String requestBody = "{\"title\": \"test title\",\"body\": \"test body\"}";

        given().
                contentType("application/json").
                body(requestBody).
                when().
                post("/api/admin/posts").
                then().
                assertThat().
                statusCode(201).
                body("title", equalTo("test title")).
                body("body", equalTo("test body"));
    }
    @Test
    public void testEditPost() {
        // Предположим, что для редактирования поста требуется передать идентификатор поста
        int postId = 1;

        // Новые данные для редактирования поста
        String updatedTitle = "Updated Title";
        String updatedBody = "Updated Body";

        // Формируем тело запроса для редактирования поста
        String requestBody = String.format("{\"title\": \"%s\", \"body\": \"%s\"}", updatedTitle, updatedBody);

        given().
                contentType("application/json").
                body(requestBody).
                when().
                put("/api/admin/posts/{postId}", postId). // Здесь {postId} будет заменен на фактический идентификатор поста
                then().
                assertThat().
                statusCode(200).
                body("title", equalTo(updatedTitle)).
                body("body", equalTo(updatedBody));
    }
    @Test
    public void testDeletePost() {
        // Предположим, что для удаления поста требуется передать идентификатор поста
        int postId = 1;

        given().
                when().
                delete("/api/admin/posts/{postId}", postId). // Здесь {postId} будет заменен на фактический идентификатор поста
                then().
                assertThat().
                statusCode(204); // Предположим, что успешное удаление возвращает статус код 204
    }



}
