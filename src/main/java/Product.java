public class Product {

    private final String name;
    private final Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Продукт: " + name.toUpperCase() + ", цена: ";
    }
}
