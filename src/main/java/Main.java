import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int guestCount;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("На сколько человек надо разбить счет?");
            try {
                guestCount = scanner.nextInt();
                if (validNumberOfGuests(guestCount)) {
                    System.out.println("Отлично! Давайте посчитаем. \nДля завершения программы нужно вместо товара ввести \"завершить\"");
                    break;
                } else {
                    System.out.println("Вас должно быть больше одного, иначе зачем вам это приложение?");
                }
            } catch (Exception nfe) {
                System.out.println("Убедитесь, что вы вводите целое число.");
                scanner.next(); // очистка сканера, а не то попадем в бесконечную петлю
                //continue;
            }
        }

        // Заводим счетчик, на вход передаем количество гостей.
        LetsCount count = new LetsCount(guestCount);

        // Заводим продукты
        count.inputProduct();

        // Когда завели список покупок
        System.out.println("Сейчас всё посчитаю. \nДобавленные товары: ");
        count.finalReceipt();
        System.out.println("ИТОГО: " + count.subTotal() + " " + count.rubCase(count.subTotal()));

        double duePerGuest = count.duePerGuest(guestCount, count.subTotal());

        System.out.println("Количество человек: " + guestCount + "\nНадо заплатить " +
                String.format("%.2f", duePerGuest) + " " +
                count.rubCase(duePerGuest) +
                " с души.");
    }

    private static boolean validNumberOfGuests(int i) {
        return i > 1;
    }
}