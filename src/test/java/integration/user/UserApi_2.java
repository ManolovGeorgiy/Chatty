package integration.user;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class UserApi_2 {
        @BeforeClass
        public void setUp(){
            //Установка базового URI для API
            RestAssured.baseURI = "http://chatty.telran-edu.de:8089/";
        }
    }


