import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Product product = new Product();

        String productName;
        double price;
        int sum;
        int personNum = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of people dividing the check (2 and more): ");

        while (scanner.hasNext()) {
            personNum = scanner.nextInt();
            if (personNum < 2) {
                System.out.print("Incorrect input. Enter the number of people 2 or more: ");
            } else {
                break;
            }
        }

        do {
            System.out.print("Add a product name: ");
            scanner.nextLine();
            productName = scanner.nextLine();
            product.name += productName + "\n";
            System.out.print("Add a price of product in formate [10.11, 14.51]: ");

            while (!scanner.hasNextDouble()) { //^checking double type, done
                System.out.println("That's not a price!");
                scanner.next();
            }

            price = scanner.nextDouble();

            while (price <= 0) { //^checking negative nums, done
                System.out.println("Incorrect input, prise must be > 0. Try again");
                price = scanner.nextDouble();
            }

            product.finalPrice += price;

            System.out.println(productName + " is successfully added in product list");
            System.out.println("Add another one? Enter any key for continue or enter command STOP to terminate: ");
            scanner.nextLine();
        } while (!"stop".equalsIgnoreCase(scanner.next().trim()));
        scanner.close();

        sum = (int) product.finalPrice; //^var for method getRubAddition()

        System.out.println("Your product list is:\n" + product.name + "with check on: " + String.format("%.2f", product.finalPrice) + " "
                + getRubAddition(sum) + "\nand for " + personNum + " persons is " + String.format("%.2f", product.finalPrice / personNum) + " " + getRubAddition(sum / personNum) + " per person");

    }
    public static String getRubAddition(int num) {

        int preLastDigit = num % 100 / 10;

        if (preLastDigit == 1) {
            return "рублей";
        }

        switch (num % 10) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }

    }
}

class Product { //^Calcualter class
    String name = "";
    double finalPrice = 0.0;
}