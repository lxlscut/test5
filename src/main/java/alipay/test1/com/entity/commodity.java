package alipay.test1.com.entity;

public class commodity {
    private  int id;
    private float price;

    public commodity(int id, float price) {
        this.id = id;
        this.price = price;
    }

    public commodity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "commodity{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
