package integration.user;

import integration.ApiBase;

public class Tokens extends ApiBase {
    private String accessToken;
    private String refreshToken;
    private long expiration;

    public Tokens(String accessToken, String refreshToken, long expiration) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiration = expiration;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public long getExpiration() {
        return expiration;
    }

    @Override
    public String toString() {
        return "Tokens{" +
                "accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", expiration=" + expiration +
                '}';
    }
}
