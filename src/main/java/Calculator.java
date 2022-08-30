import java.util.Scanner;
import java.util.Locale;
public class Calculator {
        Scanner scanner = new Scanner(System.in);
        String productList = ("Добавленные товары:");
        double cost = 0;
        boolean rightness = false;
    public void counting() {
        while (!rightness) {
            System.out.println("Для завершения списка введите: Завершить" + '\n' + "Введите название продукта");
            String product;
            product = scanner.next();
            if (product.equalsIgnoreCase("Завершить")) {
                rightness = true;
            } else {
                while (true) {
                    System.out.println("Введите стоимость продукта в формате 'рубли.копейки' [10.45, 11.40]");
                    if (scanner.hasNextDouble()) {
                        double price = scanner.nextDouble();
                        if (price <= 0.0) {
                            System.out.println("Некорректное значение");
                        } else {
                            cost = cost + price;
                            String worth = String.format(Locale.US,"%.2f", price);
                            productList = productList + '\n' + product + " " + worth;
                            String list = String.format("Продукт " + product + " %.2f успешно добавлен", price);
                            System.out.println(list);
                            break;
                        }
                    } else {
                        System.out.println("Некорректное значение");
                        scanner.next();
                    }
                }
            }
        }
    }
}