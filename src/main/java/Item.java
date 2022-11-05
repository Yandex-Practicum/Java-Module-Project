import java.util.Scanner;

public class Item {

    static String name;
    static double price;

    static String values = "";
    static double sum = 0;

    static void calculate() {
        while (true) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("\nЕсли вы хотите добавить блюдо в калькулятор, введите наименование блюда:");
            System.out.println("Если вы не хотите добавлять блюдо в калькулятор, введите «Завершить»:");

            name = scanner.nextLine();

            if (name.equalsIgnoreCase("завершить")) {
                System.out.println("Выход из калькулятора (вы ввели «Завершить»).");
                break;
            } else {
                System.out.println("Введите цену блюда:");

                price = scanner.nextDouble();

                values += name + " " + price + ";\n";
                sum += price;

                System.out.println("Блюдо " + name + " стоимостью " + price + CaseEnding.setEnding(price) + " успешно добавлено!");
                System.out.println("Текущая сумма блюд: " + sum + CaseEnding.setEnding(sum) + ".");
            }
        }

        System.out.println("\nДобавленные блюда: ");
        System.out.println(values);
        System.out.println("Общая сумма блюд: " + sum + CaseEnding.setEnding(sum) + ".");
    }
}
