import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int guestCount = 0;
        Scanner scanner = new Scanner(System.in);

        while (!validNumberOfGuests(guestCount)) {
            System.out.println("На сколько человек надо разбить счет?");
            guestCount = scanner.nextInt();
            if (validNumberOfGuests(guestCount)) {
                System.out.println("Отлично!");
            } else {
                System.out.println("Неправильное число гостей");
            }

        }

    }

    public static boolean validNumberOfGuests(int i) {
        if (i > 1) {
            return true;
        } else if (i <= 0) {
            return false;
        }
        return false;
    }
}
