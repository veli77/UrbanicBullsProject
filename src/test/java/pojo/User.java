package pojo;

public class User {

    private int allow_anonymous_chat,browser_notifications,is_verified;
    private String email,first_name,password;
    private Object delivery_type,roles;

    public User(int allow_anonymous_chat, int browser_notifications, int is_verified, Object delivery_type, String email, String first_name, String password, Object roles) {
        this.allow_anonymous_chat = allow_anonymous_chat;
        this.browser_notifications = browser_notifications;
        this.is_verified = is_verified;
        this.delivery_type = delivery_type;
        this.email = email;
        this.first_name = first_name;
        this.password = password;
        this.roles = roles;
    }

    public int getAllow_anonymous_chat() {
        return allow_anonymous_chat;
    }

    public int getBrowser_notifications() {
        return browser_notifications;
    }

    public int getIs_verified() {
        return is_verified;
    }

    public Object getDelivery_type() {
        return delivery_type;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getPassword() {
        return password;
    }

    public Object getRoles() {
        return roles;
    }



}
