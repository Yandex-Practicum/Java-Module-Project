import java.util.Scanner;

public class Item {

    static String name;
    static double price;

    static String values = "";
    static double sum = 0;

    Item (double price, String name) {
        this.price = price;
        this.name = name;
    }

    static void calculate() {
        while (true) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Если вы хотите добавить блюдо, введите наименование блюда");
            System.out.println("Если вы не хотите добавлять блюдо, введите Завершить");

            name = scanner.nextLine();

            if (name.equalsIgnoreCase("завершить")) {
                System.out.println("Выход из калькулятора");
                break;
            } else {
                System.out.println("Введите цену");
                price = scanner.nextDouble();

                values += name + " " + price + "\n";
                sum += price;

                System.out.println("Блюдо " + name + " стоимостью " + price + " рублей успешно добавлено!");
            }
        }
        System.out.println("Добавленные товары:");
        System.out.println(values);
        System.out.println("Общая сумма: " + sum + " рублей");
    }
}
