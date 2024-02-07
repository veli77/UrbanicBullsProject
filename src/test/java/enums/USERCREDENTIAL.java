package enums;

public enum USERCREDENTIAL {
    USER1("urbanicfarm2@gmail.com","Urbanicfarm2/"),
    USER2("urbanicfarm2@yopmail.com", "Urbanicfarm2/"),
    USER3("seller_urban@mailsac.com","VHt*zzt*wQNu6XS"),
    USER4("buyer_urban@mailsac.com","VHt*zzt*wQNu6XS");




    private final String getUsername;
    private final String getPassword;

    USERCREDENTIAL(String username, String password) {
        this.getUsername = username;
        this.getPassword=password;
    }
    public String getUsername(){
        return getUsername;

    }

    public String getPassword(){
     return getPassword;
    }


}
