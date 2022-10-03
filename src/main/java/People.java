import java.util.Scanner;

public class People {
    public static int countPeople;

    public static void howPeople() {
        System.out.println("На скольких человек делим счёт?");
        while (true) {
            Scanner scannerPeople = new Scanner(System.in);
            boolean checkPeople = scannerPeople.hasNextInt();
            if (checkPeople) {
                int passPeople = scannerPeople.nextInt();
                if (passPeople > 1) {
                    countPeople = passPeople;
                    return; // передает в переменную число людей
                } else {
                    System.out.println("Ошибка. Введи целое число больше 1:");
                }
            } else {
                System.out.println("Ошибка. Введи целое число больше 1:");

            }
        }
    }
}
