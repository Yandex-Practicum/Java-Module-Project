import java.util.Scanner;

import jdk.nashorn.internal.ir.WhileNode;
import jdk.nashorn.internal.objects.annotations.Where;

public class Main {
    static int people;
    static String name = "";
    static double cost;
    static String end = "Завершить";

    public static void main(String[] args) {
        howPeople();

        System.out.println("Как называется продукт?");
        while (true) {
            Scanner scannerName = new Scanner(System.in);
            String checkName = scannerName.nextLine();
            if (checkName.equalsIgnoreCase(end)) {
                break;
            } else {
                name = name + checkName + "\n";
            }

            System.out.println("Сколько стоил продукт?");
            while (true) {
                Scanner scannerCost = new Scanner(System.in);
                boolean checkCost = scannerCost.hasNextDouble();
                if (checkCost) {
                    double passPeople = scannerCost.nextDouble();
                    if (passPeople > 1) {
                        cost += passPeople;
                        System.out.println("Товар добавлен! Введите название нового товара или напишите \"Завершить\".");
                        break;
                    } else {
                        System.out.println("Введи целое число больше 1:");
                    }
                } else {
                    System.out.println("Ошибка. Введите число;");
                }
            }
        }

        double costPerson = cost / people;
        System.out.println("Добавленные товары:\n" + name);
        System.out.printf("%.2f", costPerson);
        System.out.print(" рублей.");
    }

    // Счет и проверка количества людей
    public static void howPeople() {


        System.out.println("На скольких человек делим счёт?");
        while (true) {
            Scanner scannerPeople = new Scanner(System.in);
            boolean checkPeople = scannerPeople.hasNextInt();
            if (checkPeople) {
                int passPeople = scannerPeople.nextInt();
                if (passPeople > 1) {
                    people = passPeople; // передает в переменную число людей
                    break;
                } else {
                    System.out.println("Введи целое число больше 1:");
                }
            } else {
                System.out.println("Введи целое число больше 1:");

            }
        }
    }
}





/*
class Cat {
    String name;
    int age;
    static int sumCat = 0;

    public void sayMeow() {
        System.out.println("Мяу!");
    }

    // конструктор

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String args[]) {
        Cat mysya = new Cat("Mysya", 4);
        System.out.println(mysya.name + " " + mysya.age);
    }
}
 */ // Учился классам