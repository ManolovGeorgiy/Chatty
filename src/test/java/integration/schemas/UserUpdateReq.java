package integration.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserUpdateReq {
    @JsonProperty("avatarUrl")
    private String avatarUrl;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("birtDate")
    private String birtDate;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("gender")
    private String gender;

    @JsonProperty("backgroundUrl")
    private String backgroundUrl;
    @JsonProperty("blocked")
    private int blocked;  //boolean

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirtDate() {
        return birtDate;
    }

    public void setBirtDate(String birtDate) {
        this.birtDate = birtDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public int getBlocked() {
        return blocked;
    }

    public void setBlocked(int blocked) {
        this.blocked = blocked;
    }
}
