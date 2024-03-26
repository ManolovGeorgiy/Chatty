package e2e.enums;

import lombok.Getter;

@Getter
public enum SideBarInfo {
    USERPROFILE("Your Profile"),
    DRAFT("my draft"),
    USERS("admin panel"),
    LOGIN("logout");
    public final String value;


    SideBarInfo(String value) {
        this.value = value;
    }
}
