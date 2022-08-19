import static java.lang.Math.floor;
import java.util.Scanner;

public class Main {

    final static String exitAppCommand = "Завершить";
    final static String nounOne = "рубль";
    final static String nounTwo = "рубля";
    final static String nounThree = "рублей";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountPeople;
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("Введите количество человек, на которое необходимо разделить счёт:");
            String input = scanner.next();
            try {
                amountPeople = Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Неверный формат ввода, введите целое число.");
                continue;
            }
            if (amountPeople > 1)
                break;
            System.out.println("Количество человек для разделения счёта не может быть меньше 2, попробуйте ещё раз.");
        }

        while (true) {
            System.out.println("\nВведите название товара:");
            String productName = scanner.next();

            double productPrice;
            while (true) {
                System.out.println("Введите цену товара в формате 'рубли.копейки' (10.45):");
                String price = scanner.next();
                try {
                    productPrice = Double.parseDouble(price);
                } catch (NumberFormatException exception) {
                    System.out.println("Неверный формат ввода, введите дробное число.");
                    continue;
                }
                if(productPrice > 0)
                    break;
                System.out.println("Стоимость товара не может быть отрицательной или равной нулю.");
            }

            calculator.addProduct(new Product(productName, productPrice));
            System.out.println("Товар был успешно добавлен!");
            System.out.println("Хотите добавить ещё товар? Если да - введите любой символ, если нет - введите команду 'Завершить'");
            String input = scanner.next();
            if (input.equalsIgnoreCase(exitAppCommand))
                break;
        }

        calculator.printProductList();

        double priceEachPersonPays = calculator.getTotalPrice() / amountPeople;
        System.out.println("\n" + "Каждый человек должен заплатить " + String.format("%.2f", priceEachPersonPays) + " " + getCorrectNoun(priceEachPersonPays));
    }

    private static String getCorrectNoun(double number) {
        double roundedNum = floor(number);
        roundedNum %= 100;
        if (roundedNum >= 5 && roundedNum <= 20) {
            return nounThree;
        }
        roundedNum %= 10;
        if (roundedNum == 1) {
            return nounOne;
        }
        if (roundedNum >= 2 && roundedNum <= 4) {
            return nounTwo;
        }
        return nounThree;
    }
}
