import java.math.BigDecimal;
import java.util.Scanner;

public class Calculator {

    // строка в которую записываем все добавленные товары
    String products = "Добавленные товары:\n";
    // кол-во добавленных продуктов
    int countProducts;
    // общая сумма всех цен
    double sum;

    // название товара
    String productName;
    // цена товара
    double productPrice;
    // переменная для ввода текста с консоли
    String consoleData;

    // метод запрашивает товары с ценой
    public void addProducts() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.printf("Введите название товара или введите '%s' для выхода:%n", Main.exit_word);
            productName = scanner.next();

            // команда Завершить
            if (productName.equalsIgnoreCase(Main.exit_word)) {
                System.out.println(Main.exit_word);
                break;
            }

            // введено какое-то название продукта
            // название продукта должно содержать хоть какие-нибудь буквы
            if (productName.matches("[А-Яа-яA-Za-z](.*)")) {

                // запрашиваем цену продукта
                while (true) {
                    System.out.println("Введите цену товара в формате 'РУБЛИ.КОПЕЙКИ' например 2.34:");
                    consoleData = scanner.next();

                    // проверяем подходит ли число под формат double
                    if (isDouble(consoleData)) {
                        // преобразуем ввод в double
                        productPrice = Double.parseDouble(consoleData);

                        if (productPrice > 0) {
                            if (BigDecimal.valueOf(productPrice).scale() < 3) {
                                // добавляем продукт в список продуктов
                                products = products + productName + String.format("\t\t\t - %.2f %s\n", productPrice, plural(productPrice));
                                // считаем общую сумму
                                sum = sum + productPrice;
                                // считаем кол-во продуктов
                                countProducts++;
                                // выходим из цикла запроса цены
                                break;
                            } else {
                                System.out.println("Ошибка при вводе копеек, должна быть одна или две цифры после точки");
                            }
                        } else {
                            System.out.println("Ошибка, цена не может быть нулевой или отрицательной");
                        }
                    } else {
                        System.out.println("Ошибка");
                    }
                }

                System.out.printf("Добавлен товар %s, цена %.2f %s%n", productName, productPrice, plural(productPrice));

                System.out.printf("Добавить еще товар? Введите 'да' или любой символ для добавления еще одного товара или введите '%s' для выхода:%n", Main.exit_word);
                consoleData = scanner.next();

                // если введено слово для выхода или достигнуто максимальное кол-во продуктов - выходим
                if (consoleData.equalsIgnoreCase(Main.exit_word) || countProducts > 2147483646) {
                    System.out.println(Main.exit_word);
                    break;
                } // Иначе запускаем цикл добавления продукта заново

            } else {
                System.out.println("Ошибка, название товара, должно содержать буквы");
            }

        }
    }

    // метод считает и выводит результат
    public void printResult(int countPersons) {

        double pay = sum / countPersons;

        System.out.printf("Всего товаров: %s%n", countProducts);
        System.out.println(products);
        System.out.printf("Общая сумма: %.2f %s%n", sum, plural(sum));
        System.out.printf("Кол-во человек: %s%n", countPersons);
        System.out.printf("Каждый платит по: %.2f %s%n", pay, plural(pay));
    }

    // окончания рублей
    private static String plural(double n) {
        n = Math.floor(n);
        if (n == 0) return "";
        n = Math.abs(n) % 100;
        double n1 = (n % 10);
        if (n > 10 && n < 20) return "рублей";
        if (n1 > 1 && n1 < 5) return "рубля";
        if (n1 == 1) return "рубль";
        return "рублей";
    }

    // проверка на преобразование строки в double
    private static boolean isDouble(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
