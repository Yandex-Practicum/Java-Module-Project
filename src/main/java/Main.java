import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int friends = numberOfPersons();
    }

    static int numberOfPersons() {
        Calculator calculator = new Calculator();
        System.out.println("На скольких человек необходимо разделить счёт:");
        int friends = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                friends = scanner.nextInt();
            } else {
                scanner.next();
            }
            if (friends > 1) {
                System.out.println("Делим счет на " + friends + "х");
                calculator.addProduct();
                calculator.addOutput(friends);
                break;
            } else if (friends == 1) {
                System.out.println("Это некорректное значение для подсчёта. Нужно больше 1:");
            } else
                System.out.println("Это некорректное значение . Нужно больше число:");
        }
        return friends;
    }
}