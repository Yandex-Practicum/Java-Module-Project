
import java.util.Scanner;

public class Main {

    private static Scanner scan;

    public static void main(String[] args) {

        // Обработка ввода количества гостей пользователем.
        System.out.println("How many persons?");
        int person = 0;
        int min = 1;
        while (true) {
            if (getInt(min) > min) {
                break;
            }
        }

        // Обработка ввода названия товара пользователем.
        System.out.println("Product name:");
    }


    public static int getInt(int min) {
        int a = 0;
        scan = new Scanner(System.in);
        if (!scan.hasNextInt()) {
            System.out.println("this is not a number, try again.");
        } else if (scan.hasNextInt()) {
            a = scan.nextInt();
            if (a <= min) {
                System.out.println("this is not a valid value, try again.");
            }
        }
        return a;
    }
}



