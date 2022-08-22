import java.util.InputMismatchException;
import java.util.Scanner;

public class Guests {
    int countGuest = 0;
    Scanner scanner = new Scanner(System.in);

    int defineCountGuests() {
        while (true) {
            System.out.println("На скольких человек необходимо рзделить счет?");
            try {
                countGuest = scanner.nextInt();
            } catch (InputMismatchException er) {
                System.out.println("Некорректное значение");
                scanner.nextLine();
                continue;
            }

            if (countGuest <= 1) {
                System.out.println("Ошибка. Введите корректное число гостей:");
                continue;
            }
            return countGuest;

        }
    }
}
