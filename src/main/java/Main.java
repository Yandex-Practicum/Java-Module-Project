import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            Product product = new Product();
            System.out.println("На скольких человек разделить счет?");
            int scanPerson = scanner.nextInt();

            if (scanPerson == 1) {
                System.out.println("Подсчет не нужен");
                System.exit(0);
            } else if (scanPerson < 1) {
                System.out.println("Ошибка. Введите корректное значение.");
            } else if (scanPerson > 1) {
                product.setCountPerson(scanPerson);
                System.out.println("Количество человек: " + scanPerson);

            }
            while (true) {

                System.out.println("Введите название товара");
                product.setNameOfProduct(scanner.next());
                System.out.println("Введите стоимость товара в формате 00,00");
                product.setCost(scanner.nextDouble());
                calculator.setBill(product);
                System.out.println("Завершить? Нажмите любой символ, чтобы продолжить");
                if (scanner.next().equalsIgnoreCase("Завершить")) {
                    break;
                }

            }
            calculator.calculate();
            System.exit(0);

        }
    }
}
