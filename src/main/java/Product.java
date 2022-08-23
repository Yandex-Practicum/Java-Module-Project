import java.lang.Math;

public class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void printProduct() {
        System.out.println(name + " - " + String.format("%.2f",price) + Helpers.getRuble(price));
    }
}
