import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("На сколько человек вы хотели бы разделить чек?");
        int numPeople = scan.nextInt();
        while (1 < 4) {
            if (numPeople > 1) {
                break;
            }
            System.out.println("Ошибка. Невозможно разделить чек на данное колличество людей. Попробуйте снова.");
            numPeople = scan.nextInt();
        }
        double check = calc.calculator()/numPeople;
        System.out.println("Каждый человек должен заплатить: " + check);
    }
}