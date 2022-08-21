import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Calculate calculate = new Calculate();
        int countPerson;
        System.out.println("На скольких человек разделить счет?");

        while (true) {
            try {
                countPerson = Integer.parseInt(scanner.next());
                if (countPerson <= 1) {
                    System.out.println("Неверный ввод. Должно быть не менее 2 человек. Введите заново.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ввод неверный. Повторите ввод:");
            }
        }
        calculate.addProduct(scanner, countPerson);
    }
}