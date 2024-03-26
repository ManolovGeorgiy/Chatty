package e2e.enums;

import lombok.Getter;

@Getter
public enum SideBarInfo {
    USERPROFILE("/userprofile"),
    DRAFT("/draft"),
    USERS("admin panel"),
    LOGIN("logout");
    public final String value;


    SideBarInfo(String value) {
        this.value = value;
    }
}
