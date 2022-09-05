import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);

    public void calculate(int peopleCount) {
        ArrayList<Order> orders = new ArrayList<>();
        double sum = 0;

        while (true) {
            System.out.println("Введите название товара и сумму, в формате рубли.копейки, " +
                    "для завершения добавления товаров введите \"Завершить\"");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Завершить")) {
                break;
            } else if (input.contains("-")) {
                System.out.println("Отрицательная сумма, введите корректную сумму");
                continue;
            } else {
                String name = input.replaceAll("[\\d.]", "").trim();
                double price = Double.parseDouble(input.replaceAll("[^.\\d]", "").trim());
                orders.add(new Order(name, price));
            }
        }
        System.out.println("Добавленные товары:");
        for (int i = 0; i < orders.size(); i++) {
            sum += orders.get(i).price;
            System.out.println(orders.get(i).name + " " + orders.get(i).price);
        }
        double sumPerCount = sum / peopleCount;
        System.out.println("Каждый человек должен заплатить " + String.format("%.2f", sumPerCount) + " "
                + pluralsCase(sumPerCount));
    }

    private static String pluralsCase(Double sum) {
        int sumCase = sum.intValue();

        if (sumCase % 10 == 1 && sumCase % 100 == 1) {
            return "рубль";
        } else if (sumCase % 10 >= 2 && sumCase % 10 <= 4 &&
                (sumCase % 100 < 10 || sumCase % 100 >= 20)) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
}
