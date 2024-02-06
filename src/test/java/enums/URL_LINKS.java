package enums;

public enum URL_LINKS {
    HOMEPAGE("https://test.urbanicfarm.com/"),


    LOGIN_URL("https://test.urbanicfarm.com/auth/login");



    private final String getLink;

  URL_LINKS(String getLink) {
        this.getLink = getLink;
    }

    public String getLink() {

        return getLink;
    }

}
