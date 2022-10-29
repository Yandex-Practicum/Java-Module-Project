/**
 * Калькулятор счёта
 * @author Fandorina Polina
 * В данной задаче не вызываются несколько методов многократно,
 * поэтому нет смысла загружать JVM и создавать лишиние классы и функции,
 * хотя разделить на логические блоки можно. Программа линейная, где каждая операция выполняется последовательно.
 */

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Здравствуйте!\nНа скольких гостей разделить счет?");
        int count;
        String allProducts = "";
        double totalPrice = 0f;
        double productPrice;
        String rubles = "";
        double OnePersonSum = 0.00f;


        while (true) {
            count = scanner.nextInt();

            if (count > 1) {
                break;
            }
            if (count == 1) {
                System.out.println("Разделение счета рассчитывается на большее кол-во гостей. Пожалуйста, введите число заново.");
            } else {
                System.out.println("Неверное кол-во гостей. Пожалуйста, введите число заново.");
            }
        }

        // Добавление товаров в калькулятор

        while (true) {
            System.out.println("Введите название товара или введите команду \"Завершить\".");
            String productName = scanner.next();
            if (productName.equalsIgnoreCase("finish")) {
                System.out.println("Добавленные товары: " + "\n" + allProducts);
                break;
            } else {
                allProducts = allProducts + productName + "\n";
                while (true) {
                    System.out.println("Введите стоимость товара в формате \"рубли,копейки\".");
                    productPrice = scanner.nextDouble();
                    if (productPrice <= 0) {
                        System.out.println("Некорректное значение.");
                    } else {
                        break;
                    }
                }
                totalPrice = totalPrice + productPrice;
                System.out.println("Товар добавлен в чек.");
            }

        }


        //Подсчет рублей для каждого гостя
        int lastNum = (int) totalPrice % 10;

        switch (lastNum) {
            case 1:
                rubles = "рубль";
            case 2 | 3 | 4:
                rubles = "рубля";
            default:
                rubles = "рублей";
        }

        OnePersonSum = totalPrice / (double)count;

        System.out.println("Сумма на каждого гостя составляет " + String.format("%.2f", OnePersonSum) + " " + rubles + ".\nВсего доброго!");

    }
}

