import java.util.Scanner;

public class CountOfGuests {

        static int count; // число гостей
        static Scanner scanner = new Scanner(System.in);

        public static int countOfGuests() {
            System.out.println("Здравствуйте! На сколько человек необходимо разделить счет?");
            while (true) {
            if (scanner.hasNextInt()) {
                int i = scanner.nextInt();
                if (i == 1) {
                    System.out.println("Для одного гостя разбивать счёт нет необходимости. Введите другое число гостей");
                } else if (i < 1) {
                    System.out.println("Гости не пришли. Платить некому. Введите другое число гостей.");
                } else {
                    count = i; // запомнили число гостей
                    break;
                }
            } else {
                System.out.println("Введите целое число");
                scanner.nextLine();
            }
        }
        return count;
    }
}
