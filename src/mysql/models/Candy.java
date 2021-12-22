package mysql.models;

public class Candy {
    private int id;
    private String name;
    private double price;

    public Candy(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Candy() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
