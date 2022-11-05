import java.util.Scanner;

public class Item {

    static String name;
    static double price = 0;

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
                System.out.println("Введите стоимость блюда в формате [рубли.копейки]:");

                String stringPrice = scanner.nextLine();

                try {
                    price = Double.parseDouble(stringPrice);
                } catch (NumberFormatException e) {
                    System.out.println("Введите численное значение.");
                    price = 0;
                }

                if (price > 0) {
                    values += name + " " + price + ";\n";
                    sum += price;

                    System.out.println("Блюдо " + name + " стоимостью " + price + CaseEnding.setEnding(price) + " успешно добавлено!");
                    System.out.println("Текущая сумма блюд: " + sum + CaseEnding.setEnding(sum) + ".");
                } else {
                    System.out.println("Введите корректную стоимость блюда больше нуля.");

                }
            }
        }

        System.out.println("\nДобавленные блюда: ");
        System.out.println(values);
        System.out.println("Общая сумма блюд: " + sum + CaseEnding.setEnding(sum) + ".");
    }
}
