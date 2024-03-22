package pojo;

public class PPromoCode {

    private int id,number_of_users,discount;
    private String code,starts_at,ends_at,discount_type;

    public PPromoCode(int id, String code, String starts_at, String ends_at, int number_of_users, int discount, String discount_type) {
        this.id = id;
        this.number_of_users = number_of_users;
        this.discount = discount;
        this.code = code;
        this.starts_at = starts_at;
        this.ends_at = ends_at;
        this.discount_type = discount_type;
    }

    public int getId() {
        return id;
    }

    public int getNumber_of_users() {
        return number_of_users;
    }

    public int getDiscount() {
        return discount;
    }

    public String getCode() {
        return code;
    }

    public String getStarts_at() {
        return starts_at;
    }

    public String getEnds_at() {
        return ends_at;
    }

    public String getDiscount_type() {
        return discount_type;
    }
}
