package integration.tests.admin;
import integration.ApiBase;
import integration.pages.adminPanel.AdminApi;

import org.testng.annotations.Test;


public class AdminCanCreateEditAndDeleteUser extends ApiBase {

    AdminApi adminApi;
    private String baseURL = "http://chatty.telran-edu.de:8089";
    private String email = "Boba1234@mail.ru";
    private String password = "Boba1234";
    private String authToken;



    @Test(description = "Admin can edit a user")
    public void adminCanEditUser() {
        // LOGIN
        adminApi = new AdminApi();
    String token = adminApi.loginAdmin(email,password,200);

    }
}