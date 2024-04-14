package e2e.pages.login;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPageNatalie {
    public SelenideElement loginInputNatalie = $x("//input[@name='email']");
    public SelenideElement passwordInputNatalie = $x("//input[@name='password']");
    public SelenideElement submitButtonNatalie = $x("//button[@class='registration-btn']");

    @Step("Login step")
    public void login(String email, String password) {
        loginInputNatalie.shouldBe(Condition.visible, Duration.ofSeconds(10)).sendKeys(email);
        passwordInputNatalie.sendKeys(password);
        submitButtonNatalie.click();
    }
}
