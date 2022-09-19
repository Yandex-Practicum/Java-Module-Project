import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of people dividing the check (2 and more): ");
        int personNum = 0;
        while (scanner.hasNext()) {
            personNum = scanner.nextInt();
            if (personNum < 2) {
                System.out.print("Incorrect input. Enter the number of people 2 or more: ");
            } else {
                break;
            }
        }
        System.out.println("Check calculated for " + personNum + " persons.");
        scanner.close();
    }
}