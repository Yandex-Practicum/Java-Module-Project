import java.util.Scanner;

public class InputNumberOfPersons {

    private final Scanner scanner;

    public InputNumberOfPersons(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputNumberOfPersons() {
        int numberOfPersons;
        System.out.println("Введите, на скольких человек необходимо разделить счёт:");
        while (true) {
            if (scanner.hasNextInt()) {
                numberOfPersons = scanner.nextInt();
                if (numberOfPersons > 1) {
                    break;
                }
            }
            System.out.println("Количество человек должно быть целым числом больше 1. Повторите попытку:");
            scanner.nextLine();
        }
        return numberOfPersons;
    }
}
