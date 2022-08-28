import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        int people = addPeople();

    }
    static int addPeople() {
        Calculator calc = new Calculator();
        System.out.println("На скольких человек необходимо разделить счёт?");
        int people=0;
        while (true) {
            if (scanner.hasNextInt()) {
                people = scanner.nextInt();
            } else {
                scanner.next();
            }
            if (people > 1) {
                System.out.println("Делим счет на " + people + "х");
                calc.addProduct();
                calc.printInfo(people);
                break;
            } else if (people == 1) {
                System.out.println("Счет не делится на одного посетителя!");
            }else
                System.out.println("Некорректное значение, попробуйте снова!");
        }
        return people;
    }
}