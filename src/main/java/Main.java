import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Привет, на скольких человек необходимо разделить счёт?");
        int peopleCount = getCountOfPeople();
        ProductCalculator productCalculator = new ProductCalculator(peopleCount);
        productCalculator.inputProducts();
    }

    public static int getCountOfPeople() {
        int peopleCount = 0;

        while (true) {
            try {
                peopleCount = scanner.nextInt();

                if (isCorrectPeopleCount(peopleCount)) {
                    break;
                }
            } catch (InputMismatchException er) {
                System.out.println("Некоректное значение, попробуйте другое");
                scanner.nextLine();
            }
        }
        return peopleCount;
    }

    public static boolean isCorrectPeopleCount(int peopleCount) {
        if (peopleCount <= 0) {
            System.out.println("Количество человек меньше 1. Это некорректное значение для подсчёта. Введите новое значение.");
            return false;
        } else if (peopleCount == 1) {
            System.out.println("Количество человек, введённых пользователем равно 1. В этом случае нет смысла ничего считать и делить. Введите новое значение.");
            return false;
        } else {
            return true;
        }
    }
}