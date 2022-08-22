public class Product {
    private String name;
    private double price;
    private final int PRICE_PRECISION = 2;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getLengthNameAndPrice() {
        // возвращаем длину строки <имя+число>
        return Double.toString(this.price).indexOf('.') + name.length() + PRICE_PRECISION;
    }

}
