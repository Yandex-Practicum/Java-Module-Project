
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // шаг 1: запрашиваем количество участников
        int numberOfFriends;

        while (true) {
            System.out.println("На сколько человек вы хотели бы разделить счет?");
            // проверяем наличие целого числа в вводе
            if (!scanner.hasNextInt()) { // если нет целое число, то просим ввести еще раз
                System.out.println("Введите целое число: пожалуйста.");
                scanner.next();
                continue;
            }
            else {
                numberOfFriends = scanner.nextInt();
            }

            // проверяем количество человек
            if (numberOfFriends > 1) {
                break;
            } else {
                System.out.println("Вас слишком мало, чтобы делить счет :)");
            }

        }

            // шаг 2. добавление товаров и подсчет товаров
            Calculator calculator = new Calculator();
            while (true) {
                System.out.println("Введите название товара");
                scanner.nextLine();
                String name = scanner.nextLine();

                System.out.println("Введите цену");
                double price;

                // проверяем, что цена введена корректно
                if (!scanner.hasNextDouble()) {
                    System.out.println("Ошибка в цене товара. Попробуйте снова.");
                    continue;
                }
                else {
                    price = scanner.nextDouble();
                }

                if (price > 0) {
                    calculator.addGood(name, price); // добавляем товар
                    System.out.println("Товар успешно добавлен. Если хотите завершить ввод, напишите - завершить.");
                    String exit = scanner.next();
                    if (exit.equalsIgnoreCase("завершить")) {
                        break;
                    }
                } else {
                    System.out.println("Вы ввели отрицательную цену. Попробуйте еще раз ввести товар.");
                }
            }

            // шаг 3. вывод результата
            System.out.println("Добавленные товары:");
            System.out.println(calculator.getReceipt());
           System.out.println("Сумма к оплате: " + String.format("%.2f",calculator.getSumma()));

            // определяем окончание слова рубль
            double finalAmount = calculator.getSumma() / numberOfFriends;
            String formattedDouble = String.format("%.2f", finalAmount);
            String rubles = calculator.getRubleAddition((int) Math.floor(finalAmount));

            System.out.println("Каждый должен заплатить =  " + formattedDouble + " " + rubles);

    }
}


