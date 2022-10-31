import java.util.Scanner;

public class People {

    static int numbOfPeople;
    public static int numbOfPeople() {
        return numbOfPeople;
    }

    public static void countingPeople(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуйте!");
        while (true) {
            System.out.println("На скольких человек разделить счет?");
            if (scanner.hasNextInt()) {
                numbOfPeople = scanner.nextInt();
                if (numbOfPeople > 1) {
                    break;
                }
                if (numbOfPeople <= 1) {
                    System.out.println("Нет смысла делить счет меньше чем на двух человек! Пожалуйста, введите количество человек еще раз.");
                }
            }else{
                System.out.println("Некорректное количество гостей. Пожалуйста, введите количество человек еще раз.");
                scanner.nextLine();
            }
        }
    }
}