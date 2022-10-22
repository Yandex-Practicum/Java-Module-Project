import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // количество посетителей
        int numberOfVisitors = getNumberOfVisitors();

        // объект типа Calculator
        Calculator calculator = new Calculator(numberOfVisitors);


    }

    /* спрашивает у пользователя, на скольких человек необходимо разделить счёт
    и возвращает это значение
     */
    private static int getNumberOfVisitors() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("На скольких человек нужно разделить счет?");
            String response = scanner.next();
            if (isNumeric(response)) {
                int intValue = Integer.parseInt(response);
                if (intValue <= 1) {
                    System.out.println("Значение должно быть больше 1...");
                } else {
                    return intValue;
                }
            } else {
                System.out.println("Введите корректное значение...");
            }
        }
    }

    // Проверяет, является введенное пользователем значение целочисленным числом, иначе возвращает false
    private static boolean isNumeric(String string) {
        try {
            int intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
