package integration.user;

import integration.user.AdminApi;
import org.testng.annotations.Test;

public class UserApiTest extends AdminApi {

    AdminApi adminApi;


    @Test
    public void userRegistration(){

        String email = "tatar@abv.bg";
        String password = "Manowar33246";
        String confirmPassword = "Manowar33246";
        String userRole = "admin"; // Предполагается, что роль пользователя "user", а не "Admin"

        adminApi = new AdminApi();
        String response = adminApi.newAdminRegistration(email, password, confirmPassword, userRole, 201);

        // Примерный код для обновления access token с использованием refresh token
        // Это обычно не выполняется сразу после регистрации, но приведено для примера
        adminApi.refreshAccessToken(response, 201);

        // Примерный код для входа пользователя
         adminApi.userLogin(email, password, 200);
    }

}
