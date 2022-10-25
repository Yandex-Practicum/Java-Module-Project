import java.util.Scanner;
import java.util.ArrayList;

public class Calculator {
    int person = 0;
    double total;

    public void addPersons() {
        int a;
        System.out.println("На скольких человек необходимо разделить счёт?");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибочка! Введите целое число больше единицы");
                scanner.next();
                continue;
            } else {
                a = scanner.nextInt();
            }
            if (a > 1) {
                break;
            } else {
                System.out.println("Ошибочка! Введите целое число больше единицы");
            }
        }
        person = a;
    }

    public void addProducts() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();
        while (true) {
            System.out.println("Отлично! Введите товар или напишите 'завершить'");
            String s = scanner.next();
            if (s.equalsIgnoreCase("завершить")) {
                break;
            } else {
                System.out.println("Введите цену товара в формате РУБЛИ.КОПЕЙКИ Например: '[10.45]'");
                double d = scanner.nextDouble();
                products.add(s);
                while (d <= 0) {
                    System.out.println("Ошибка! Введите корректное значение.");
                    d = scanner.nextDouble();
                }
                total = total + d;
                String s2 = "Товар " + s + " успешно добавлен!" + " " + "Стоимостью " + String.format("%.2f", d);
                System.out.println(s2);
            }
        }
        System.out.println("Добавленные товары: " + "\n" + String.join("\n", products));
        System.out.println("Средний чек на человека: " + String.format("%.2f", total / person) + " " + getRightWord(total / person));
    }

    public static String getRightWord(double coin) {
        coin = (int) Math.floor(coin);
        if (coin == 0) return "";
        coin = Math.abs(coin) % 100;
        int n1 = (int) (coin % 10);
        if (coin > 10 && coin < 20) return "рублей";
        if (n1 > 1 && n1 < 5) return "рубля";
        if (n1 == 1) return "рубль";
        return "рублей";
    }
}
