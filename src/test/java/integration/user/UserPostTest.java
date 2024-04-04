package integration.user;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserPostTest extends ApiBase{
    @Test
    public void testCreateNewPost(){
        String requestBody = "{\"userId\": 1,\"title\": \"test title\",\"body\": \"test body\"}";
        given().
                contentType("application/json").
                body(requestBody).
                when().
                post("/api/posts").
                then().
                assertThat().
                statusCode(201).
                body("userId", equalTo(1)).
                body("title", equalTo("test title")).
                body("body", equalTo("test body"));
    }

    // Добавьте другие тесты здесь, если это необходимо

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
                put("/api/posts/{postId}", postId). // Здесь {postId} будет заменен на фактический идентификатор поста
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
                delete("/api/posts/{postId}", postId). // Здесь {postId} будет заменен на фактический идентификатор поста
                then().
                assertThat().
                statusCode(204); // Предположим, что успешное удаление возвращает статус код 204
    }


}


