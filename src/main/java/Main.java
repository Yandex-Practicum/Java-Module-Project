import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("На какое количество людей должен быть разделен счет?");
        int count = scanner.nextInt();
        while (count < 1) {
            System.out.println("Неверное количество людей.");
            count = scanner.nextInt();
        }

        calculator.calculate(count);
    }
}
