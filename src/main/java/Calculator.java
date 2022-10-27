import java.util.Scanner;
import java.util.ArrayList;

public class Calculator {

    int person = 0;
    double total;
    String listProducts;

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
        double price;
        while (true) {
            System.out.println("Введите название товара или \"Завершить\" если список товаров готов:");
            String product = scanner.next();
            if (product.equalsIgnoreCase("Завершить")) {
                break;
            } else {
                products.add(product);
            }
            System.out.println("Введите цену товара в формате Х.ХХ:");
            while (true) {
                try {
                    price = Double.parseDouble(scanner.next());
                    if (price <= 0) {
                        System.out.println("Неверный ввод. Введите цену заново:");
                    } else {
                        total = total + price;
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Неверный ввод. Введите цену заново:");
                }
            }
            System.out.println("Товар " + product + " успешно добавлен!");
        }
        System.out.println("Добавленные товары: " + "\n" + String.join("\n", products));
        System.out.println("Средний чек на человека: " + String.format("%.2f", total / person) + " " + getRightWord((int) (total / person)));
    }


    public String getRightWord(int num) {
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

