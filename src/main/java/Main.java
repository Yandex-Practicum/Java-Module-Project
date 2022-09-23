import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счёт?");
        Scanner scanner = new Scanner(System.in);
        //количество человек
        int numberOfPeople;
        while (true) {
            if (scanner.hasNextInt()) {
                numberOfPeople = scanner.nextInt();
                if (numberOfPeople > 1) {
                    break;
                } else {
                    System.out.println("Ошибка. Введите корректное количество гостей.");
                }
            } else {
                System.out.println("Ошибка. Введите число.");
                scanner.next();
            }
        }

        // создание калькулятора
        Calculator calculator = new Calculator();

        // добавление товара и его стоимости в калькулятор
        while (true) {
            // товар
            System.out.println("Введите название товара:");
            String product = scanner.next();
            // стоимость
            System.out.println("Введите стоимость товара:");
            double price;
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                calculator.setProducts(product);
                calculator.setTotalPrice(price);
                System.out.println("Товар успешно добавлен.");
                System.out.println("Добавить ещё один товар?");
                String addOne = scanner.next();
                if (addOne.equalsIgnoreCase("Завершить")) {
                    break;
                }
            } else {
                System.out.println("Ошибка. Товар не добавлен. Введите корректное значение стоимости товара.");
                scanner.next();
            }
        }

        // вывод результатов
        System.out.print("Добавленные товары:");
        // вывод товаров
        System.out.println(calculator.getProducts());
        // счет каждого посетителя
        double scoreVisitor = calculator.getTotalPrice() / numberOfPeople;
        // склонение в зависимости от целочисленной части счета
        String currency = "";
        if (Math.floor(scoreVisitor) == 1) {
            currency = "рубль";
        } else if (Math.floor(scoreVisitor) > 1 && Math.floor(scoreVisitor) <= 4) {
            currency = "рубля";
        } else if (Math.floor(scoreVisitor) > 4) {
            currency = "рублей";
        }
        // вывод счета
        String formatAnswer = String.format("%.2f %s", scoreVisitor, currency);
        System.out.println(formatAnswer);
    }
}