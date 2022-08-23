import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        int personsNumber = 0;
        while (personsNumber < 2) {               // Ввод количества человек для разделения счета
            System.out.println("На скольких человек необходимо разделить счет?");
            if (scanner.hasNextInt()) {
                personsNumber = scanner.nextInt();
                if (personsNumber < 2) {
                    System.out.println("Количество человек для разделения счета должно быть больше 1.");
                }
            }
            else {
                scanner.next();
                System.out.println("Ошибка ввода! Введите целое число.");
            }
        }
        BillCalculator billCalculator = new BillCalculator(personsNumber);
        while (true) {                           // Цикл ввода товаров
            System.out.println("Введите название товара:");
            String name = scanner.next();
            while (true) {                       // Цикл ввода цены товара с проверкой на валидность
                System.out.println("Введите стоимость товара в формате \"рубли.копейки\":");
                if (scanner.hasNextDouble()) {
                    double price = scanner.nextDouble();
                    if (price < 0) {
                        System.out.println("Цена должна быть неотрицательной.");
                    } else {
                        billCalculator.addProduct(name, price);
                        System.out.println("Товар успешно добавлен!");
                        break;
                    }
                } else {
                    scanner.next();
                    System.out.println("Ошибка ввода! Введите стоимость товара в правильном формате.");
                }
            }
            System.out.println("Хотите добавить еще один товар? Введите \"завершить\" для завершения ввода.");
            String close = scanner.next();
            if (close.equalsIgnoreCase("завершить")) {
                break;
            }
        }
        billCalculator.printProducts();
        double amount = billCalculator.calculateBill();
        System.out.println("Сумма, которую должен заплатить каждый: " + String.format("%.2f", amount) + Helpers.getRuble(amount));
    }
}
