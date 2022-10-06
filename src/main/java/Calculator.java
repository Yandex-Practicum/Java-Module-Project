public class Calculator {

    String productList = "";
    double sum = 0;

    void getSum(double price) {
        sum = sum + price;
    }

    void getProductList(String product) {
        productList = productList + "\n" + product;
    }
}
