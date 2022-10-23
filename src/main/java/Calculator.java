import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    HashMap<String, Double> products = new HashMap<>();
    int persons;
    double sum;
    double payment;
    private Scanner scanner = new Scanner(System.in);

    Calculator (int persons) {
        this.persons = persons;
    }

    void add() {
        while (true) {
            System.out.println("Введите название товара: ");
            String productName = scanner.nextLine();
            System.out.println("Введите стоимость товара в формате: рубли.копейки ");

            double productPrice;
            try {
                productPrice = scanner.nextDouble();
            }
            catch (InputMismatchException e) {
                System.out.println("Введите число");
                scanner.nextLine();
                continue;
            }

            if (productPrice < 0) {
                System.out.println("Введите стоимость больше нуля");
                scanner.nextLine();
            }
            else {
                products.put(productName, productPrice);
                sum += productPrice;
                System.out.println("Товар успешно добавлен!");
                scanner.nextLine();
                System.out.println("Хотите добавить ещё товар? Введите любой символ. Иначе, введите \"Завершить\", чтобы закончить ввод.");
                productName = scanner.nextLine();
                if (productName.equalsIgnoreCase("завершить")) {
                    break;
                }
            }

        }
    }

    void print() {
        payment = sum / persons;
        final String[] rouble = new String[1]; // использовать массив предложила IDE, иначе Variable used in lambda expression should be final or effectively final
        System.out.println("Добавленные товары:");

        products.forEach((name, price) -> {
            rouble[0] = format(price);
            System.out.println(name + " " + price + rouble[0]);
        });
        
        System.out.println("Каждый должен заплатить:");
        rouble[0] = format(payment);
        System.out.println(String.format("%.2f", payment) + rouble[0]);

    }

    String format(double payment) {
        double lastDigit = Math.floor(payment) % 10;
        
        if (lastDigit >= 2 && lastDigit <= 4) {
            return " рубля";
        } else if (lastDigit == 1 && Math.floor(payment) % 100 != 11) {
            return " рубль";
        } else {
            return " рублей";
        }
    }
}

