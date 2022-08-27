import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        int people;
        while (true) {
            System.out.println("На сколько человек нужно разделить счет?");
            Scanner scanner = new Scanner(System.in);
            people = scanner.nextInt();
            if (people >= 2) {
                break;
            } else {
                System.out.println("Неверное значение");
            }
        }

        Calculator calculator = new Calculator();
        Calculator.calculate(people);

    }
    public static String declination(int rouble) {
        switch (rouble % 10) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}

