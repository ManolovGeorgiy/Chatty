package integration.pages.profile;

import integration.ApiBase;

public class ProfileApi extends ApiBase {

    public class Profile {


        public String avatarUrl;
        public String name;
        public String surname;
        public String birthDate;
        public String phone;
        public String gender;
        public String backgroundUrl;
        public boolean blocked;

        public Profile createProfile() {
            Profile profile = new Profile();
            profile.avatarUrl = "https://example.com/avatar.jpg";
            profile.name = "John";
            profile.surname = "Doe";
            profile.birthDate = "1990-01-01";
            profile.phone = "+1234567890";
            profile.gender = "Male";
            //profile.backgroundUrl = "https://example.com/background.jpg";
            profile.blocked = false;

            return profile;
        }

    }
}
