import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        byte friends;
        String order;
        String table = "";
        float price;
        float total = 0.0f;
        String exit;

        while (true) {
            System.out.println("Введите число участников:");
            Scanner who = new Scanner(System.in);
            if (who.hasNextByte()) {
                friends = who.nextByte();
                if (friends <= 1) {
                    System.out.println("Нет смысла делить счёт. Попробуйте ещё раз.");
                } else {
                    break;
                }
            } else {
                System.out.println("Требуется указать числовое значение!");
            }
        }

        while (true) {
            System.out.println("Введите название блюда:");
            Scanner input = new Scanner(System.in);
            order = input.nextLine();
            table += order + "\n";
            System.out.println("Стоимость в формате 'руб,коп':");
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

        Ending name = new Ending();

        System.out.println("Вы заказали:\n" + table);
        System.out.println("Общая стоимость блюд: " + String.format("%.2f", total) + " " + name.end(total));
        System.out.println("Сумма к оплате каждым участником: " + String.format("%.2f", total/friends) + " " + name.end(total/friends));
    }
}