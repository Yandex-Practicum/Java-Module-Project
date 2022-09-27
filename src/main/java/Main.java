import java.lang.NumberFormatException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static String getRoubleWordWithCorrectEnding(int number) {
        if (number % 100 > 9 && number % 100 < 20) {
            return "рублей";
        }
        switch (number % 10) {
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

    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счет?");

        String amountOfUsersAsString;
        int amountOfUsers;

        while (true) {
            amountOfUsersAsString = scanner.next();
            try {
                amountOfUsers = Integer.parseInt(amountOfUsersAsString);
                if (amountOfUsers > 1) {
                    break;
                }
                System.out.println("UserLimitException: должно быть как минимум два человека, чтобы разделить счет!");
            } catch (NumberFormatException exception) {
                System.out.println("InputException: введена строка в качестве количества человек! Ожидалось целое число.");
            }
        }

        ProductCalculator calculator = new ProductCalculator();

        double productPrice;
        String productPriceAsString;
        String productName;

        System.out.println("Введите товар и его стоимость через пробел:");
        while (!(productName = scanner.next()).equalsIgnoreCase("завершить")) {
            productPriceAsString = scanner.next();
            try {
                productPrice = Double.parseDouble(productPriceAsString);
                calculator.addProduct(productName, productPrice);
                System.out.println("Товар был успешно добавлен! Хотите добавить еще?");
                System.out.println("Если да, то введите название товара и цену, иначе напишите слово \"завершить\":");
            } catch (NumberFormatException exception) {
                System.out.println("InputException: введена строка в качестве цены товара! Ожидалось вещественное число.");
                System.out.println("Товар не был добавлен! Повторите корректный ввод заново.");
            }
        }

        System.out.println("Добавленные товары:");
        for (Product product : calculator.getProductsList()) {
            System.out.println(product.getProductName());
        }

        double sumForEachToPay = calculator.getSumOfProducts() / amountOfUsers;
        System.out.printf("Сумма, которую должен заплатить каждый: %.2f %s%n", sumForEachToPay, getRoubleWordWithCorrectEnding((int) sumForEachToPay));

    }
}
