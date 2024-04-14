package integration.pages.profile;

import integration.ApiBase;

public class ProfileApi extends ApiBase {

    public class Profile {


        private String avatarUrl;
        private String name;
        private String surname;
        private String birthDate;
        private String phone;
        private String gender;
        private String backgroundUrl;
        private boolean blocked;

        public Profile createProfile() {
            Profile profile = new Profile();
            profile.avatarUrl = "https://example.com/avatar.jpg";
            profile.name = "John";
            profile.surname = "Doe";
            profile.birthDate = "1990-01-01";
            profile.phone = "+1234567890";
            profile.gender = "Male";
            profile.backgroundUrl = "https://example.com/background.jpg";
            profile.blocked = false;

            return profile;
        }

    }
}
