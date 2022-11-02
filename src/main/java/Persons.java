import java.util.Scanner;

public class Persons {

    public static void enterPersons() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На скольких человек разделить счёт?\nВведите количество посетителей от 2 до 1000");

        while (true) {
            if (scanner.hasNextInt()){
            Main.persons = scanner.nextInt();

            if (Main.persons > 1 && Main.persons < 1000) {
                System.out.printf("Введено %d посетителей\n", Main.persons);
                break;
            }} else {
            System.out.println("Ошибка ввода. Попробуйте ещё раз.");
            scanner.next();
        }
    }
}}