import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        Scanner scanner = new Scanner(System.in);
        int input;

        while (true) {
            try {
                System.out.println("На скольких человек вы хотите разделить счёт?");
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

class Calculator {
    HashMap<String, Double> products = new HashMap<>();
    int persons;
    double sum;
    double payment;
    private Scanner scanner = new Scanner(System.in);
    private String input;
    private Double dInput;
    Calculator (int persons) {
        this.persons = persons;
    }

    void add() {
        while (true) {
            System.out.println("Введите название товара: ");
            input = scanner.nextLine();
            System.out.println("Введите стоимость товара в формате: рубли.копейки ");

            try {
                dInput = scanner.nextDouble();
            }
            catch (InputMismatchException e) {
                System.out.println("Введите число");
                scanner.nextLine();
                continue;
            }

            if (dInput < 0) {
                System.out.println("Введите стоимость больше нуля");
                scanner.nextLine();
            }
            else {
                products.put(input, dInput);
                sum += dInput;
                System.out.println("Товар успешно добавлен!");
                scanner.nextLine();
                System.out.println("Хотите добавить ещё товар? Введите \"Завершить\", чтобы закончить ввод.");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("завершить")) {
                    break;
                }
            }

        }
    }

    void print() {
        payment = sum / persons;
        System.out.println("Добавленные товары:");
        products.forEach((key, value) -> {
            if (Math.floor(value) % 10 == 2 || Math.floor(value) % 10 == 3 || Math.floor(value) % 10 == 4) {
                System.out.println(key + " " + value + " рубля");
            } else if (Math.floor(value) % 10 == 1 && Math.floor(value) % 100 != 11) {
                System.out.println(key + " " + value + " рубль");
            } else {
                System.out.println(key + " " + value + " рублей");
            }
        });
        System.out.println("Каждый должен заплатить:");
        format(payment);

    }

    void format(double payment) {
        if (Math.floor(payment) % 10 == 2 || Math.floor(payment) % 10 == 3 || Math.floor(payment) % 10 == 4) {
            System.out.println(String.format("%.2f", payment) + " рубля");
        } else if (Math.floor(payment) % 10 == 1 && Math.floor(payment) % 100 != 11) {
            System.out.println(String.format("%.2f", payment) + " рубль");
        } else {
            System.out.println(String.format("%.2f", payment) + " рублей");
        }
    }
}
