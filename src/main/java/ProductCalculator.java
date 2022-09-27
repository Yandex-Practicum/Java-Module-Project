import java.util.ArrayList;

public class ProductCalculator {

    private ArrayList<Product> products = new ArrayList<>();
    private double totalSumOfProducts = 0;

    public void addProduct(String name, double price) {
        products.add(new Product(name, price));
        recalculateSum(price);
    }

    private void recalculateSum(double price) {
        totalSumOfProducts += price;
    }

    public double getSumOfProducts() {
        return totalSumOfProducts;
    }

    public ArrayList<Product> getProductsList() {
        return products;
    }

}
