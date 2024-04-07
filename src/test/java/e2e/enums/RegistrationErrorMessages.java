package e2e.enums;

import lombok.Getter;

@Getter
public enum RegistrationErrorMessages {

    INCORRECT_EMAIL("Incorrect email format"),
    INCORRECT_PASSWORD("Password must be 8-100 characters and include at least one letter and one digit"),
    NOT_MATCH_PASSWORD("Passwords do not match");

    private final String value;

    RegistrationErrorMessages(String value) {
        this.value = value;
    }
}
