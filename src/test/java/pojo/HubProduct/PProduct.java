package pojo.HubProduct;

public class PProduct {

    private int id, is_active,is_organic,is_trade,stock;
    private String unique_name,unit;

    public PProduct(int id,int is_active, int is_organic, int is_trade, int stock, String unique_name, String unit) {
        this.id = id;
        this.is_active = is_active;
        this.is_organic = is_organic;
        this.is_trade = is_trade;
        this.stock = stock;
        this.unique_name = unique_name;
        this.unit = unit;
    }

    public int getIs_active() {
        return is_active;
    }

    public int getIs_organic() {
        return is_organic;
    }

    public int getIs_trade() {
        return is_trade;
    }

    public int getStock() {
        return stock;
    }

    public String getUnique_name() {
        return unique_name;
    }

    public String getUnit() {
        return unit;
    }
    public int getId() {
        return id;
    }
}
