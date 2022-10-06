/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/

import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // Обработка ввода количества гостей пользователем
        System.out.println("How many persons?");
        int person = getInt(1); // кол-во гостей (аргумент) не должно быть менее 1

        // Обработка ввода названия товара и цены пользователем
        Calculator calculator = new Calculator();
        String end;
        do {
            System.out.println("Product name:");
            String product = getText();

            System.out.println("Price in format(10,45):");
            double price = getDouble(0.0); // цена (аргумент) не должна быть менее 0.0

            calculator.getProductList(product);
            calculator.getSum(price);

            System.out.println("Enough? (y/n)");
            end = getText();
        } while (!end.equalsIgnoreCase("y"));

        // Вывод результата
        System.out.println("ProductList:" + calculator.productList);
        double personalBill = calculator.sum / person;
        String rub = getRub(personalBill);
        System.out.printf(" %.2f %s from each!", personalBill, rub);
    }


    public static int getInt(int minPerson) {
        int person;
        while (true) {
            if (scan.hasNextInt()) {
                person = scan.nextInt();
                if (person > minPerson) break;
                else System.out.println("This is not a valid value, try again.");
            } else {
                System.out.println("This is not a valid value, try again.");
                scan.next();
            }
        }
        return person;
    }


    public static String getText() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }


    public static double getDouble(double minPrice) {
        double price;
        while (true) {
            if (scan.hasNextDouble()) {
                price = scan.nextDouble();
                if (price > minPrice) break;
                else System.out.println("This is not a valid value of price, try again.");
            } else {
                System.out.println("This is not a valid value of price, try again.");
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




