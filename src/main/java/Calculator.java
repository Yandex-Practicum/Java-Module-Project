import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    private Scanner scanner = new Scanner(System.in);
    private String dishes = "Добавленные товары:\n ";
    private double summary = 0;

    void addDishes() {
        while (true) {
            System.out.println("Введите название продукта.");
            dishes += scanner.next() + " \n";

            System.out.println("Теперь введите его стоимость в формате [руб.коп.].");

            while (!scanner.hasNextDouble()) {
                scanner.next();
                System.out.println("Ошибка, введите корректное число.");
            }
            while (true) {
                double i = scanner.nextDouble();
                if (i <= 0) {
                    System.out.println("Введите корректную стоимость продукта.");
                } else {
                    summary += i;
                    break;
                }
            }
            System.out.println("Успех! \nХотите ли добавить еще продукт?");

            String answer = scanner.next();
            if (answer.equalsIgnoreCase("завершить")) {
                break;
            }
        }
    }

    void showResult(int guests) {
        double result = summary / guests;
        String rubleTitle = rubleCase(result);
        System.out.println(dishes);
        System.out.println(String.format("%.2f", result) + " " + rubleTitle);
    }

    private String rubleCase(double money) {
        int floorMoney = (int) Math.floor(money);
        int lastDigit = floorMoney % 10;
        if (lastDigit == 1) {
            return "рубль ";
        }
        else if (lastDigit == 2 || lastDigit == 3 || lastDigit == 4) {
            return "рубля";
        }
        else {
            return "рублей ";
        }

    }
}


