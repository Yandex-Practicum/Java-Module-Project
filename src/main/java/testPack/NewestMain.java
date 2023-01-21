package testPack;

import java.util.Scanner;

public class NewestMain {
    public static void main(String[] args) {
        Product product = new Product();
        String productName;
        double price;
        int sum;

        PeopleNum.getPersonNum();

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Add a product name: ");
            productName = scanner.nextLine();
            product.name += productName + "\n";

            product.finalPrice += Product.getPrice();

            System.out.println(productName + " is successfully added in product list\nAdd another one? Enter any key for continue or enter command STOP to terminate: ");
            // String commandCheck = scanner.next();
            // scanner.next();
        } while(!"stop".equalsIgnoreCase(scanner.next().trim()));
        scanner.close();

        sum = (int) product.finalPrice; //^var for method getRubAddition()

        System.out.println("Your product list is:\n" + product.name + "with check on: " + String.format("%.2f", product.finalPrice) + " "
                + getRubAddition(sum) + "\nand for " + PeopleNum.getPersonNum() + " persons is " + String.format("%.2f", product.finalPrice / PeopleNum.getPersonNum()) +
                " " + getRubAddition(sum / PeopleNum.getPersonNum()) + " per person");
    }
    public static String getRubAddition(int num) { //*DONE

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

class PeopleNum {
    public static int getPersonNum() {
        int personNum = 0;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter the number of people dividing the check (2 and more): ");
            while (!sc.hasNextInt()) {
                System.out.println("Incorrect input. Enter the number of people 2 or more: ");
                sc.next();
            }
            personNum = sc.nextInt();
        } while (personNum <= 0);

        return personNum;
    }
}

class Product { //*DONE
    String name = "";
    double finalPrice = 0.0;

    public static double getPrice() {
        double price;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Add a price of product in formate [10.11, 14.51]: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Incorrect input. Add a price of product in formate [10.11, 14.51]: ");
                sc.next();
            }
            price = sc.nextDouble();
        } while (price <= 0);
        return price;
    }
}