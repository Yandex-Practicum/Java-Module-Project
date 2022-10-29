import java.util.Scanner;

public class People {

    public static void People(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуйте!");
        int numbOfPeople;

        while (true) {
            System.out.println("На скольких человек разделить счет?");

            if (scanner.hasNextInt()) {
                numbOfPeople = scanner.nextInt();
                if (numbOfPeople > 1) {
                    break;
                }
                if (numbOfPeople <= 1) {
                    System.out.println("Некорректное количество гостей. Пожалуйста попробуйте ввести количество гостей еще раз.");

                }
            }else{
                System.out.println("Некорректное количество гостей. Пожалуйста попробуйте ввести количество гостей в виде числа.");
                scanner.nextLine();
            }
        }

    }

    private int numbOfPeople;
    People() {
        Scanner scanner = new Scanner(System.in);
        this.numbOfPeople = scanner.nextInt();
    }
    public int numbOfPeople() {
        return this.numbOfPeople;
    }
}
