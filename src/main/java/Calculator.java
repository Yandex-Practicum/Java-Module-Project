public class Calculator {

    static String productList = "";
    static double sum = 0;
    static int count = 0;

    static void getSum(double price) {
        sum = sum + price;
    }

    static void getProductList(String product) {
        count++;
        productList = productList + "\n" + count + ". " + product;
    }
}
