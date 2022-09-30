import static com.sun.tools.doclint.Entity.sum;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int person = 0;
        while (true) {
            System.out.println("На скольких человек будет разделен счет?:");
            person = scanner.nextInt();
            if (person < 1) {
                System.out.println("Количество человек меньше 1. Это некорректное значение для подсчёта.");
            } else if (person == 1) {
                System.out.println("Количество человек равно 1. В этом случае нет смысла ничего считать и делить.");
            } else if (person > 1) {
                break;
            }
        }
        Calculator calculator = new Calculator();
        float price = 0;
        String product = "";
        String command = "";
        while (true) {
            System.out.println("Введите стоимость и товар:");
            price = scanner.nextFloat();
            product = scanner.next();
            calculator.addItem(price, product);
            System.out.println("Товар добавлен в счет");
            System.out.println("Общаая сумма:" + calculator.sum + "Товары:" + calculator.items);
            System.out.println("Хотите еще добавить тровар? Введите: Да ");
            command = scanner.next();
            if (command.equalsIgnoreCase("Завершить")) {
                break;
            }
        }
        System.out.println("Итоговый счет:\n" + calculator.items);
        double list = Math.floor(calculator.sum / (double) person);
        if (list >= 2) {
            System.out.println(String.format("Сумма на одного человека:%.2f рубля", list));
        } else {
            System.out.println(String.format("Сумма на одного человека:%.2f рубль", list));
        }
    }
}

