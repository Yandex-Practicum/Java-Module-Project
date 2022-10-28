import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


        Calculator calculator = new Calculator();
        System.out.println("На скольких человек разделить счет?");
        int scanPerson;


        while (true) {
            scanPerson = scanner.nextInt();
            if (scanPerson == 1) {
                System.out.println("Подсчет не нужен");
                System.exit(0);
            } else if (scanPerson < 1) {
                System.out.println("Ошибка. Введите корректное значение.");
            } else break;
        }

        calculator.setCountPerson(scanPerson);
        do {
            Product product = new Product();
            System.out.println("Введите название товара");
            scanner.nextLine();
            product.setNameOfProduct(scanner.nextLine());
            System.out.println("Введите стоимость товара в формате 00,00");
            product.setCost(scanner.nextDouble());
            calculator.setBill(product);
            System.out.println("Завершить? Нажмите любой символ, чтобы продолжить");
        } while (!scanner.next().equalsIgnoreCase("Завершить"));
        calculator.calculate();

    }
}
