package integration.user;

import com.github.javafaker.service.FakeValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class ChattyApiTest_2 {
    private WebDriver driver;
@Test
    public void testGetUserById(){
    // Открываем страницу, где есть форма для отправки запроса к вашему API
    driver.get("http://chatty.telran-edu.de:8089/api/users/1");
    // Предположим, что API возвращает информацию о пользователе на этой странице
    // Например, вы можете найти элементы, содержащие имя пользователя и его идентификатор
    String userName = driver.findElement(By.id("user-name")).getText();
    String userId = driver.findElement(By.id("user-id")).getText();
    // Проверяем, что полученные данные соответствуют ожидаемым
    assertEquals(userName, "Leanne Graham");
    assertEquals(userId, "1");
}
    @Test
    public void testGetUserById2() {
        given().
                when().
                get("http://chatty.telran-edu.de:8089/api/users/1").
                then().
                assertThat().
                statusCode(200).
                body("id", equalTo(1)).
                body("name", equalTo("Leanne Graham"));
    }
    @Test
    public void testCreateNewPost() {
        String requestBody = "{\"userId\": 1,\"title\": \"test title\",\"body\": \"test body\"}";

        given().
                contentType("application/json").
                body(requestBody).
                when().
                post("http://chatty.telran-edu.de:8089/api/posts").
                then().
                assertThat().
                statusCode(201).
                body("userId", equalTo(1)).
                body("title", equalTo("test title")).
                body("body", equalTo("test body"));
    }
}


