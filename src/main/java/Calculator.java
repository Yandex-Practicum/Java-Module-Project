import java.util.ArrayList;

public class Calculator {

    private double totalPrice = 0.0;
    private final ArrayList<Product> productList;

    public double getTotalPrice() {
        return totalPrice;
    }

    public Calculator() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
        calculateCurrentPrice();
    }
    private void calculateCurrentPrice(){
        totalPrice += productList.get(productList.size() - 1).getPrice();
    }

    public void printProductList(){
        System.out.println("\nДобавленные товары:");
        for (Product product : productList) {
            System.out.println(product.getName());
        }
    }
}