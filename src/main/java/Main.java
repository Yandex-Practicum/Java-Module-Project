import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleNumberBill = 0; // Количество людей в счете
        while (peopleNumberBill <=1) {
            System.out.println("На скольких человек разделить счет?");
            peopleNumberBill = scanner.nextInt();
            if (peopleNumberBill == 1) {
                System.out.println("Количество человек, введённых пользователем равно 1. В этом случае нет смысла ничего считать и делить.");
            } else if (peopleNumberBill < 1) {
                System.out.println("Количество человек меньше 1. Это некорректное значение для подсчёта.");
            }
        }

        Calculator calculator = new Calculator();
        boolean endOrder = false;
        double price;
        String booffer = scanner.nextLine();

        // Проверка на завершение заказа
        while (!endOrder) {
            System.out.println("Что будете заказывать?"); // Ограничений по вводу нет,тк в названии блюда могут быть цифры и буквы.
            String order = scanner.nextLine();

            // Ограничения по вводу для цены блюда
            System.out.println("По какой цене? Введите цену в формате ХХ,YY (где ХХ рубли, а YY копейки).");
            while (true) {
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                    if (price > 0) {
                        break;
                    }
                    else {
                        System.out.println("Значение должно быть больше 0, попробуйте снова.");
                        System.out.println("По какой цене? Введите цену в формате ХХ,YY (где ХХ рубли, а YY копейки).");
                        scanner.nextLine();
                    }
                }
                else {
                    System.out.println("Неверное значение, попробуйте снова.");
                    System.out.println("По какой цене? Введите цену в формате ХХ,YY (где ХХ рубли, а YY копейки).");
                    scanner.nextLine();
                }
            }

            booffer = scanner.nextLine();
            calculator.calculate(order, price);
            System.out.println("Товар успешно добавлен\nЗавершить заказ? (Завершить/Нет)");
            String end = scanner.nextLine();
            endOrder = end.equalsIgnoreCase("Завершить");
        }
        System.out.print("Добавленные товары:");
        calculator.resultsOrder(); // Вывод итогового заказа

        System.out.print("Каждый человек заплатит: ");
        calculator.resultsPrice(peopleNumberBill); // Вывод итоговой суммы на каждого человека
    }
}

