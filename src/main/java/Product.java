import java.util.Scanner;

public class Product {
    static String name = "";
    static double cost;

    public static void calculate() {
        System.out.println("Как называется продукт?");
        while (true) {
            Scanner scannerName = new Scanner(System.in);
            String checkName = scannerName.nextLine();
            if (checkName.equalsIgnoreCase(Main.end)) {
                break;
            } else {
                name = name + checkName + "\n";
            }

            System.out.println("Сколько стоил продукт?");
            while (true) {
                Scanner scannerCost = new Scanner(System.in);
                boolean checkCost = scannerCost.hasNextDouble();
                if (checkCost) {
                    double passPeople = scannerCost.nextDouble();
                    if (passPeople > 1) {
                        cost += passPeople;
                        System.out.println("Товар добавлен! Введите название нового товара или напишите \"Завершить\".");
                        break;
                    } else {
                        System.out.println("Ошибка. Введи целое число больше 1:");
                    }
                } else {
                    System.out.println("Ошибка. Введите число;");
                }
            }
        }
    }
}
