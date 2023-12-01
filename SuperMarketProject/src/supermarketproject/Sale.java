
package supermarketproject;

/**
 *
 * @author ANIS RJS
 */
public class Sale {
    private int id;
    private String username;
    private String product;
    private String codeBar;
    private float price;
    private float sum;
    private float qte;
    private String date;
    private String time;

    public Sale() {
    }

    public Sale(String product, String codeBar, float price, float qte) {
        this.product = product;
        this.codeBar = codeBar;
        this.price = price;
        this.qte = qte;
        this.sum = this.qte * this.price;
    }

    public Sale(int id, String username, String product, String codeBar, float price, float sum, float qte, String date, String time) {
        this.id = id;
        this.username = username;
        this.product = product;
        this.codeBar = codeBar;
        this.price = price;
        this.sum = sum;
        this.qte = qte;
        this.date = date;
        this.time = time;
    }

    public Sale(String username) {
        this.username = username;
    }
    
    

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getProduct() {
        return product;
    }

    public String getCodeBar() {
        return codeBar;
    }

    public float getPrice() {
        return price;
    }



    public float getSum() {
        return sum;
    }

    public float getQte() {
        return qte;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setCodeBar(String codeBar) {
        this.codeBar = codeBar;
    }

    public void setPrice(float price) {
        this.price = price;
        this.sum = this.qte * this.price;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public void setQte(float qte) {
        this.qte = qte;
        this.sum = this.qte * this.price;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
}
