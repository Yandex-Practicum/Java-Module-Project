import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numberOfPerson = setNumberOfPerson();
        Calculator calculator = new Calculator(numberOfPerson);
        calculator.operate();
    }

    public static int setNumberOfPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество человек, на которых нужно разделить счёт:");
        while (true) {
            String input = scanner.nextLine();
            try {
                int numberOfPerson = Integer.parseInt(input);
                if (numberOfPerson <= 1) {
                    System.out.println("Введите корректное число человек > 1:");
                } else {
                    return numberOfPerson;
                }
            }
            catch (Exception e) {
                System.out.println("Введите корректное число человек > 1:");
            }
        }
    }
}

