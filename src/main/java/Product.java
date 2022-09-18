import java.util.Scanner;

public class Product{

    public static String calculateFinalCheck(int personNumber) {
        String productName;
        double price;
        double finalSum = 0;
        String commandStop = "stop";
        String productList = null;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter the name of product");
            productName = sc.next();
            if (commandStop.equalsIgnoreCase(productName.trim())){
                break;
            } else {
                System.out.println("Enter price of product");
                price = sc.nextDouble();
                System.out.println("The product " + productName + " successfully added. ");
            } productList += productName + " " + price + " rub\n";
            finalSum += price;
            System.out.println("Enter any value to continue filling the product list or enter the STOP command to terminate");
            productName = sc.next();
        } while(sc.hasNext());
        sc.close();
        System.out.println(productList + " " + finalSum / personNumber);
        return productList;
    }
    public static void main(String[] args) {
        calculateFinalCheck(2);
    }
}
