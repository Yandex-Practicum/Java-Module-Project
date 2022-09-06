import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        int count = 0;

        System.out.println("На какое количество людей должен быть разделен счет?");
        while (count <= 1) {
            String peopleCount = scanner.nextLine();
            try {
                count = Integer.parseInt(peopleCount);
            } catch (NumberFormatException e) {
                System.out.println("Количество нужно вводить в цифровом формате.");
                count = 0;
                continue;
            }
            if (count <= 1) {
                System.out.println("Количество людей не может быть меньше двух.");
            }
        }

        calculator.calculate(count);
    }
}
