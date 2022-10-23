import java.math.BigDecimal;
import java.util.Scanner;

public class Calculator {

    String exit_word;
    String products = "Добавленные товары:\n";
    String productName, consoleData;
    double sum, productPrice;
    int countProducts;

    // метод запрашивает товары с ценой
    public void addProducts() {

        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println("Введите название товара или введите '"+exit_word+"' для выхода:");
            productName = scanner.next();

            // команда Завершить
            if (productName.equalsIgnoreCase(exit_word)) {
                System.out.println(exit_word);
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
                        productPrice = Double.valueOf(consoleData);

                        if (productPrice > 0) {
                            if (BigDecimal.valueOf(productPrice).scale()<3) {
                                // добавляем продукт в список продуктов
                                products = products + productName + "\t\t - " + String.format("%.2f", productPrice) + " " + plural(productPrice) + "\n";
                                // считаем общую сумму
                                sum = sum + productPrice;
                                // считаем кол-во продуктов
                                countProducts++;
                                // выходим из цикла запроса цены
                                break;
                            } else {
                                System.out.println("Ошибка при вводе копеек, должна быть одна или две цифры после точки.");
                            }
                        } else {
                            System.out.println("Ошибка, цена не может быть отрицательной.");
                        }
                    } else {
                        System.out.println("Ошибка.");
                    }
                }

                System.out.println("Добавлен товар '" + productName + "', цена " + String.format("%.2f", productPrice) + " " + plural(productPrice));

                System.out.println("Добавить еще товар? Введите любой символ для добавления еще одного товара или введите '" + exit_word + "' для выхода.");
                consoleData = scanner.next();

                // если введено слово для выхода или достигнуто максимальное кол-во продуктов - выходим
                if (consoleData.equalsIgnoreCase(exit_word) || countProducts>2147483646) {
                    System.out.println(exit_word);
                    break;
                } // Иначе запускаем цикл добавления продукта заново

            } else {
                System.out.println("Ошибка. Название товара, должно содержать буквы:");
            }

        }
    }

    public void printResult(int countPersons) {
        System.out.println("Всего добавлено товаров: " + countProducts);
        System.out.println(products);
        System.out.println("Общая сумма: " + String.format("%.2f", sum) + " " + plural(sum));
        System.out.println("Общую сумму делим на кол-во человек: " + countPersons);
        double pay = sum / countPersons;
        System.out.println("Каждый платит по: " + String.format("%.2f", pay) + " " + plural(pay));
    }

    private static String plural(double n) {
        n = (int) Math.floor(n);
        if (n==0) return "";
        n = Math.abs(n) % 100;
        int n1 = (int) (n % 10);
        if (n > 10 && n < 20) return "рублей";
        if (n1 > 1 && n1 < 5) return "рубля";
        if (n1 == 1) return "рубль";
        return "рублей";
    }

    private static boolean isDouble(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    Calculator(String exit_word) {
        this.exit_word = exit_word;
    }
}
