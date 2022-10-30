import java.util.Locale;
import java.util.Scanner;

public class Menu {

    String itemsToPrint = "Добавленные товары: \n";
    double totalPrice = 0;

    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    //fun to add items to menu with some incorrect input catching
    void addMenuItems(){

        while (true) {
            System.out.println("Введите название блюда");
            String temporaryName = scanner.next();
            System.out.println("Введите стоимость блюда, с точностью до копеек, например: 10.22 ");
            double temporaryPrice;
            while (true) {
                scanner.nextLine();
                temporaryPrice = scanner.hasNextDouble() ? scanner.nextDouble() : -1.22;

                if (temporaryPrice < 0) {
                    System.out.println("Введено некорректное значение. Повторите ввод используя десятичные дроби, например: 10.22");

                } else {
                    break;
                }
            }
            System.out.println("Блюдо " + temporaryName + " за " + temporaryPrice + " успешно добавлен\n");
            itemsToPrint = itemsToPrint + temporaryName + "\n";
            totalPrice += temporaryPrice;

            System.out.println("Хотите ли вы заказать что-нибудь еще? (для выхода введите \"Завершить\") ");
            String userAnswer = scanner.next();

            if (userAnswer.equalsIgnoreCase("Завершить")) {
                break;
            }

        }
    }
}
