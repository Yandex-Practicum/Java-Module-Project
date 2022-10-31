import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


        Calculator calculator = new Calculator();
        System.out.println("На скольких человек разделить счет?");
        int scanPerson;

        while (true) {

            if (scanner.hasNextInt()) {
                scanPerson = scanner.nextInt();
                if (scanPerson == 1) {
                    System.out.println("Подсчет не нужен");
                    System.exit(0);
                } else if (scanPerson < 1) {
                    System.out.println("Ошибка. Введите корректное значение.");
                } else break;
            } else {
                System.out.println("Введите корректное значение");
                scanner.nextLine();
            }
        }

        calculator.setCountPerson(scanPerson);
        do {
            Product product = new Product();
            System.out.println("Введите название товара");
            scanner.nextLine();
            product.setNameOfProduct(scanner.nextLine());
            System.out.println("Введите стоимость товара в формате 00,00");
            product.setCost(inputPrice());
            calculator.setBill(product);
            System.out.println("Завершить? Нажмите любой символ, чтобы продолжить");
        } while (!scanner.next().equalsIgnoreCase("Завершить"));
        calculator.calculate();

    }

    static double price = 0.0;
    public static double inputPrice() {
        try {
            price = scanner.nextDouble();
        } catch (InputMismatchException exception) {
            System.out.println("Введите корректное значение");
            scanner.nextLine();
            inputPrice();
        } return price;
    }
}
