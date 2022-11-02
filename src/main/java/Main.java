import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numberOfFriends;

        System.out.println("Программа \"Калькулятор счёта\"");
        numberOfFriends = inputOfFriends();
        calc.input(numberOfFriends);
    }



    public static int inputOfFriends() {
        Scanner scanner = new Scanner(System.in);
        int numberOfFriends;
        do {
            System.out.println("Введите количество друзей: ");
            while (!scanner.hasNextInt()){
                System.out.println("Вы ввели не целое число! Повторите ввод числа друзей:");
                scanner.next();
            }
            numberOfFriends = scanner.nextInt();
            if (numberOfFriends <= 0) {
                System.out.println("Число друзей не может быть равным нулю или быть отрицательным!");
            } else if (numberOfFriends == 1) {
                System.out.println("Число друзей должно быть больше 1 !");
            }
        }
        while (numberOfFriends <= 1);
        return numberOfFriends;
    }

}
