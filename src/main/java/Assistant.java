import java.util.Scanner;

public class Assistant {
    static Scanner scanner = new Scanner(System.in);
    static int numberOfPeople;

    // подсчет количество человек
    public void calculatePersons() {
        System.out.println("На скольких человек необходимо разделить счёт?");
        //количество человек
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
    }

    // добавление товара и его стоимости в калькулятор
    public void addProduct(Calculator calculator) {
        while (true) {
            // товар
            System.out.println("Введите название товара:");
            String product = scanner.next();
            // стоимость
            System.out.println("Введите стоимость товара:");
            double price;
            String addOne = "";
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                if (price > 0) {
                    calculator.setProducts(product);
                    calculator.setTotalPrice(price);
                    System.out.println("Товар успешно добавлен.\nДобавить ещё один товар?\nЕсли все товары добавлены введите - Завершить.");
                    addOne = scanner.next();
                } else {
                    System.out.println("Ошибка.Введите положительное значение.");
                }
                if (addOne.equalsIgnoreCase("Завершить")) {
                    break;
                }
            } else {
                System.out.println("Ошибка. Товар не добавлен. Введите корректное значение стоимости товара.");
                scanner.next();
            }
        }
    }

    // вывод результатов
    public void outputResult(Calculator calculator) {
        System.out.print("Добавленные товары:");
        // вывод товаров
        System.out.println(calculator.getProducts());
        // счет каждого посетителя
        double scoreVisitor = calculator.getTotalPrice() / Assistant.numberOfPeople;
        // склонение в зависимости от целочисленной части счета
        String currency = "";
        // округление значения
        int roundScore = (int) Math.floor(scoreVisitor);
        if (roundScore == 1 || (roundScore % 10 == 1 && (roundScore / 10) % 2 == 0)) {
            currency = "рубль";
        } else if ((roundScore > 1 && roundScore <= 4) || ((roundScore % 10 > 1 && roundScore % 10 <= 4) && (roundScore / 10) % 2 == 0)) {
            currency = "рубля";
        } else if (roundScore > 4) {
            currency = "рублей";
        }
        // вывод счета клиента
        String formatAnswer = String.format("%.2f %s", scoreVisitor, currency);
        System.out.println(formatAnswer);
    }
}
