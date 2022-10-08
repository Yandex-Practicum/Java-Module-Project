import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int person = 0;
        while (true) {
            System.out.println("На скольких человек будет разделен счет?:");
            if (scanner.hasNextInt()) {
                person = scanner.nextInt();
            } else {
                System.out.println("Количество человек должно быть целым числом");
                scanner.next();
                continue;
            }
            if (person < 1) {
                System.out.println("Количество человек меньше 1. Это некорректное значение для подсчёта.");
            } else if (person == 1) {
                System.out.println("Количество человек равно 1. В этом случае нет смысла ничего считать и делить.");
            } else {
                break;
            }
        }
        Calculator calculator = new Calculator();
        float price = 0;
        String product = "";
        String command = "";
        while (true) {
            System.out.println("Введите стоимость и товар:");
            if (scanner.hasNextFloat()) {
                price = scanner.nextFloat();
            } else {
                System.out.println("Стоимость должна быть числом");
                scanner.next();
                continue;
            }
            product = scanner.next();
            calculator.addItem(price, product);
            System.out.println("Товар добавлен в счет");
            System.out.println("Общаая сумма:" + calculator.sum + "Товары:" + calculator.items);
            System.out.println("Хотите еще добавить тровар? Если нет, то введите команду \"Завершить\"");
            command = scanner.next();
            if (command.equalsIgnoreCase("Завершить")) {
                break;
            }
        }
        System.out.println("Итоговый счет:\n" + calculator.items);
        int list = (int) Math.floor(calculator.sum / (double) person);
        if (list == 1) {
            System.out.println(String.format("Сумма на одного человека:%.2f рубль", calculator.sum / (double) person));
        } else if (2 <= list && list <= 4) {
            System.out.println(String.format("Сумма на одного человека:%.2f рубля", calculator.sum / (double) person));
        } else if (5 <= list && list <= 20) {
            System.out.println(String.format("Сумма на одного человека:%.2f рублей", calculator.sum / (double) person));
        } else {
            int digit = list % 10;
            switch (digit) {
                case 0:
                case 6:
                case 9:
                case 8:
                case 7:
                case 5:
                    System.out.println(String.format("Сумма на одного человека:%.2f рублей", calculator.sum / (double) person));
                    break;
                case 1:
                    System.out.println(String.format("Сумма на одного человека:%.2f рубль", calculator.sum / (double) person));
                    break;
                case 2:
                case 4:
                case 3:
                    System.out.printf("Сумма на одного человека:%.2f рубля%n", calculator.sum / (double) person);
                    break;
            }
        }

    }
}

