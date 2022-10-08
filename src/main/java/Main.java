
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    final static String badInput = "This is not a valid value, try again.";

    public static void main(String[] args) {

        // Обработка ввода количества гостей пользователем
        System.out.println("How many persons?");
        int person = getPerson();

        // Обработка ввода названия товара и цены пользователем
        String end;
        do {
            System.out.println("Product name:");
            String product = getText();

            System.out.println("Price in format(10,45):");
            double price = getPrice();

            Calculator.getProductList(product);
            Calculator.getSum(price);

            System.out.println("Enough? (y/n)");
            end = getText();
        } while (!end.equalsIgnoreCase("y"));

        // Вывод результата
        System.out.println("ProductList:" + Calculator.productList);
        double personalBill = Calculator.sum / person;
        String rub = getRub(personalBill);
        System.out.printf(" %.2f %s from each!", personalBill, rub);
    }


    public static int getPerson() {
        int person;
        while (true) {
            if (scan.hasNextInt()) {
                person = scan.nextInt();
                if (person > 1) break; // кол-во гостей не должно быть более 1
                else System.out.println(badInput);
            } else {
                System.out.println(badInput);
                scan.next();
            }
        }
        return person;
    }


    public static String getText() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }


    public static double getPrice() {
        double price;
        while (true) {
            if (scan.hasNextDouble()) {
                price = scan.nextDouble();
                if (price > 0.0) break; // цена не должна быть менее 0.0
                else System.out.println(badInput);
            } else {
                System.out.println(badInput);
                scan.next();
            }
        }
        return price;
    }


    public static String getRub(double personalBill) {
        String rub = "0" + (int)personalBill;
        if (rub.endsWith("1")) {
            if(!rub.substring(0, rub.length() - 1).endsWith("1")) {
                rub = "rubl'";
            } else rub = "rubley";

        } else if (rub.endsWith("2") || rub.endsWith("3") || rub.endsWith("4")) {
            if(!rub.substring(0, rub.length() - 1).endsWith("1")) {
                rub = "rublya";
            } else rub = "rubley";

        } else rub = "rubley";
        return rub;
    }
}




