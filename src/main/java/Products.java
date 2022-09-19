import java.util.Scanner;

public class Products{

    public static String calculateFinalCheck(int personNumber) {
        String productName;
        double price;
        double sum = 0;
        StringBuilder productList = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("Add a product name: ");
            productName = sc.nextLine();
            productList.append(productName).append("\n");
            System.out.print("Add a price of product in formate [10.11, 14.51]: ");
            while (!sc.hasNextDouble()) { //^checking double type, done
                System.out.println("That's not a price!");
                sc.next();
            }
            price = sc.nextDouble();
            while (price <= 0){ //^checking negative nums, done
                System.out.println("Incorrect input, prise must be > 0. Try again");
                price = sc.nextDouble();
            }
            sum += price;
            System.out.println(productName + " is successfully added in product list\n");
            System.out.println("Add another one? Enter any key for continue or enter command STOP to terminate\n");
            sc.nextLine();
            if ("stop".equalsIgnoreCase(sc.nextLine().trim())){
                break;
            }
        }
        sc.close();
        System.out.println("Your product list is:\n" + productList + "with check on: " + sum + "rubles" + "\nand for " +
                personNumber + " persons is " + String.format("%.2f", sum / personNumber) + " rubles");
        return productList.toString();
    }
    public static void main(String[] args) {
        calculateFinalCheck(2);
    }
}