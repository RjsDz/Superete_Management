package supermarketproject;

/**
 *
 * @author Rjs
 */
public class Products {
    private int id;
    private String product_name;
    private String code_bar;
    private float price;

    public Products() {
    }
    
    

    public Products(int id, String product_name, String code_bar, float price) {
        this.id = id;
        this.product_name = product_name;
        this.code_bar = code_bar;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getCode_bar() {
        return code_bar;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setCode_bar(String code_bar) {
        this.code_bar = code_bar;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
