import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Chceck calculated for " + peopleNum() + " persons.");
    }

    public static int peopleNum(){

        Scanner scanner = new Scanner(System.in);
        int num;

        do {
            System.out.println("How many people devides check? Input peoples number (2 and more).");
            num = scanner.nextInt();
            if (num < 2) {
                System.out.println("Wrong input. Input peoples number (2 and more).");
                num = scanner.nextInt();
            } else {                                               //!добавить проверку на int
                scanner.close();
                return num;
            }
        } while (scanner.hasNext());
        scanner.close();
        return num;
    }
}