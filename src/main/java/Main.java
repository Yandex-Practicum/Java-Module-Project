import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        Product product = new Product();
        while (true) {
            System.out.println("На скольких человек разделить счет?");
            int scanPerson = scanner.nextInt();

            if (scanPerson == 1) {
                System.out.println("Подсчет не нужен");
                break;
            } else if (scanPerson < 1) {
                System.out.println("Ошибка. Введите корректное значение.");
            } else if (scanPerson > 1) {
                System.out.println("Количество человек: " + scanPerson);
                product.setCountPerson(scanPerson);
                break;
            }

        }

        while (true) {

            System.out.println("Введите название товара");
            product.setNameOfProduct(scanner.next());
            System.out.println("Введите стоимость товара в формате 00,00");
            product.setCost(scanner.nextDouble());
            System.out.println("Все? Да/Нет");
            if (scanner.next().equals("Да")) {
                break;
            }
            calculator.setBill(product);
        }

    calculator.calculate();
    }
}
