import java.util.ArrayList;
import java.util.Scanner;

public class InputProducts {

    private final Scanner scanner;

    public InputProducts(Scanner scanner) {
        this.scanner = scanner;
    }

    public ArrayList<Product> productArrayList() {
        ArrayList<Product> products = new ArrayList<>();
        while (true) {
            System.out.println("Введите название товара:");
            String productName = scanner.next();

            System.out.println("Введите стоимость товара в формате 'рубли.копейки':");
            double productPrice;
            while (true) {
                if (scanner.hasNextDouble()) {
                    productPrice = Math.floor(scanner.nextDouble() * 100) / 100.0;
                    if (productPrice >= 0.01) {
                        break;
                    }
                }
                System.out.println("Стоимость товара должно быть в формате 'рубли.копейки'. Повторите попытку:");
                scanner.nextLine();
            }
            products.add(new Product(productName, productPrice));
            System.out.println("Товар успешно добавлен!");
            System.out.println("Добавить ещё один товар?");
            String answer = scanner.next();
            if ("Завершить".equalsIgnoreCase(answer)) {
                break;
            } else {
                scanner.nextLine();
            }
        }
        return products;
    }
}
