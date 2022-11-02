import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int countOfPersons = inputPersonCount();

        CostCalculator costCalculator = new CostCalculator(countOfPersons);

        costCalculator.addProducts();
    }

    private static int inputPersonCount() {

        Scanner scanner = new Scanner(System.in);

        int countOfGuests;

        while (true) {
            System.out.println("Введите количество гостей:");

            while (!scanner.hasNextInt()) {
                System.out.println("Вы ввели не целое число. Повторите ввод количества гостей:");
                scanner.next();
            }

            countOfGuests = scanner.nextInt();
            if (countOfGuests <= 1) {
                System.out.println("Количество гостей должно быть больше 1.");
            } else {
                break;
            }
        }

        return countOfGuests;
    }
}