import java.util.Scanner;

public final class Dishes {

    String order;
    String table = "";
    float price;
    float total = 0.0f;
    String exit;

    Scanner input = new Scanner(System.in);

    while (true) {
        System.out.println("Введите название блюда:");
        order = input.nextLine();
        table += order + "\n";
        System.out.println("Стоимость в формате 'руб.коп':");

        if (input.hasNextFloat()) {
            price = input.nextFloat();
            total += price;
            System.out.println("Товар успешно добавлен!\nПродолжить? Да/Нет");
            exit = input.next();
            if (exit.equalsIgnoreCase("Нет")) {
                break;
            }
        } else {
            System.out.println("Неверно указана сумма, попробуйте снова.");
        }
    }
}