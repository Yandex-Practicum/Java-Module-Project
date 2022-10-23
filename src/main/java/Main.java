import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        Scanner scanner = new Scanner(System.in);
        int input;


        System.out.println("На скольких человек вы хотите разделить счёт?");
        while (true) {
            try {
                input = scanner.nextInt();
                if (input <= 1) {
                    System.out.println("Введите значение больше 1");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите число");
                scanner.nextLine();
            }
        }
        Calculator calc = new Calculator(input);
        calc.add();
        calc.print();
    }
}

