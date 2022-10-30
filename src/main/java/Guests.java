import java.util.Locale;
import java.util.Scanner;

public class Guests {
    int numberOfGuests;

    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    //fun to get number of guests with some incorrect input catching
    void getGuestsNumber(){
        while (true) {

            numberOfGuests = scanner.hasNextInt()? scanner.nextInt(): -1;

            if (numberOfGuests == 1) {
                System.out.println("Введено некорректное значение. Нельзя разбить счет на одного человека. Введите количество гостей больше 1.");
            } else if (numberOfGuests < 1) {
                System.out.println("Введено некорректное значение. Используйте положительные целые числа");
                scanner.nextLine();
            }
            else {
                break;
            }
        }
    }
}
