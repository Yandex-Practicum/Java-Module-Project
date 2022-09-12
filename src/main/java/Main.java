import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int i;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Доброго дня!\nНа скольких человек необходимо разделить счёт?");

        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Ошибка, введите число.");

        }

        while (true) {
            i = scanner.nextInt();
            if (i <= 1) {
                System.out.println("Введите корректное количество гостей. ");
            }

            if (i > 1) {
                System.out.println();
                break;
            }
        }


        Calculator calculator = new Calculator();
        calculator.addDishes();
        calculator.showResult(i);


    }
}




