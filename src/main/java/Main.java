
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        int peopleCount = getPeopleCount();
        Calculator calculator = new Calculator(peopleCount);
        calculator.doCalculate();
    }
    static int getPeopleCount() {
        int peopleCount;
        System.out.println("На сколько человек делим счет?");
        while (true) {
            peopleCount = scanner.nextInt();
            if (peopleCount > 1) {
                System.out.println("Делим счет на " + peopleCount + "х");
                return peopleCount;
            }
            else if (peopleCount == 1) {
                System.out.println("Счет не делится на одного посетителя!");
            }
            System.out.println("Некорректное значение, попробуйте снова!");
            }
        }
    }
