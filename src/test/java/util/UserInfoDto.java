package util;

import lombok.Data;

@Data
public class UserInfoDto {
    private String id;
    private String email;
    private String name;
    private String surname;
    private String phone;
    private String role;
    private String gender;
    private String birthDate;
    private String avatarUrl;
    private String backgroundUrl;
    private String blocked;
}