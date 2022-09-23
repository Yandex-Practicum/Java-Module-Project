import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.print("На сколько человек разделить счет? ");
        int numberOfPersons;
        while (true) {
            if (sc.hasNextInt()) {
                numberOfPersons = sc.nextInt();
                if (numberOfPersons > 1) {
                    System.out.println();
                    sc.nextLine();
                    break;
                } else {
                    System.out.print("Число должно быть больше 1. Попробуйте еще раз: ");
                    sc.nextLine();
                }
            } else {
                System.out.print("Необходимо ввести целое число. Попробуйте еше раз: ");
                sc.nextLine();
            }
        }

        while (true) {
            Product p = new Product();
            System.out.print("Введите наименование товара: ");
            p.setName(sc.nextLine());
            System.out.print("Введите цену товара в формате \"12,34\": ");
            while (true) {
                if (sc.hasNextDouble()) {
                    p.setPrice(sc.nextDouble());
                    if (p.getPrice() < 0) {
                        System.out.print("Цена товара должна быть не меньше 0. Попробуйте еще раз: ");
                        sc.nextLine();
                    } else {
                        System.out.println();
                        break;
                    }
                } else {
                    System.out.print("Цена товара должна быть в формате \"12,34\". Попробуйте еще раз: ");
                    sc.nextLine();
                }
            }

            calculator.addProduct(p);

            System.out.print("Если хотите продолжить ввод, введите любой текст. Если хотите завершить ввод товаров, введите \"Завершить\":  ");
            if (sc.next().equalsIgnoreCase("завершить")) {
                System.out.println();
                break;
            } else {
                System.out.println();
                sc.nextLine();
            }
        }

        System.out.println("Полный список товаров:");
        System.out.println(calculator.allProducts);
        System.out.printf("Общая стоимость продуктов: %.2f%n", calculator.totalPrice);
        System.out.printf("Каждый должен по %.2f%n", calculator.calculateShare(numberOfPersons));

    }
}
