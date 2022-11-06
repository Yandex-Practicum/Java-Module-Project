package calculator;

class Product {
    private final String title;
    private final double price;

    public Product(String title, double price) {
        this.title = title;
        this.price = price;
    }

    String getTitle() {
        return title;
    }

    double getPrice() {
        return price;
    }
}
